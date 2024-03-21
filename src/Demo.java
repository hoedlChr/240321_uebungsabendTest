import java.io.Serializable;
import java.util.Comparator;

public class Demo  {
    public static void main(String[] args) {
        String path = "/Users/christophhodl/Downloads/transactions.csv";

        try{
            TransactionLoader myLoader = new TransactionLoader();

            myLoader.loadTransactions(path);
//            System.out.println(myLoader.getList());

//            myLoader.getList().sort(new PriceProductComparator());

            PriceProductComparator ppc = new PriceProductComparator();
            myLoader.getList().sort(ppc);

//            System.out.println("myLoader.myList = " + myLoader.getList());

            TransactionObjectHandler toh = new TransactionObjectHandler();
            toh.saveTransactions(myLoader.getList(), "/Users/christophhodl/Downloads/transactions-new.csv");

            TransactionManager tm = new TransactionManager(myLoader.getList());
            System.out.println("tm.getTransactionCountByCity() = " + tm.getTransactionCountByCity());
            System.out.println("tm.getCountOfTransaction(\"United States\") = " + tm.getCountOfTransaction("United States"));
            System.out.println("tm.getCountOfTransaction1(\"Canada\") = " + tm.getCountOfTransaction1("Canada"));
            System.out.println("tm.getTransactionsToProduct(\"Product1\") = " + tm.getTransactionsToProduct("Product1"));
            System.out.println("tm.getAverageTransactionAmountByPaymentType() = " + tm.getAverageTransactionAmountByPaymentType());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
