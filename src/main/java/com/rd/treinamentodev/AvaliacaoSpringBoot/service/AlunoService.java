package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity gravar(AlunoDTO alunoDTO){
        AlunoEntity entity = new AlunoEntity();
        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(alunoDTO.getCpf());

        //TODO validar se o CPF existe no banco antes de existir, caso exista retornar mensagem de erro

        ResultData Result = null;
        if(alunoRepository.findByCpf(alunoDTO.getCpf()).size() > 0){
            Result = new ResultData(HttpStatus.BAD_REQUEST.value(),"CPF Inválido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result);
        }else{
            Result = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity.getIdAluno());
            entity = alunoRepository.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(Result);
        }



    }
}
