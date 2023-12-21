package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*@RestController es una anotación en Spring Framework, un marco de desarrollo de aplicaciones en 
Java, que se utiliza en una clase controladora (controller) parcom.example.demo.EstudianteControllera indicar que la clase es un 
controlador de tipo RESTful. Cuando se etiqueta una clase con @RestController, Spring la reconoce 
como una clase que manejará solicitudes HTTP y responderá a ellas mediante recursos RESTful.*/
@RestController
@RequestMapping("/api")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/listEstudiantes")
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }
//
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        return estudianteService.obtenerEstudiantePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
   }
//
    @PostMapping("/save")
    public Estudiante guardarEstudiante(@Validated @RequestBody Estudiante estudiante) {
        return estudianteService.guardarEstudiante(estudiante);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
//        estudianteService.eliminarEstudiante(id);
//        return ResponseEntity.noContent().build();
//    }
}
