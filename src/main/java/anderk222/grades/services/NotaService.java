package anderk222.grades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import anderk222.grades.entities.Nota;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.NotaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    public List<anderk222.grades.entities.Nota> findAll() {

        return repository.findAll();

    }

    public Nota find(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "nota"));

    }

    public Nota save(Nota nota) {

        return repository.save(nota);

    }

    public Nota update(Nota nota) {

        this.find(nota.getId());

        return repository.save(nota);

    }

    public Nota delete(long id) {

        Nota nota = this.find(id);

        repository.deleteById(id);

        return nota;
    }

    public List<Nota> bestPromedioByMateria(long materiaId, int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "puntos");

        Pageable pageable = PageRequest.of(0, size, sort);

        return repository.findByMateriaId(materiaId, pageable);

    }

    public List<Nota> bestPromedioByAlumno(long alumnoId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "puntos");

        Pageable pageable = PageRequest.of(0, 1, sort);

        return repository.findByAlumnoId(alumnoId, pageable);

    }

}