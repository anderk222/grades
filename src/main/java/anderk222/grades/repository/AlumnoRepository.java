package anderk222.grades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.grades.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    int countByMaestroId(long maestroId);

    List<Alumno> findByMaestroId(long maestroId);

    List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre,String apellido);

}
