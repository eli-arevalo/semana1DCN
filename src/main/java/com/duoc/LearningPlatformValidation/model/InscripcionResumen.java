package com.duoc.LearningPlatformValidation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionResumen {
    private Long inscripcionId;
    private Long estudianteId;
    private List<Curso> cursos;
    private double total;
}
