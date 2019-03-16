package Domain;

public class Transaction {
    private String id;
    private String id_medicament;
    private String id_client;
    private int quantity;
    private String date;
    private String hour;
    private double totalPrice;
    private int discount;

    public Transaction(String id, String id_medicament, String id_client, int quantity, String date, String hour) {
        this.id = id;
        this.id_medicament = id_medicament;
        this.id_client = id_client;
        this.quantity = quantity;
        this.date = date;
        this.hour = hour;
        this.totalPrice = 0;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", id_medicament='" + id_medicament + '\'' +
                ", id_client='" + id_client + '\'' +
                ", quantity=" + quantity +
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

    public String getId_medicament() {
        return id_medicament;
    }

    public void setId_medicament(String id_medicament) {
        this.id_medicament = id_medicament;
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
