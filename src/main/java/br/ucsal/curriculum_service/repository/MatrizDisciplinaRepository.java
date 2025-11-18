package br.ucsal.curriculum_service.repository;

import br.ucsal.curriculum_service.model.entity.MatrizDisciplina;
import br.ucsal.curriculum_service.model.entity.Matriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatrizDisciplinaRepository extends JpaRepository<MatrizDisciplina, Integer> {
    List<MatrizDisciplina> findByMatriz(Matriz matriz);
    List<MatrizDisciplina> findByDisciplinaId(Integer disciplinaId);
}