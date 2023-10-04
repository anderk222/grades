package anderk222.grades.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.dto.Identificator;
import anderk222.grades.entities.Nota;
import anderk222.grades.services.NotaService;
import anderk222.grades.validation.JsonValid;

import static anderk222.grades.validation.SchemaLocations.NOTA;
import static anderk222.grades.validation.SchemaLocations.ID;;

@RestController
@RequestMapping("/api/grades/nota")
@CrossOrigin("*")
public class NotaController {

    // Usar enum para errores
    private NotaService service;

    public NotaController(NotaService service){

        this.service = service;
    }


    @GetMapping()
    public List<Nota> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Nota find(@PathVariable long id) {

        return service.find(id);

    }

    @PostMapping()
    public ResponseEntity<Nota> save(@RequestBody @JsonValid(NOTA) Nota nota) {

        return ResponseEntity.status(201).body(service.save(nota));
    }

    @PostMapping("/update")
    public Nota update(@RequestBody @JsonValid(NOTA) Nota nota) {

        return service.update(nota);
    }

    @PostMapping("/delete")
    public Nota delete(@RequestBody @JsonValid(ID) Identificator data) {

        return service.delete(data.getId());
    }

    @PostMapping("/bestPromedioByMateria")
    public List<Nota> bestPromedioByMateria(
            @RequestBody @JsonValid(ID) Identificator data,
            @RequestParam(name = "size", defaultValue = "2", required = false) int size) {

        return service.bestPromedioByMateria(data.getId(), size);
    }

    @PostMapping("/bestPromedioByAlumno")
    public List<Nota> bestPromedioByAlumno(@RequestBody @JsonValid(ID) Identificator data) {

        return service.bestPromedioByAlumno(data.getId());

    }
}