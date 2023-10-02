package anderk222.grades.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.grades.entities.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
 
    List<Nota> findByMateriaId(long materiaId, Pageable pageable);

    List<Nota> findByAlumnoId(long alumnoId, Pageable pageable);
    
}