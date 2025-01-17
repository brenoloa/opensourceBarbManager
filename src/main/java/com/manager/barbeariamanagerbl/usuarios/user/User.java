package com.manager.barbeariamanagerbl.usuarios.user;

import com.manager.barbeariamanagerbl.barbearia.Barbearia;
import com.manager.barbeariamanagerbl.usuarios.tipos.TipoUser;
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

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String telefone;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn (name = "tipo_usuario_id")
    private TipoUser tipo_usuario;

    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;


}
