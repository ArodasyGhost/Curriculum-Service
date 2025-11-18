package br.ucsal.curriculum_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MatrizDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer semestre;

    // Relacionamento INTERNO (OK)
    @ManyToOne
    @JoinColumn(name = "matriz_id", nullable = false)
    private Matriz matriz;

    // MUDANÇA: Apenas ID da disciplina (externa)
    @Column(nullable = false)
    private Integer disciplinaId;

    // MUDANÇA: Apenas ID do pré-requisito (externa)
    @Column(nullable = true)
    private Integer preRequisitoId;

    public MatrizDisciplina() {}
}