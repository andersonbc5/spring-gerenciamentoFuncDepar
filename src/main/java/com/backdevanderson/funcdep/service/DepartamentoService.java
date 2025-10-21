package com.backdevanderson.funcdep.service;


import com.backdevanderson.funcdep.entities.Departamento;
import com.backdevanderson.funcdep.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    public Departamento salvarDepartamento(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listarDepartamentos(){
        return departamentoRepository.findAll();
    }

    public Departamento departamentoPorId(Long id){
        return departamentoRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Departamento não encontrado"));
    }

    public void deleteDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }

    public Departamento atualizarDepartamento(Long id, Departamento departamento){
        Departamento dp = departamentoRepository.getReferenceById(id);

        dp.setNome(departamento.getNome());

        return departamentoRepository.save(dp);
    }
}
