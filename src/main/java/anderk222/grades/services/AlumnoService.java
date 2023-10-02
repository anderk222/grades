package anderk222.grades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.grades.entities.Alumno;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    public List<Alumno> findAll() {

        return repository.findAll();

    }

    public Alumno find(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "alumno"));

    }

    public Alumno save(Alumno alumno) {

        alumno.setId(0l);

        return repository.save(alumno);

    }

    public Alumno update(Alumno alumno, long id) {

        this.find(id);

        alumno.setId(id);

        return repository.save(alumno);

    }

    public Alumno delete(long id) {

        Alumno alumno = this.find(id);

        repository.deleteById(id);

        return alumno;
    }

    public List<Alumno> findByFullName(String nombre, String apellido) {

        return repository
                .findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(nombre, apellido);

    }

    public int countByMaestro(long maestroId) {
        return repository.countByMaestroId(maestroId);

    }

}
