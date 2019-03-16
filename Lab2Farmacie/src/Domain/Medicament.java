package Domain;

public class Medicament {
    private String id;
    private String name;
    private String manufacterer;
    private double price;
    private boolean prescription;

    public Medicament(String id, String name, String manufacterer, double price, boolean prescription) {
        this.id = id;
        this.name = name;
        this.manufacterer = manufacterer;
        this.price = price;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacterer='" + manufacterer + '\'' +
                ", price=" + price +
                ", prescription=" + prescription +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacterer() {
        return manufacterer;
    }

    public void setManufacterer(String manufacterer) {
        this.manufacterer = manufacterer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }
}


