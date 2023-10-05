package anderk222.grades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.grades.entities.Materia;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.MateriaRepository;

@Service
public class MateriaService {
    
    @Autowired
    private MateriaRepository repository;

    public List<anderk222.grades.entities.Materia> findAll() {

        return repository.findAll();

    }

    public Materia find(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "materia"));

    }

    public Materia save(Materia materia) {

        materia.setId(0l);

        return repository.save(materia);

    }

    public Materia update(Materia materia) {

        this.find(materia.getId());

        return repository.save(materia);

    }

    public Materia delete(long id) {

        Materia materia = this.find(id);

        repository.deleteById(id);

        return materia;

    }


}
