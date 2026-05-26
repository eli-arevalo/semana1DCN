package com.duoc.LearningPlatformValidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.LearningPlatformValidation.model.InscripcionResumen;
import com.duoc.LearningPlatformValidation.service.InscripcionService;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<InscripcionResumen> inscribir(
        @RequestParam Long estudianteId,//aca el requestParam lee el estudianteId desde la url
        @RequestBody List<Long> cursoIds//el requestBody lee la lista de id's de cursos desde el json de la petición
    ){
        InscripcionResumen resumen = inscripcionService.inscribir(estudianteId, cursoIds);// llamamos al service que tiene la logica de inscripcion
        return ResponseEntity.status(HttpStatus.CREATED).body(resumen);//devolvemos el resumen con codigo http 201 indicando que se creó algo
    }
}
