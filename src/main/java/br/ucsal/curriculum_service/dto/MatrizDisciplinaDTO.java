package br.ucsal.curriculum_service.dto;

public record MatrizDisciplinaDTO(
        Integer id,
        Integer semestre,
        Integer matrizId,
        Integer disciplinaId,
        Integer preRequisitoId
) {}