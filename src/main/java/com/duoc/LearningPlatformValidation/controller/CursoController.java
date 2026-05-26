package com.duoc.LearningPlatformValidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.service.CursoService;


@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso buscarCursoPorId(@PathVariable Long id){
        return cursoService.buscarCursoPorId(id).orElse(null);
    }

    @PostMapping
    public Curso guardarCurso(@RequestBody Curso curso){
        return cursoService.guardarCurso(curso);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
    }
    
}
