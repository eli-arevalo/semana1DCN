package com.duoc.LearningPlatformValidation.repository;
import com.duoc.LearningPlatformValidation.model.Evaluacion;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    //método para buscar evaluación x curso
    List<Evaluacion> findByCursoId(Long cursoId);
}
