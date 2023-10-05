package anderk222.grades.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.dto.Identificator;
import anderk222.grades.dto.Response;
import anderk222.grades.entities.Nota;
import anderk222.grades.services.NotaService;
import anderk222.grades.validation.JsonValid;

import static anderk222.grades.validation.SchemaLocations.NOTA;
import static anderk222.grades.validation.SchemaLocations.ID;

@RestController
@RequestMapping("/api/grades/nota")
@CrossOrigin("*")
public class NotaController {

    // Usar enum para errores
    private NotaService service;

    public NotaController(NotaService service) {

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

    @PostMapping()
    public Response save(@RequestBody @JsonValid(NOTA) Nota nota) {

        return Response.body(service.save(nota));
    }

    @PostMapping("/update")
    public Response update(@RequestBody @JsonValid(NOTA) Nota nota) {

        return Response.body(service.update(nota));
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.delete(data.getId()));
    }

    @PostMapping("/bestPromedioByMateria")
    public Response bestPromedioByMateria(
            @RequestBody @JsonValid(ID) Identificator data,
            @RequestParam(name = "size", defaultValue = "2", required = false) int size) {

        return Response.body(service.bestPromedioByMateria(data.getId(), size));
    }

    @PostMapping("/bestPromedioByAlumno")
    public Response bestPromedioByAlumno(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.bestPromedioByAlumno(data.getId()));

    }
}