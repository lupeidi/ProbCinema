package Service;

import Domain.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {
    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void add(String id, String firstName, String lastName, String cnp, String birthdayDate, String registrationDate, int points){
        Client client = new Client(id, firstName, lastName, cnp, birthdayDate, registrationDate, points);
       /*
        List<Client> all = null;
        repository.getAll();
        for (Client c: all){
            if (c.getCnp().equals(cnp)){
                throw new RuntimeException("Cnp already exists!");
            }
         */


        repository.add(client);
    }

    public void update(String id, String firstName, String lastName, String cnp, String birthdayDate, String registrationDate, int points){
        Client client = new Client(id, firstName, lastName, cnp, birthdayDate, registrationDate, points);
        repository.update(client);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }
}
