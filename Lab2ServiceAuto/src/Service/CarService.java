package Service;

import Domain.Car;
import Repository.CarRepository;

import java.util.List;

public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public void add(String id, String model, int purchaseYear, int kmNumber, boolean guarantee){
        Car car = new Car(id, model, purchaseYear, kmNumber, guarantee);
        repository.add(car);
    }

    public void update(String id, String model, int purchaseYear, int kmNumber, boolean guarantee){
        Car car = new Car(id, model, purchaseYear, kmNumber, guarantee);
        repository.update(car);
    }

    public void remove(String id){
        repository.remove(id);
    }

    public List<Car> getAll() {
        return repository.getAll();
    }
}
