package com.manager.barbeariamanagerbl.usuarios.gestor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "gestor")
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;

    private String senha;

    private String telefone;

    private String nome;

    private String cargo = "GESTOR";

}
