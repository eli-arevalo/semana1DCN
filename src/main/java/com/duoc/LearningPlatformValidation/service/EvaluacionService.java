package com.duoc.LearningPlatformValidation.service;

import com.duoc.LearningPlatformValidation.model.Evaluacion;
import com.duoc.LearningPlatformValidation.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> obtenerEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    public List<Evaluacion> obtenerEvaluacionPorCurso(Long cursoId) {
        return evaluacionRepository.findByCursoId(cursoId);
    }

    public Evaluacion registrarEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public Optional<Evaluacion> modificarEvaluacion(Long id, Evaluacion evaluacionNueva) {
        Optional<Evaluacion> evaluacionExistente = evaluacionRepository.findById(id);
        if (evaluacionExistente.isPresent()) {
            Evaluacion eval = evaluacionExistente.get();
            eval.setNombre(evaluacionNueva.getNombre());
            eval.setPuntajeMaximo(evaluacionNueva.getPuntajeMaximo());
            eval.setFechaAplicacion(evaluacionNueva.getFechaAplicacion());
            return Optional.of(evaluacionRepository.save(eval));
        } else {
            return Optional.empty();
        }
    }
}
