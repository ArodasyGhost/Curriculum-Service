package br.ucsal.curriculum_service.repository;

import br.ucsal.curriculum_service.model.entity.Matriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatrizRepository extends JpaRepository<Matriz, Integer> {
    List<Matriz> findByTurno(Matriz.Turno turno);
    List<Matriz> findByCampus(Matriz.Campus campus);
    List<Matriz> findByHabilitacao(Matriz.Habilitacao habilitacao);
    // Busca pelo ID do professor (agora um Integer simples)
    List<Matriz> findByProfessorCoordenadorId(Integer professorId);
}