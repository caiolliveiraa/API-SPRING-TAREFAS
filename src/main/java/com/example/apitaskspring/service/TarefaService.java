package com.example.apitaskspring.service;

import java.util.List;
import com.example.apitaskspring.entity.Tarefa;
public interface TarefaService {
    Tarefa getTarefa(int id);
    List<Tarefa> getTarefas();
    Tarefa criarTarefa(Tarefa tarefa);
    Tarefa atualizarTarefa(int id, Tarefa tarefa);
    void deletarTarefa(int id);

}
