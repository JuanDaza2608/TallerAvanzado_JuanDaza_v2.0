package co.com.bancolombia.usecase.crudanimalsusercase;

import co.com.bancolombia.model.animals.Animals;
import co.com.bancolombia.model.animals.gateways.AnimalsRepository;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CrudAnimalsUserCaseUseCase {
    private AnimalsRepository animalRepository;

    public void create(Animals animal) {
        animalRepository.create(animal);
    }

    public Animals read(String id) {
        return animalRepository.read(id);
    }

    public Animals update(String id, Animals animal) throws Exception {
        animalRepository.update(id, animal);
        return animal;
    }

    public void delete(String id) {
        animalRepository.delete(id);
    }

    public List<Animals> getAll() {
        return animalRepository.getAll();
    }


}
