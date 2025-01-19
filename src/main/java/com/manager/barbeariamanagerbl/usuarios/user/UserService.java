package com.manager.barbeariamanagerbl.usuarios.user;

import com.manager.barbeariamanagerbl.usuarios.tipos.TipoUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> exibirBarbeiros() {
        return userRepository.findTipoUsuario(2);
    }

    public List<User> exibirClientes() {
        return userRepository.findTipoUsuario(3);
    }

    public List<User> exibirGestores() {
        return userRepository.findTipoUsuario(1);
    }


}
