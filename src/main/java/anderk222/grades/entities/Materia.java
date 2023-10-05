package anderk222.grades.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

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
    @Expose
    private Long id;

    @Column(length = 100)
    @Expose
    private String descripcion;

    @Expose(serialize = false, deserialize = false)
    private boolean deleted = false;

}