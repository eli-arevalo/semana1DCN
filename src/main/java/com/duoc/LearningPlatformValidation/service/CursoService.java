package com.duoc.LearningPlatformValidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.repository.CursoRepository;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    
}
