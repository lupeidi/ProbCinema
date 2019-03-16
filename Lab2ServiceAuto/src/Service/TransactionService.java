package Service;

import Domain.Transaction;
import Repository.ClientRepository;
import Repository.CarRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    private TransactionRepository repository;
    private CarRepository carrepository;
    private ClientRepository clientrepository;

    public TransactionService(TransactionRepository repository,CarRepository carRepository,ClientRepository clientRepository) {

        this.repository = repository;
        this.carrepository = carRepository;
        this.clientrepository = clientRepository;
    }

    public void add(String id, String id_car, String id_client, int quantity, int assembly, String date, String hour){
        Transaction transaction = new Transaction( id,  id_car,  id_client,  quantity,  assembly,  date,  hour);

        if (clientrepository.getById(id_client) != null){
            transaction.setDiscount(10);}
        if (carrepository.getById(id_car).isGuarantee()) {
            transaction.setAssembly(0);
        }

        transaction.setTotalPrice(transaction.getQuantity() * ((100 - transaction.getDiscount()) * 0.01) + transaction.getAssembly());
        repository.add(transaction);
    }

    public void update(String id, String id_car, String id_client, int quantity, int assembly, String date, String hour){
        Transaction transaction = new Transaction(id,  id_car,  id_client,  quantity,  assembly,  date,  hour);

        if (clientrepository.getById(id_client) != null){
            transaction.setDiscount(10);}
        if (carrepository.getById(id_car).isGuarantee()) {
            transaction.setAssembly(0);
        }

        transaction.setTotalPrice(transaction.getQuantity() * ((100 - transaction.getDiscount()) * 0.01) + transaction.getAssembly());

        repository.update(transaction);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Transaction> getAll() {
        return repository.getAll();
    }
}
