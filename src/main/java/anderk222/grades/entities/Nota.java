package anderk222.grades.entities;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Alumno_has_Materias")
@SQLDelete(sql = "UPDATE Alumno_has_Materias SET deleted='true' WHERE id=?")
@Where(clause = "deleted=false")
public class Nota {

    @Id()
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "Materia_idMateria", referencedColumnName = "id_materia")
    private Materia materia;

    @ManyToOne()
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "id_alumno")
    private Alumno alumno;

    @Column(precision = 10, scale = 2)
    private BigDecimal puntos = BigDecimal.ZERO;


    @JsonIgnore
    private boolean deleted = false;

}