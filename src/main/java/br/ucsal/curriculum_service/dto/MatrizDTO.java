package br.ucsal.curriculum_service.dto;

import br.ucsal.curriculum_service.model.entity.Matriz.Campus;
import br.ucsal.curriculum_service.model.entity.Matriz.Habilitacao;
import br.ucsal.curriculum_service.model.entity.Matriz.Turno;

public record MatrizDTO(
        Integer id,
        String nome,
        String periodoIngresso,
        Turno turno,
        Campus campus,
        Habilitacao habilitacao,
        Integer horasAtividadesComp,
        Integer horasDisciplinasObrig,
        Integer horasDisciplinasExtras,
        Integer horasTCC,
        Integer idProfessorCoordenador,
        Integer cursoId // ID do curso para vincular
) {}