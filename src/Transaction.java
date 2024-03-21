import java.io.Serializable;
import java.util.Objects;

public class Transaction implements Serializable {

private String transactionDate;
private String product;
private double price;
private String paymentType;
private String name;
private String city;
private String state;
private String country;

    public Transaction(String transactionDate, String product, double price, String paymentType, String name, String city, String state, String country) {
        this.transactionDate = transactionDate;
        this.product = product;
        this.price = price;
        this.paymentType = paymentType;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return
                 transactionDate + ';' +
                 product + ';' +
                 price + ';' +
                 paymentType + ';' +
                 name + ';' +
                 city + ';' +
                 state + ';' +
                 country ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(product, that.product) && Objects.equals(paymentType, that.paymentType) && Objects.equals(name, that.name) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, product, price, paymentType, name, city, state, country);
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
