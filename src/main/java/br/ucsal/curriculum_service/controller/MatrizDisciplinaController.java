package br.ucsal.curriculum_service.controller;

import br.ucsal.curriculum_service.dto.MatrizDisciplinaDTO;
import br.ucsal.curriculum_service.model.entity.MatrizDisciplina;
import br.ucsal.curriculum_service.service.MatrizDisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/matriz-disciplina")
public class MatrizDisciplinaController {

    private final MatrizDisciplinaService matrizDisciplinaService;

    public MatrizDisciplinaController(MatrizDisciplinaService matrizDisciplinaService) {
        this.matrizDisciplinaService = matrizDisciplinaService;
    }

    @PostMapping
    public ResponseEntity<MatrizDisciplina> criar(@RequestBody MatrizDisciplinaDTO dto) {
        return matrizDisciplinaService.salvar(dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatrizDisciplina> buscarPorId(@PathVariable Integer id) {
        return matrizDisciplinaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MatrizDisciplina>> listarTodos() {
        return ResponseEntity.ok(matrizDisciplinaService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatrizDisciplina> atualizar(@PathVariable Integer id, @RequestBody MatrizDisciplinaDTO dto) {
        return matrizDisciplinaService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return matrizDisciplinaService.deletar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}