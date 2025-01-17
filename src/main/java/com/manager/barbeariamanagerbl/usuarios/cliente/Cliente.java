package com.manager.barbeariamanagerbl.usuarios.cliente;

import com.manager.barbeariamanagerbl.barbearia.Barbearia;
import com.manager.barbeariamanagerbl.usuarios.user.User;
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
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "cliente")
public class Cliente extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String telefone;

    private String cargo = "CLIENTE";

    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;
}
