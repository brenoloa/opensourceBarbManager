package com.manager.barbeariamanagerbl.usuarios.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/barbeiros")
    public List<User> findBarbeiros() {
        return userService.exibirBarbeiros();
    }

    @GetMapping("/gestores")
    public List<User> findGestores() {
        return userService.exibirGestores();
    }

    @GetMapping("/clientes")
    public List<User> findClientes() {
        return userService.exibirClientes();
    }

}
