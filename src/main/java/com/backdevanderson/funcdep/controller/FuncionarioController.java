package com.backdevanderson.funcdep.controller;



import com.backdevanderson.funcdep.entities.Funcionario;
import com.backdevanderson.funcdep.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/func")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios(){
        List<Funcionario> func = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok().body(func);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> listarFuncionarioPorId(@PathVariable long id){
        Funcionario func = funcionarioService.funcionarioPorId(id);
        return ResponseEntity.ok().body(func);
    }

    @PostMapping
    public ResponseEntity<Funcionario> inserirFuncionario(@RequestBody Funcionario funcionario){
        funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable long id){
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> atualizarDepartamento(@PathVariable Long id, @RequestBody Funcionario funcionario){
        funcionario = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok().body(funcionario);
    }
}
