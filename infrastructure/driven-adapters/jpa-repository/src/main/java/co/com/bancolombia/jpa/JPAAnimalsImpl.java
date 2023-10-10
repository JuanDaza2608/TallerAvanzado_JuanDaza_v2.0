package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animals.Animals;
import co.com.bancolombia.model.animals.gateways.AnimalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JPAAnimalsImpl implements AnimalsRepository {
    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Animals animal) {
        String id = UUID.randomUUID().toString();
        animal.setId(id);
        jpaRepositoryAdapter.save(animal);
    }

    @Override
    public Animals read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public Animals update(String id, Animals animal) throws Exception {
        Animals productDb = jpaRepositoryAdapter.findById(id);

        if (productDb == null) throw new Exception("Product Not Found : " + id);

        productDb.setPatas(animal.getPatas());
        productDb.setGenero(animal.getGenero());
        productDb.setEspecie(animal.getEspecie());
        productDb.setHabitad(animal.getHabitad());
        productDb.setDomestico(animal.getDomestico());

        jpaRepositoryAdapter.save(productDb);
        return productDb;
    }

    @Override
    public void delete(String id) {
        jpaRepositoryAdapter.deleteById(id);
    }

    @Override
    public List<Animals> getAll() {
        return jpaRepositoryAdapter.findAll();
    }



}
