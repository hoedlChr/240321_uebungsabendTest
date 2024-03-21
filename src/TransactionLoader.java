import java.io.*;
import java.util.ArrayList;

public class TransactionLoader {
    //this sind diese Variablen:
    private ArrayList<Transaction> list = new ArrayList<>();

    public ArrayList<Transaction> getList() {
        return list;
    }

    public void loadTransactions(String path) throws LoadException {
//        Alternative:
//            File f = new File(path);
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//
//            br.close();
//            fr.close();

        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
//            System.out.println("br.readLine() = " + br.readLine());
            String helpLine;
            int count = 0;

//            br.readLine();//header überspringen

            while((helpLine = br.readLine()) != null){

                String[] arrHelpLine = helpLine.split(";");
                if(count != 0){//Header Überspringen
                    Transaction myHelpTrans = new Transaction(
                            arrHelpLine[0],
                            arrHelpLine[1],
                            Double.parseDouble(arrHelpLine[2]),
                            arrHelpLine[3],
                            arrHelpLine[4],
                            arrHelpLine[5],
                            arrHelpLine[6],
                            arrHelpLine[7]
                    );
    //                int myList = 0;
                    this.list.add(myHelpTrans);//hier hab ich this genommen, damit ich das ArrayList nehme und nicht int
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new LoadException("file not found "+path, e);
        } catch (IOException e) {
            throw new LoadException("File could not be loaded "+path, e);
        }
    }
}
