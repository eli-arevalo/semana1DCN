package com.duoc.LearningPlatformValidation.controller;

import com.duoc.LearningPlatformValidation.model.Evaluacion;
import com.duoc.LearningPlatformValidation.service.EvaluacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;
    
    @GetMapping
    public ResponseEntity<List<Evaluacion>> obtenerEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.obtenerEvaluaciones());
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Evaluacion>> obtenerEvaluacionPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(evaluacionService.obtenerEvaluacionPorCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<Evaluacion> registrarEvaluacion(@RequestBody Evaluacion evaluacion) {
        Evaluacion nueva = evaluacionService.registrarEvaluacion(evaluacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> modificarEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacionNueva) {
        Optional<Evaluacion> evaluacionModificada = evaluacionService.modificarEvaluacion(id, evaluacionNueva);
        
        if (evaluacionModificada.isPresent()) {
            return ResponseEntity.ok(evaluacionModificada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
