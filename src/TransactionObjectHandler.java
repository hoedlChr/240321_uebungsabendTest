import java.io.*;
import java.util.ArrayList;

public class TransactionObjectHandler {
    public void saveTransactions(ArrayList<Transaction> list, String path) throws TransactionObjectException {
//        try(
//                BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(path));
//                BufferedWriter bw = new BufferedWriter(new FileWriter(path));
//
//        ){
//            for(Transaction t : list){
////                bs.write(t);
//                bw.write(t.toString());
//                bw.write("\n");
//            }
//            bs.flush();
//            bw.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(list);
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new TransactionObjectException("something went wrong",e);
        } catch (IOException e) {
            throw new TransactionObjectException("something went wrong",e);
        }
    }
}
