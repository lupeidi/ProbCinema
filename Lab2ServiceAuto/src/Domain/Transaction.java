package Domain;

public class Transaction {
    private String id;
    private String id_car;
    private String id_client;
    private int quantity;
    private int assembly;
    private String date;
    private String hour;
    private double totalPrice;
    private int discount;

    public Transaction(String id, String id_car, String id_client, int quantity, int assembly, String date, String hour) {
        this.id = id;
        this.id_car = id_car;
        this.id_client = id_client;
        this.quantity = quantity;
        this.assembly = assembly;
        this.date = date;
        this.hour = hour;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", id_car='" + id_car + '\'' +
                ", id_client='" + id_client + '\'' +
                ", quantity=" + quantity +
                ", assembly=" + assembly +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_car() {
        return id_car;
    }

    public void setId_car(String id_car) {
        this.id_car = id_car;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAssembly() {
        return assembly;
    }

    public void setAssembly(int assembly) {
        this.assembly = assembly;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}