package anderk222.grades.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
@SQLDelete(sql = "UPDATE maestro SET deleted='true' WHERE id_maestro=?")
@Where(clause = "deleted=false")
public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_maestro")
    private Long id;

    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(length = 45, nullable = false)
    private String apellido;
    @Column(length = 100, nullable = false)
    private String titulo;

    @JsonIgnore
    private boolean deleted = false;

}
