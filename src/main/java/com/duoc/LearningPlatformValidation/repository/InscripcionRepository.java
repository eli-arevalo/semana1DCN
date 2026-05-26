package com.duoc.LearningPlatformValidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duoc.LearningPlatformValidation.model.Inscripcion;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    //Método especial para buscar inscripciones x curso
    public List<Inscripcion> findByCursoId(Long cursoId);
    public List<Inscripcion> findByInscripcionId(Long inscripcionId);
}
