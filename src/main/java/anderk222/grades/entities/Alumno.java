package anderk222.grades.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE alumno SET deleted='true' WHERE id_alumno=?")
@Where(clause = "deleted=false")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_alumno")
    @Expose
    private Long id;

    @Column(length = 45, nullable = false)
    @Expose
    private String nombre;
    
    @Column(length = 45, nullable = false)
    @Expose
    private String apellido;

    @ManyToOne()
    @JoinColumn(name = "maestro_idMaestro", referencedColumnName = "id_maestro")
    @Expose
    private Maestro maestro;

    @Expose(serialize = false, deserialize = false)
    private boolean deleted = false;
}