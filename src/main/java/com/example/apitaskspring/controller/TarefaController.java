package com.example.apitaskspring.controller;

import com.example.apitaskspring.entity.Tarefa;
import com.example.apitaskspring.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefa(@PathVariable int id) {
        Tarefa tarefa = tarefaService.getTarefa(id);
        if (tarefa != null) {
            return ResponseEntity.ok().body(tarefa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> getTarefas() {
        List<Tarefa> tarefas = tarefaService.getTarefas();
        return ResponseEntity.ok().body(tarefas);
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        URI location = URI.create("/api/tarefas/" + novaTarefa.getId());
        return ResponseEntity.created(location).body(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);
        if (tarefaAtualizada != null) {
            return ResponseEntity.ok().body(tarefaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable int id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.ok().build();
    }
}

