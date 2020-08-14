package com.rd.treinamentodev.AvaliacaoSpringBoot.repository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    List<CursoEntity> findByName(String name);


}
