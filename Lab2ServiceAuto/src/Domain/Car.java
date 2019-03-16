package Domain;

public class Car {
    private String id;
    private String model;
    private int purchaseYear;
    private int kmNumber;
    private boolean guarantee;

    public Car(String id, String model, int purchaseYear, int kmNumber, boolean guarantee) {
        this.id = id;
        this.model = model;
        this.purchaseYear = purchaseYear;
        this.kmNumber = kmNumber;
        this.guarantee = guarantee;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", purchaseYear=" + purchaseYear +
                ", kmNumber=" + kmNumber +
                ", guarantee=" + guarantee +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(int purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public int getKmNumber() {
        return kmNumber;
    }

    public void setKmNumber(int kmNumber) {
        this.kmNumber = kmNumber;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }
}