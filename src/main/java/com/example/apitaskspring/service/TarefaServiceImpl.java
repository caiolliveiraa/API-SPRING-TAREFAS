package com.example.apitaskspring.service;

import com.example.apitaskspring.entity.Tarefa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefaServiceImpl implements TarefaService {
    private Map<Integer, Tarefa> tarefas = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Tarefa getTarefa(int id) {
        return tarefas.get(id);
    }

    @Override
    public List<Tarefa> getTarefas() {
        return new ArrayList<>(tarefas.values());
    }

    @Override
    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setId(proximoId++);
        tarefas.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    @Override
    public Tarefa atualizarTarefa(int id, Tarefa tarefa) {
        if (tarefas.containsKey(id)) {
            tarefa.setId(id);
            tarefas.put(id, tarefa);
            return tarefa;
        }
        return null;
    }

    @Override
    public void deletarTarefa(int id) {
        tarefas.remove(id);
    }
}