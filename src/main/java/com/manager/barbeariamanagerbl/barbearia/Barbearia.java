package com.manager.barbeariamanagerbl.barbearia;


import com.manager.barbeariamanagerbl.usuarios.gestor.Gestor;
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
@Table(name = "barbearia")
@Setter
@Getter
@RequiredArgsConstructor
public class Barbearia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cnpj;

    private int logo_id = 0;

    private String rua;
    private String cep;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "gestor_id")
    private Gestor gestor;


    public String getEndereçoFormatado(){
        return this.rua + " " + this.numero + " - " + this.cep;
    }

}
