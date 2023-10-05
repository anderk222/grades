package anderk222.grades.controllers;


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
import anderk222.grades.dto.Response;
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
    public Response findAll() {

        return Response.body(service.findAll());
    }

    @GetMapping("/{id}")
    public Response find(@PathVariable long id) {

        return Response.body(service.find(id));

    }

    @PostMapping("/countByMaestro")
    public Response countByMaestro(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.countByMaestro(data.getId()));

    }

    @PostMapping("/findByMaestro")
    public Response findByMaestro(@RequestBody @JsonValid(ID) Identificator data ){

        return Response.body(service.findByMaestro(data.getId()));

    }

    @PostMapping()
    public Response save(@RequestBody @JsonValid(ALUMNO) Alumno alumno) {

        return Response.body(service.save(alumno));
    }

    @PutMapping("/update")
    public Response update(@RequestBody @JsonValid(ALUMNO) Alumno alumno) {

        return Response.body(service.update(alumno));
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.delete(data.getId()));
    }

    @GetMapping("/search")
    public Response findByFullName(

    @RequestParam(name = "nombre", defaultValue = "", required = false) String nombre,
    @RequestParam(name = "apellido", defaultValue = "", required = false) String apellido

    ){

        return Response.body(service.findByFullName(nombre, apellido));

    }

}