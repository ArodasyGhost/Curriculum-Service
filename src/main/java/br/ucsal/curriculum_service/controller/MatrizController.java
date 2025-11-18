package br.ucsal.curriculum_service.controller;

import br.ucsal.curriculum_service.dto.MatrizDTO;
import br.ucsal.curriculum_service.model.entity.Matriz;
import br.ucsal.curriculum_service.service.MatrizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/matrizes")
public class MatrizController {

    private final MatrizService matrizService;

    public MatrizController(MatrizService matrizService) {
        this.matrizService = matrizService;
    }

    @PostMapping
    public ResponseEntity<Matriz> criar(@RequestBody MatrizDTO dto) {
        return ResponseEntity.ok(matrizService.criarMatriz(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matriz> buscarPorId(@PathVariable Integer id) {
        return matrizService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Matriz>> listarTodas() {
        return ResponseEntity.ok(matrizService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matriz> atualizar(@PathVariable Integer id, @RequestBody MatrizDTO dto) {
        return matrizService.atualizarMatriz(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return matrizService.deletarMatriz(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/turno/{turno}")
    public ResponseEntity<List<Matriz>> listarPorTurno(@PathVariable Matriz.Turno turno) {
        return ResponseEntity.ok(matrizService.listarPorTurno(turno));
    }

    @GetMapping("/campus/{campus}")
    public ResponseEntity<List<Matriz>> listarPorCampus(@PathVariable Matriz.Campus campus) {
        return ResponseEntity.ok(matrizService.listarPorCampus(campus));
    }

    @GetMapping("/habilitacao/{habilitacao}")
    public ResponseEntity<List<Matriz>> listarPorHabilitacao(@PathVariable Matriz.Habilitacao habilitacao) {
        return ResponseEntity.ok(matrizService.listarPorHabilitacao(habilitacao));
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Matriz>> listarPorProfessor(@PathVariable Integer professorId) {
        return ResponseEntity.ok(matrizService.listarPorProfessor(professorId));
    }
}