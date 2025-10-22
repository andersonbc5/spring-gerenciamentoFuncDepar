package com.backdevanderson.funcdep.service;


import com.backdevanderson.funcdep.entities.Departamento;
import com.backdevanderson.funcdep.repository.DepartamentoRepository;
import com.backdevanderson.funcdep.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    public Departamento salvarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento departamentoPorId(Long id) {
        return departamentoRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("id não encontrado " + id));
    }

    public void deleteDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }

    public Departamento atualizarDepartamento(Long id, Departamento departamento) {
        Departamento dp = departamentoRepository.getReferenceById(id);

        dp.setNome(departamento.getNome());

        return departamentoRepository.save(dp);
    }
}
