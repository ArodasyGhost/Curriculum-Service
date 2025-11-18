package br.ucsal.curriculum_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 10)
    private String sigla;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;

    private boolean ativo = true;

    public enum Modalidade {
        PRESENCIAL, EAD, HIBRIDO
    }

    // Construtor vazio para JPA
    public Curso() {}
}