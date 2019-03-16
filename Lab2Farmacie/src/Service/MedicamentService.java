package Service;

import Domain.Medicament;
import Repository.MedicamentRepository;

import java.util.List;

public class MedicamentService {
    private MedicamentRepository repository;

    public MedicamentService(MedicamentRepository repository){
        this.repository = repository;
    }

    public void add(String id, String name, String manufacturer, double price, boolean prescription){
        Medicament medicament = new Medicament(id, name, manufacturer, price, prescription);
        repository.add(medicament);
    }

    public void update(String id, String name, String manufacturer, double price, boolean prescription){
        Medicament medicament = new Medicament(id, name, manufacturer, price, prescription);
        repository.update(medicament);
    }

    public void remove(String id){
        repository.remove(id);
    }

    public List<Medicament> getAll() {
        return repository.getAll();
    }
}
