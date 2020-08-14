package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_MODULO")
@Data
public class ModuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODULO")
    private BigInteger idModulo;

    @JoinColumn(name = "ID_CURSO")
    private CursoEntity curso;

    @OneToOne
    @JoinColumn(name = "ID_INSTRUTOR")
    private InstrutorEntity instrutor;

}
