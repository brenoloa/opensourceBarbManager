package com.manager.barbeariamanagerbl.autenticacao.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {

    private String name;

    private String token;

}
