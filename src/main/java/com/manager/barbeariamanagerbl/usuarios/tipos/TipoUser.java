package com.manager.barbeariamanagerbl.usuarios.tipos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "situacao_usuario")
public class TipoUser{

    private static final int GESTOR = 1;

    private static final int BARBEIRO = 2;

    private static final int CLIENTE = 3;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String denominação;

    public TipoUser() {
        super();
    }

    public boolean isGestor(){
        return GESTOR == id;
    }

    public boolean isBarbeiro(){
        return BARBEIRO == id;
    }
    public boolean isCliente(){
        return CLIENTE == id;
    }

}
