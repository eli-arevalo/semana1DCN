package com.duoc.LearningPlatformValidation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.*;
import com.duoc.LearningPlatformValidation.repository.*;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public InscripcionResumen inscribir(Long estudianteId, List<Long> cursoIds){
        
        //generamos un id unico para cada inscripcion
        Long inscripcionId = System.currentTimeMillis();

        List<Curso> cursosInscritos = new ArrayList<>();
        double total = 0;

        for(Long cursoId : cursoIds){
            //buscamos el curso en la bd
            Curso curso = cursoRepository.findById(cursoId).orElse(null);
            if(curso != null){

                //guardamos un registro pr cada curso
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setInscripcionId(inscripcionId);
                inscripcion.setCursoId(cursoId);
                inscripcion.setEstudianteId(estudianteId);
                inscripcion.setFechaInscripcion(new Date());
                inscripcionRepository.save(inscripcion);

                cursosInscritos.add(curso);
                total += curso.getCosto();
            }
        }
        return new InscripcionResumen(inscripcionId, estudianteId, cursosInscritos, total);
    }
}
