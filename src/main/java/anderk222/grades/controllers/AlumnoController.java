package anderk222.grades.controllers;

import java.util.List;
// import static anderk222.grades.validation.SchemaLocations.MATERIA;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import anderk222.grades.entities.Alumno;
import anderk222.grades.services.AlumnoService;
import anderk222.grades.validation.JsonValid;
import static anderk222.grades.validation.SchemaLocations.ALUMNO;;

@RestController
@RequestMapping("/api/grades/alumno")
@CrossOrigin("*")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping()
    public List<Alumno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Alumno find(@PathVariable long id) {

        return service.find(id);

    }

    @GetMapping("/count/{maestroId}/maestro")
    public int countByMaestro(@PathVariable long maestroId) {

        return service.countByMaestro(maestroId);

    }

    @PostMapping()
    public ResponseEntity<Alumno> save(@RequestBody @JsonValid(ALUMNO) Alumno alumno) {

        return ResponseEntity.status(201).body(service.save(alumno));
    }

    @PutMapping("/{id}")
    public Alumno update(@RequestBody @JsonValid(ALUMNO) Alumno alumno, @PathVariable long id) {

        return service.update(alumno, id);
    }

    @DeleteMapping("/{id}")
    public Alumno delete(@PathVariable long id) {

        return service.delete(id);
    }

    @GetMapping("/search")
    public List<Alumno> findByFullName(

    @RequestParam(name = "nombre", defaultValue = "", required = false) String nombre,
    @RequestParam(name = "apellido", defaultValue = "", required = false) String apellido

    ){

        return service.findByFullName(nombre, apellido);

    }

}