import java.util.Comparator;

public class PriceProductComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        int help = Double.compare(o1.getPrice(), o2.getPrice());
        if(help == 0){
            help = o2.getProduct().compareTo(o1.getProduct());
        }
        return help;
    }
}
