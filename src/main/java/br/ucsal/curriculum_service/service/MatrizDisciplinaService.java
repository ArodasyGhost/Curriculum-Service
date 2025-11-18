package br.ucsal.curriculum_service.service;

import br.ucsal.curriculum_service.dto.MatrizDisciplinaDTO;
import br.ucsal.curriculum_service.model.entity.Matriz;
import br.ucsal.curriculum_service.model.entity.MatrizDisciplina;
import br.ucsal.curriculum_service.repository.MatrizDisciplinaRepository;
import br.ucsal.curriculum_service.repository.MatrizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatrizDisciplinaService {

    private final MatrizDisciplinaRepository matrizDisciplinaRepository;
    private final MatrizRepository matrizRepository;

    public MatrizDisciplinaService(MatrizDisciplinaRepository matrizDisciplinaRepository,
                                   MatrizRepository matrizRepository) {
        this.matrizDisciplinaRepository = matrizDisciplinaRepository;
        this.matrizRepository = matrizRepository;
    }

    public Optional<MatrizDisciplina> salvar(MatrizDisciplinaDTO dto) {
        // Valida Matriz (Interna)
        Optional<Matriz> matrizOpt = matrizRepository.findById(dto.matrizId());
        if (matrizOpt.isEmpty()) {
            return Optional.empty();
        }

        // Para disciplina, confiamos no ID passado (validado pelo Orquestrador)
        MatrizDisciplina md = new MatrizDisciplina();
        md.setSemestre(dto.semestre());
        md.setMatriz(matrizOpt.get());
        md.setDisciplinaId(dto.disciplinaId());
        md.setPreRequisitoId(dto.preRequisitoId());

        return Optional.of(matrizDisciplinaRepository.save(md));
    }

    public Optional<MatrizDisciplina> buscarPorId(Integer id) {
        return matrizDisciplinaRepository.findById(id);
    }

    public List<MatrizDisciplina> listarTodos() {
        return matrizDisciplinaRepository.findAll();
    }

    public Optional<MatrizDisciplina> atualizar(Integer id, MatrizDisciplinaDTO dto) {
        return matrizDisciplinaRepository.findById(id).flatMap(md -> {
            Optional<Matriz> matrizOpt = matrizRepository.findById(dto.matrizId());
            if (matrizOpt.isEmpty()) {
                return Optional.empty();
            }

            md.setSemestre(dto.semestre());
            md.setMatriz(matrizOpt.get());
            md.setDisciplinaId(dto.disciplinaId());
            md.setPreRequisitoId(dto.preRequisitoId());

            return Optional.of(matrizDisciplinaRepository.save(md));
        });
    }

    public boolean deletar(Integer id) {
        if (matrizDisciplinaRepository.existsById(id)) {
            matrizDisciplinaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}