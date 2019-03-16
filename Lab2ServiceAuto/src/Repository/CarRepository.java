package Repository;

import Domain.Car;
import Domain.CarValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private Map<String, Car> storage = new HashMap<>();
    private CarValidator validator;

    public CarRepository(CarValidator validator){
        this.validator = validator;
    }

    public Car getById(String Id){
        return storage.get(Id);
    }

    public void add(Car car) {
        if (storage.containsKey(car.getId())) {
            throw new RuntimeException(String.format("There already is a car with that id"));
        }
        validator.validate(car);
        storage.put(car.getId(), car);
    }

    public void update(Car car) {
        if (!storage.containsKey(car.getId())) {
            throw new RuntimeException(String.format("There is no car with that id"));
        }
        validator.validate(car);
        storage.put(car.getId(), car);
    }

    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException(String.format("There is no car with that id"));
        }
        storage.remove(id);
    }

    public List<Car> getAll() {
        return new ArrayList<>(storage.values());
    }
}
