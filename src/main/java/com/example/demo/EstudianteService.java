package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Estudiante;
import java.util.List;
import java.util.Optional;

//Marca la clase con la anotación @Service. Esto le dice a Spring que esta clase es un componente de 
//servicio y debe ser administrada por el 
//contenedor de Spring.
@Service
public class EstudianteService {

	private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id);
    }
//
   public Estudiante guardarEstudiante(Estudiante estudiante) {
       return estudianteRepository.save(estudiante);
  }
//
//    public void eliminarEstudiante(Long id) {
//        estudianteRepository.deleteById(id);
//    }
}
