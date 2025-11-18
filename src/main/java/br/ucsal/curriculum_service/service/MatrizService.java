package br.ucsal.curriculum_service.service;

import br.ucsal.curriculum_service.dto.MatrizDTO;
import br.ucsal.curriculum_service.model.entity.Curso;
import br.ucsal.curriculum_service.model.entity.Matriz;
import br.ucsal.curriculum_service.repository.MatrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatrizService {

    @Autowired
    private MatrizRepository matrizRepository;

    @Autowired
    private CursoService cursoService; // OK, está no mesmo serviço

    public Matriz criarMatriz(MatrizDTO dto) {
        Matriz matriz = new Matriz();
        matriz.setNome(dto.nome());
        matriz.setPeriodoIngresso(dto.periodoIngresso());
        matriz.setTurno(dto.turno());
        matriz.setCampus(dto.campus());
        matriz.setHabilitacao(dto.habilitacao());
        matriz.setHorasAtividadesComp(dto.horasAtividadesComp());
        matriz.setHorasDisciplinasObrig(dto.horasDisciplinasObrig());
        matriz.setHorasDisciplinasExtras(dto.horasDisciplinasExtras());
        matriz.setHorasTCC(dto.horasTCC());

        // Apenas salva o ID. O Orquestrador validou se o professor existe.
        matriz.setProfessorCoordenadorId(dto.idProfessorCoordenador());

        // Busca o curso interno e associa
        if(dto.cursoId() != null) {
            Curso curso = cursoService.findById(dto.cursoId());
            matriz.setCurso(curso);
        }

        return matrizRepository.save(matriz);
    }

    public Optional<Matriz> buscarPorId(Integer id) {
        return matrizRepository.findById(id);
    }

    public List<Matriz> listarTodas() {
        return matrizRepository.findAll();
    }

    public Optional<Matriz> atualizarMatriz(Integer id, MatrizDTO dto) {
        return matrizRepository.findById(id).map(matrizExistente -> {
            matrizExistente.setNome(dto.nome());
            matrizExistente.setPeriodoIngresso(dto.periodoIngresso());
            matrizExistente.setTurno(dto.turno());
            matrizExistente.setCampus(dto.campus());
            matrizExistente.setHabilitacao(dto.habilitacao());
            matrizExistente.setHorasAtividadesComp(dto.horasAtividadesComp());
            matrizExistente.setHorasDisciplinasObrig(dto.horasDisciplinasObrig());
            matrizExistente.setHorasDisciplinasExtras(dto.horasDisciplinasExtras());
            matrizExistente.setHorasTCC(dto.horasTCC());
            matrizExistente.setProfessorCoordenadorId(dto.idProfessorCoordenador());

            if(dto.cursoId() != null) {
                Curso curso = cursoService.findById(dto.cursoId());
                matrizExistente.setCurso(curso);
            }

            return matrizRepository.save(matrizExistente);
        });
    }

    public boolean deletarMatriz(Integer id) {
        if (matrizRepository.existsById(id)) {
            matrizRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Matriz> listarPorTurno(Matriz.Turno turno) {
        return matrizRepository.findByTurno(turno);
    }

    public List<Matriz> listarPorCampus(Matriz.Campus campus) {
        return matrizRepository.findByCampus(campus);
    }

    public List<Matriz> listarPorHabilitacao(Matriz.Habilitacao habilitacao) {
        return matrizRepository.findByHabilitacao(habilitacao);
    }

    public List<Matriz> listarPorProfessor(Integer professorId) {
        return matrizRepository.findByProfessorCoordenadorId(professorId);
    }
}