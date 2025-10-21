package com.backdevanderson.funcdep.controller;


import com.backdevanderson.funcdep.entities.Departamento;
import com.backdevanderson.funcdep.service.DepartamentoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dp")

public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamento(){
        List<Departamento> dp = departamentoService.listarDepartamentos();
        return ResponseEntity.ok().body(dp);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Departamento> listarPorId(@PathVariable Long id){
        Departamento dp = departamentoService.departamentoPorId(id);
        return ResponseEntity.ok().body(dp);
    }

    @PostMapping
    public ResponseEntity<Departamento> inserirDepartamento(@RequestBody Departamento departamento){
        departamentoService.salvarDepartamento(departamento);
        return ResponseEntity.ok().body(departamento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id){
        departamentoService.deleteDepartamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Departamento> atualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
        departamento = departamentoService.atualizarDepartamento(id, departamento);
        return ResponseEntity.ok().body(departamento);
    }
}
