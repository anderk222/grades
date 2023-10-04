package anderk222.grades.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.dto.Identificator;
import anderk222.grades.entities.Alumno;
import anderk222.grades.services.AlumnoService;
import anderk222.grades.validation.JsonValid;
import static anderk222.grades.validation.SchemaLocations.ALUMNO;
import static anderk222.grades.validation.SchemaLocations.ID;


@RestController
@RequestMapping("/api/grades/alumno")
@CrossOrigin("*")
public class AlumnoController {

    private AlumnoService service;

    public AlumnoController(AlumnoService service){

        this.service = service;

    }

    @GetMapping()
    public List<Alumno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Alumno find(@PathVariable long id) {

        return service.find(id);

    }

    @PostMapping("/countByMaestro")
    public int countByMaestro(@RequestBody @JsonValid(ID) Identificator data) {

        return service.countByMaestro(data.getId());

    }

    @PostMapping("/findByMaestro")
    public List<Alumno> findByMaestro(@RequestBody @JsonValid(ID) Identificator data ){

        return service.findByMaestro(data.getId());

    }

    @PostMapping()
    public ResponseEntity<Alumno> save(@RequestBody @JsonValid(ALUMNO) Alumno alumno) {

        return ResponseEntity.status(201).body(service.save(alumno));
    }

    @PutMapping("/update")
    public Alumno update(@RequestBody @JsonValid(ALUMNO) Alumno alumno) {

        return service.update(alumno);
    }

    @PostMapping("/delete")
    public Alumno delete(@RequestBody @JsonValid(ID) Identificator data) {

        return service.delete(data.getId());
    }

    @GetMapping("/search")
    public List<Alumno> findByFullName(

    @RequestParam(name = "nombre", defaultValue = "", required = false) String nombre,
    @RequestParam(name = "apellido", defaultValue = "", required = false) String apellido

    ){

        return service.findByFullName(nombre, apellido);

    }

}