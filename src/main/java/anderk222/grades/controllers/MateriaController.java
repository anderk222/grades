package anderk222.grades.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.dto.Identificator;
import anderk222.grades.entities.Materia;
import anderk222.grades.services.MateriaService;
import anderk222.grades.validation.JsonValid;
import static anderk222.grades.validation.SchemaLocations.MATERIA;
import static anderk222.grades.validation.SchemaLocations.ID;
import anderk222.grades.dto.Response;


@RestController
@RequestMapping("/api/grades/materia")
@CrossOrigin("*")
public class MateriaController {
    
    @Autowired
    private MateriaService service;


    @GetMapping()
    public Response findAll(){

        return Response.body(service.findAll());
    }

    @GetMapping("/{id}")
    public Response find(@PathVariable long id){

        return Response.body(service.find(id));

    }

    @PostMapping()
    public Response save(@RequestBody @JsonValid(MATERIA) Materia materia){

        return Response.body(service.save(materia));
    }

    @PostMapping("/update")
    public Response update(@RequestBody @JsonValid(MATERIA) Materia materia){

        return Response.body(service.update(materia));
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @JsonValid(ID) Identificator data){

        return Response.body(service.delete(data.getId()));
    }

}