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

import anderk222.grades.entities.Materia;
import anderk222.grades.services.MateriaService;
import anderk222.grades.validation.JsonValid;

import static anderk222.grades.validation.SchemaLocations.MATERIA;

@RestController
@RequestMapping("/api/grades/materia")
@CrossOrigin("*")
public class MateriaController {
    
    @Autowired
    private MateriaService service;


    @GetMapping()
    public List<Materia> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Materia find(@PathVariable long id){

        return service.find(id);

    }

    @PostMapping()
    public ResponseEntity<Materia> save(@RequestBody @JsonValid(MATERIA) Materia materia){

        return ResponseEntity.status(201).body(service.save(materia));
    }

    @PutMapping("/{id}")
    public Materia update(@RequestBody @JsonValid(MATERIA) Materia materia, @PathVariable long id){

        return service.update(materia, id);
    }

    @DeleteMapping("/{id}")
    public Materia delete(@PathVariable long id){

        return service.delete(id);
    }

}