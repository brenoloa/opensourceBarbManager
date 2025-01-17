package com.manager.barbeariamanagerbl.usuarios.barbeiro;

import com.manager.barbeariamanagerbl.barbearia.Barbearia;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "barbeiro")
@Setter
@Getter
@RequiredArgsConstructor
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String telefone;

    private String email;

    private String senha;

    private String cargo = "BARBEIRO";


    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;


}
