package com.manager.barbeariamanagerbl.barbearia;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class BarbeariaService {

    private final BarbeariaRepository barbeariaRepository;

    public List<Barbearia> exibirTodas(){
        return barbeariaRepository.findAll();
    }

    public void salvar(Barbearia barbearia){
        barbeariaRepository.save(barbearia);
    }

    public void excluir(int id){
        barbeariaRepository.deleteById(id);
    }

    public Optional<Barbearia> exibirPorId(int id){
        return barbeariaRepository.findById(id);
    }
}
