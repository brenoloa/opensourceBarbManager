package com.manager.barbeariamanagerbl.barbearia;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/barbearia")
public class BarbeariaController {

    private final BarbeariaService barbeariaService;

    @GetMapping()
    public List<Barbearia> exibirBarbearia(){
        return barbeariaService.exibirTodas();
    }

    @PostMapping()
    public void salvar(@RequestBody Barbearia barbearia){
        barbeariaService.salvar(barbearia);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        barbeariaService.excluir(id);
    }

    @GetMapping("/{id}")
    public Optional<Barbearia> exibirBarbeariaPorId(@PathVariable int id){
        return barbeariaService.exibirPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Barbearia barbearia){
        barbeariaService.atualizar(id, barbearia);
    }
    
}
