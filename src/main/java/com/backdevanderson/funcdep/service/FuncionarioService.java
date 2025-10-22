package com.backdevanderson.funcdep.service;


import com.backdevanderson.funcdep.entities.Funcionario;
import com.backdevanderson.funcdep.repository.FuncionarioRepository;
import com.backdevanderson.funcdep.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario funcionarioPorId(Long id) {
        return funcionarioRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("id não encontrado " + id ));

    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario fun = funcionarioRepository.getReferenceById(id);

        fun.setNome(funcionario.getNome());
        fun.setEmail(funcionario.getEmail());
        fun.setCpf(funcionario.getCpf());
        fun.setSalario(fun.getSalario());


        return funcionarioRepository.save(fun);
    }
}
