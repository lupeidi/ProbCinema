package Repository;

import Domain.Medicament;
import Domain.MedicamentValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentRepository {
    private Map<String, Medicament> storage = new HashMap<>();
    private MedicamentValidator validator;

    public MedicamentRepository(MedicamentValidator validator){
        this.validator = validator;
    }

    public Medicament getById(String Id){
        return storage.get(Id);
    }

    public void add(Medicament medicament) {
        if (storage.containsKey(medicament.getId())) {
            throw new RuntimeException(String.format("There already is a medicament with that id"));
        }
        validator.validate(medicament);
        storage.put(medicament.getId(), medicament);
    }

    public void update(Medicament medicament) {
        if (!storage.containsKey(medicament.getId())) {
            throw new RuntimeException(String.format("There is no medicament with that id"));
        }
        validator.validate(medicament);
        storage.put(medicament.getId(), medicament);
    }

    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException(String.format("There is no medicament with that id"));
        }
        storage.remove(id);
    }

    public List<Medicament> getAll() {
        return new ArrayList<>(storage.values());
    }
}
