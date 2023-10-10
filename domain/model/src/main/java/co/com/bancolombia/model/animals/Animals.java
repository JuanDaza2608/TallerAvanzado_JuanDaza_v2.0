package co.com.bancolombia.model.animals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

public class Animals {
    private String id;
    private long patas;
    private String Genero;
    private String Especie;
    private String Habitad;
    private Boolean Domestico;


}
