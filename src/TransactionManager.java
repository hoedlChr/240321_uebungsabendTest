import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransactionManager {
    private ArrayList<Transaction> list = new ArrayList<>();

    public TransactionManager(ArrayList<Transaction> list) {
        this.list = list;
    }

    public HashMap<String, Integer> getTransactionCountByCity(){
        HashMap<String, Integer> myHash = new HashMap<>();

        for(Transaction t: list){
            if(myHash.get(t.getCity()) == null){
                myHash.put(t.getCity(), 1);
            } else {
                int counter = myHash.get(t.getCity()) + 1;
                myHash.put(t.getCity(),counter);
            }
        }
        return myHash;
    }

    public Integer getCountOfTransaction(String country){
        HashMap<String, Integer> myHash = new HashMap<>();

        for(Transaction t: list){
            if(myHash.get(t.getCountry()) == null){
                myHash.put(t.getCountry(), 1);
            } else {
                int counter = myHash.get(t.getCountry()) + 1;
                myHash.put(t.getCountry(),counter);
            }
        }
        return myHash.get(country);
    }

    public Integer getCountOfTransaction1(String country){
        int counter = 0;

        for(Transaction t: list){
            if(t.getCountry().equals(country)){
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<Transaction> getTransactionsToProduct(String product){
        ArrayList<Transaction> mylist = new ArrayList<>();
        for(Transaction t: list){
            if(t.getProduct().equals(product))
                mylist.add(t);
        }
        return  mylist;
    }

    public HashMap<String, Double> getAverageTransactionAmountByPaymentType(){
        HashMap<String, Double> returnValue = new HashMap<>();

        HashMap<String, Double> gesamtWert = new HashMap<>();
        HashMap<String, Integer> gesamtAnzahl = new HashMap<>();
        for(Transaction t: list){
            String helpType = t.getPaymentType();
            if(gesamtAnzahl.get(helpType) == null){
                gesamtAnzahl.put(helpType, 0);
                gesamtWert.put(helpType, 0.0);
            } else {
                int helpAnzahl = gesamtAnzahl.get(t.getPaymentType()) + 1;
                double helpWert = gesamtWert.get(t.getPaymentType()) + t.getPrice();
                gesamtAnzahl.put(helpType, helpAnzahl);
                gesamtWert.put(helpType, helpWert);
            }
        }

        for(Map.Entry<String, Integer> entry: gesamtAnzahl.entrySet()){
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());

            double avg = gesamtWert.get(entry.getKey()) / entry.getValue();

            returnValue.put(entry.getKey(),avg);
        }

        return returnValue;
    }
}
