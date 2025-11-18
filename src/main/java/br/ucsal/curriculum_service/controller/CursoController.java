package br.ucsal.curriculum_service.controller;

import br.ucsal.curriculum_service.dto.CursoDTO;
import br.ucsal.curriculum_service.model.entity.Curso;
import br.ucsal.curriculum_service.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/cursos")
@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso create (@RequestBody CursoDTO dto) {
        return cursoService.create(dto);
    }

    @PutMapping
    public Curso update(@RequestBody CursoDTO dto) {
        return cursoService.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody CursoDTO dto) {
        cursoService.delete(dto);
    }

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }
}