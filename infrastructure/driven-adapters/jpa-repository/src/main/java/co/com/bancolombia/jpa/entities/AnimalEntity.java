package co.com.bancolombia.jpa.entities;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animal")
public class AnimalEntity {

    @Id
    private String id;
    @Column
    private long patas;
    @Column private String Genero;
    @Column private String Especie;
    @Column private String Habitad;
    @Column private Boolean Domestico;
}
