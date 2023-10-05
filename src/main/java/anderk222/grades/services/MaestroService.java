package anderk222.grades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.grades.entities.Maestro;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.MaestroRepository;

@Service
public class MaestroService {
    
    @Autowired
    private MaestroRepository repository;


    public List<Maestro> findAll(){

        return repository.findAll();

    }

    public Maestro find(long id){

        return repository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException(id, "id", "maestro"));

    }

    public Maestro save(Maestro maestro){


        return repository.save(maestro);

    }

    public Maestro update(Maestro maestro){

        this.find(maestro.getId());


        return repository.save(maestro);

    }

    public Maestro delete(long id){

        Maestro maestro = this.find(id);

        repository.deleteById(id);

        return maestro;

    }

}
