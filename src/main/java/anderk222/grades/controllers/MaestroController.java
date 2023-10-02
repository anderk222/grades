package anderk222.grades.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.entities.Maestro;
import anderk222.grades.services.MaestroService;
import anderk222.grades.validation.JsonValid;
import static anderk222.grades.validation.SchemaLocations.MAESTRO;

@RestController
@RequestMapping("/api/grades/maestro")
@CrossOrigin("*")
public class MaestroController {
    
    @Autowired
    private MaestroService service;


    @GetMapping()
    public List<Maestro> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Maestro find(@PathVariable long id){

        return service.find(id);

    }

    @PostMapping()
    public ResponseEntity<Maestro> save(@RequestBody @JsonValid(MAESTRO) Maestro maestro){

        return ResponseEntity.status(201).body(service.save(maestro));
    }

    @PutMapping("/{id}")
    public Maestro update(@RequestBody @JsonValid(MAESTRO) Maestro maestro, @PathVariable long id){

        return service.update(maestro, id);
    }

    @DeleteMapping("/{id}")
    public Maestro delete(@PathVariable long id){

        return service.delete(id);
    }

}