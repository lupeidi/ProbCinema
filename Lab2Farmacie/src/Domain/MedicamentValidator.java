package Domain;

public class MedicamentValidator {
    public void validate(Medicament medicament) {
        if (medicament.getPrice() <= 0 ){
            throw new RuntimeException("The price must be greater than 0!");
        }
    }
}
