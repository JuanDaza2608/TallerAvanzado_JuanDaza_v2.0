package co.com.bancolombia.model.animals.gateways;

import co.com.bancolombia.model.animals.Animals;

import java.util.List;

public interface AnimalsRepository {
    void create(Animals animal);

    Animals read(String id);

    default Animals update(String id, Animals animal) throws Exception {
        return animal;
    }

    void delete(String id);

    List<Animals> getAll();
}
