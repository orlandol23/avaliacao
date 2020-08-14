package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class TurmaDTO {

    private CursoDTO curso;

    private String dtInicio;

    private String dtFim;

    private List<InstrutorDTO> instrutores;

    private List<AlunoDTO> alunos;


}
