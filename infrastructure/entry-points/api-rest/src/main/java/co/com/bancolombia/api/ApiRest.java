package co.com.bancolombia.api;
import co.com.bancolombia.model.animals.Animals;
import co.com.bancolombia.usecase.crudanimalsusercase.CrudAnimalsUserCaseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;

    private final CrudAnimalsUserCaseUseCase crudAnimalUseCase;

    @GetMapping("/prueba/")
    public String home(){
        return "Hola, estoy conectado";
    }
    @GetMapping(path = "/animal/{id}")
    public Animals read(@PathVariable String id) {


        return crudAnimalUseCase.read(id);
    }

    @PostMapping(path = "/animal")
    public void create(@RequestBody Animals animals) {
        crudAnimalUseCase.create(animals);

    }

    @PutMapping(path = "/animal/{id}")
    public void update(@PathVariable String id, @RequestBody Animals animals) {
        try {
            crudAnimalUseCase.update(id, animals);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(path = "/animal/{id}")
    public void delete(@PathVariable String id) {
        crudAnimalUseCase.delete(id);
    }

    @GetMapping(path = "/animal/ViewList")
    public List<Animals> getAll() {

        return crudAnimalUseCase.getAll();
    }
}
