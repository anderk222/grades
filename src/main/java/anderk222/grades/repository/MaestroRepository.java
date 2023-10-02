package anderk222.grades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.grades.entities.Maestro;

public interface MaestroRepository extends JpaRepository<Maestro, Long> {
    
}