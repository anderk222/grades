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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.entities.Nota;
import anderk222.grades.services.NotaService;
import anderk222.grades.validation.JsonValid;

import static anderk222.grades.validation.SchemaLocations.NOTA;;

@RestController
@RequestMapping("/api/grades/nota")
@CrossOrigin("*")
public class NotaController {

    @Autowired
    private NotaService service;

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

    @PutMapping("/{id}")
    public Nota update(@RequestBody @JsonValid(NOTA) Nota nota, @PathVariable long id) {

        return service.update(nota, id);
    }

    @DeleteMapping("/{id}")
    public Nota delete(@PathVariable long id) {

        return service.delete(id);
    }

    @GetMapping("/bestPromedio/{materiaId}/materia")
    public List<Nota> bestPromedioByMateria(@PathVariable long materiaId,
            @RequestParam(name = "size", defaultValue = "2", required = false) int size) {

        return service.bestPromedioByMateria(materiaId, size);
    }

    @GetMapping("/bestPromedio/{alumnoId}/alumno")
    public List<Nota> bestPromedioByAlumno(@PathVariable long alumnoId) {

        return service.bestPromedioByAlumno(alumnoId);
    }
}