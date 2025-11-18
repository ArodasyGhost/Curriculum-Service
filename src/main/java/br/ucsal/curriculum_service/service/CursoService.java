package br.ucsal.curriculum_service.service;

import br.ucsal.curriculum_service.dto.CursoDTO;
import br.ucsal.curriculum_service.model.entity.Curso;
import br.ucsal.curriculum_service.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso create(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setSigla(dto.sigla());
        curso.setDescricao(dto.descricao());
        curso.setModalidade(dto.modalidade());
        curso.setAtivo(dto.ativo());
        return cursoRepository.save(curso);
    }

    public Curso update(CursoDTO dto) {
        // Em um cenário real, buscaria pelo ID primeiro
        Curso curso = new Curso();
        curso.setId(dto.id());
        curso.setSigla(dto.sigla());
        curso.setDescricao(dto.descricao());
        curso.setModalidade(dto.modalidade());
        curso.setAtivo(dto.ativo());
        return cursoRepository.save(curso);
    }

    public void delete(CursoDTO dto) {
        // Deletar pelo ID é mais seguro
        cursoRepository.deleteById(dto.id());
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Integer id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
}