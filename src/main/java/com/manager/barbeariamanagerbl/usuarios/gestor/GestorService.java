package com.manager.barbeariamanagerbl.usuarios.gestor;

import com.manager.barbeariamanagerbl.barbearia.Barbearia;
import com.manager.barbeariamanagerbl.barbearia.BarbeariaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class GestorService {

    private final GestorRepository gestorRepository;
    private final BarbeariaRepository barbeariaRepository;



    public void cadastrarBarbearia(Barbearia barbearia, Gestor gestor){

        Barbearia barbeariaDTO = new Barbearia();
        barbeariaDTO.setGestor(gestor);
        barbeariaDTO.setCep(barbearia.getCep());
        barbeariaDTO.setCnpj(barbearia.getCnpj());
        barbeariaDTO.setNumero(barbearia.getNumero());
        barbeariaDTO.setRua(barbearia.getRua());
        barbeariaDTO.setNome(barbearia.getNome());

        barbeariaRepository.save(barbeariaDTO);

    }
}
