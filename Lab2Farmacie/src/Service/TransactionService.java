package Service;

import Domain.Transaction;
import Repository.ClientRepository;
import Repository.MedicamentRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    private TransactionRepository repository;
    private MedicamentRepository medicamentRepository;
    private ClientRepository clientRepository;

    public TransactionService(TransactionRepository repository, MedicamentRepository medicamentRepository, ClientRepository clientRepository) {
        this.repository = repository;
        this.medicamentRepository = medicamentRepository;
        this.clientRepository = clientRepository;
    }

    public void add(String id, String id_medicament, String id_client, int quantity, String date, String hour){
        Transaction transaction = new Transaction(id, id_medicament, id_client, quantity, date, hour);
        if (clientRepository.getById(id_client) != null){
            if (medicamentRepository.getById(id_medicament).isPrescription()) {
                transaction.setDiscount(15);
            }
            else transaction.setDiscount(10);
        }

        transaction.setTotalPrice(transaction.getQuantity() * medicamentRepository.getById(id_medicament).getPrice());
        transaction.setTotalPrice(transaction.getTotalPrice() * ((float)transaction.getDiscount() / 100.f));
        repository.add(transaction);
    }

    public void update(String id, String id_medicament, String id_client, int quantity, String date, String hour){
        Transaction transaction = new Transaction(id, id_medicament, id_client, quantity, date, hour);

        if (clientRepository.getById(id_client) != null){
            if (medicamentRepository.getById(id_medicament).isPrescription()) {
                transaction.setDiscount(15);
            }
            else transaction.setDiscount(10);
        }

        transaction.setTotalPrice(transaction.getQuantity() * medicamentRepository.getById(id_medicament).getPrice());
        transaction.setTotalPrice(transaction.getTotalPrice() * (transaction.getDiscount() / 100));
        repository.update(transaction);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Transaction> getAll() {
        return repository.getAll();
    }
}
