package Repository;

import Domain.Transaction;
import Domain.TransactionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {
    private Map<String, Transaction> storage = new HashMap<>();
    private TransactionValidator validator;

    public TransactionRepository(TransactionValidator validator) {
        this.validator = validator;
    }

    public Transaction getById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a transaction if it already exists.
     * @param transaction the transaction to add or update.
     */
    public void add(Transaction transaction) {
        if (storage.containsKey(transaction.getId())) {
            throw new RuntimeException(String.format("There already is a transaction with that id"));
        }
        validator.validate(transaction);
        storage.put(transaction.getId(), transaction);
    }

    public void update(Transaction movie) {
        if (!storage.containsKey(movie.getId())) {
            throw new RuntimeException(String.format("There is no transaction with that id"));
        }
        validator.validate(movie);
        storage.put(movie.getId(), movie);
    }

    /**
     * Removes a transaction with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no transaction with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no transaction with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(storage.values());
    }
}
