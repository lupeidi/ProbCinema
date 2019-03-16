package Domain;

public class CarValidator {
    public void validate(Car car) {
        if (car.getKmNumber() <= 0){
            throw new RuntimeException("The number of km must be greater than 0!");
        }
        if (car.getPurchaseYear() <= 0){
            throw new RuntimeException("The year of acquisition must be greater than 0!");
        }
    }
}
