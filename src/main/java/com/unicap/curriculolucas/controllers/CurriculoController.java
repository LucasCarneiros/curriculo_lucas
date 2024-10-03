package com.unicap.curriculolucas.controllers;

import com.unicap.curriculolucas.models.Curriculo;
import com.unicap.curriculolucas.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unicap.curriculolucas.services.CurriculoService;
import java.util.List;


@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @PostMapping
    public ResponseEntity<Curriculo> adicionarCurriculo(@RequestBody Curriculo curriculo){
        Curriculo novoCurriculo = curriculoService.criarCurriculo(curriculo);
        return new ResponseEntity<>(novoCurriculo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Curriculo>> obterTodosCurriculos() {
        List<Curriculo> curriculos = curriculoService.obterTodosCurriculos();
        return ResponseEntity.ok(curriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> obterCurriculo(@PathVariable Long id){
        Curriculo curriculo = curriculoService.obterCurriculo(id);
        return curriculo != null ? ResponseEntity.ok(curriculo) : ResponseEntity.notFound().build();
    }
}
