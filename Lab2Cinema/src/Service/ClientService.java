package Service;

import Domain.Client;
import Repository.ClientRepository;
import Repository.IRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private IRepository<Client> repository;

    public ClientService(IRepository<Client> repository) {
        this.repository = repository;
    }

    public void addOrUpdate (String id, String firstName, String lastName, String cnp, LocalDate birthdayDate, LocalDate registrationDate, int points){
        Client client = new Client(id, firstName, lastName, cnp, birthdayDate, registrationDate, points);
        List<Client> clients = new ArrayList<>(repository.getAll());
        for (Client i : clients) {
            if (cnp.equals(i.getCnp())) {
                throw new RuntimeException("CNP already exists");
            }
        }
        repository. upsert(client);
    }


    public void remove(String id) {
        repository.remove(id);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

    public List<Client> textSearchClients(String text) {
        List<Client> found = new ArrayList<>();
        for ( Client i: repository.getAll() ) {
            if ((i.getId().contains(text) || i.getFirstName().contains(text) || i.getLastName().contains(text) || i.getCnp().contains(text) ) && !found.contains(i)) {
                found.add(i);
            }
        }
        return found;
    }

    public List<Client> periodSearchClients (LocalDate start, LocalDate end) {
        List<Client> found = new ArrayList<>();
        for ( Client i: repository.getAll() ) {
            if ( (i.getBirthdayDate().isAfter(start) && i.getBirthdayDate().isBefore(end)) || ( i.getRegistrationDate().isAfter(start) && i.getRegistrationDate().isBefore(end))) {
                found.add(i);
            }
        }
        return found;
    }

    public void bonusPoints (LocalDate start, LocalDate end, int bonus) {
        for ( Client i: repository.getAll() ) {
            if (i.getBirthdayDate().getDayOfYear() > start.getDayOfYear() && i.getBirthdayDate().getDayOfYear() < end.getDayOfYear()) {
                i.setPoints(i.getPoints() + bonus );
            }
        }
    }
}
