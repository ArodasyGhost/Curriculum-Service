package br.ucsal.curriculum_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Matriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String periodoIngresso;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Enumerated(EnumType.STRING)
    private Campus campus;

    @Enumerated(EnumType.STRING)
    private Habilitacao habilitacao;

    private Integer horasAtividadesComp;
    private Integer horasDisciplinasObrig;
    private Integer horasDisciplinasExtras;
    private Integer horasTCC;

    // MUDANÇA: Apenas o ID do Professor (que vive em outro serviço)
    @Column(name = "professor_coordenador_id")
    private Integer professorCoordenadorId;

    // Relacionamento com o Curso (que vive NESTE serviço)
    // Adicionei isso pois geralmente uma Matriz pertence a um Curso
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Matriz() {}

    public enum Turno { MATUTINO, VESPERTINO, NOTURNO }
    public enum Campus { PITUAÇU, CAMAÇARI }
    public enum Habilitacao { LICENCIATURA, BACHARELADO, TECNOLOGO }
}