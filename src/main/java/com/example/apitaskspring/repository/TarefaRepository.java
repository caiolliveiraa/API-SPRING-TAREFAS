package com.example.apitaskspring.repository;

import com.example.apitaskspring.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findByFeitaTrue();
    List<Tarefa> findByDescricao(String descricao);

}

