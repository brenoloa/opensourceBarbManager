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

    public void atualizar(int id, Barbearia barbearia){
        Barbearia barbeariaAtual = barbeariaRepository.findById(id).get();

        if (barbearia.getCep() != null){
            barbeariaAtual.setCep(barbearia.getCep());
        }
        if (barbearia.getNome() != null){
            barbeariaAtual.setNome(barbearia.getNome());
        }
        if (barbearia.getTelefone() != null){
            barbeariaAtual.setTelefone(barbearia.getTelefone());
        }
        if (barbearia.getCnpj() != null){
            barbeariaAtual.setCnpj(barbearia.getCnpj());
        }

        if (barbearia.getNumero() != null){
            barbeariaAtual.setNumero(barbearia.getNumero());
        }

        if (barbearia.getRua() != null){
            barbeariaAtual.setRua(barbearia.getRua());
        }
        barbeariaRepository.save(barbeariaAtual);

    }
}
