package br.ucsal.curriculum_service.dto;

import br.ucsal.curriculum_service.model.entity.Curso.Modalidade;

public record CursoDTO(
        Integer id,
        String sigla,
        String descricao,
        Modalidade modalidade,
        boolean ativo
) {}