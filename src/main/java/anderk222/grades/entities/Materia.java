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
@SQLDelete(sql = "UPDATE materia SET deleted='true' WHERE id_materia=?")
@Where(clause = "deleted=false")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_materia")
    private Long id;

    @Column(length = 100)
    private String descripcion;

    @JsonIgnore
    private boolean deleted = false;

}