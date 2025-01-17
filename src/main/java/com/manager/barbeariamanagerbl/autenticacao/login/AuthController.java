package com.manager.barbeariamanagerbl.autenticacao.login;

import com.manager.barbeariamanagerbl.autenticacao.token.TokenService;
import com.manager.barbeariamanagerbl.usuarios.user.User;
import com.manager.barbeariamanagerbl.usuarios.user.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenService tokenService;

    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String senha) {
        try {
            User user = userRepository.findByEmail(email).orElseThrow(() -> new UserPrincipalNotFoundException("User nao encontrado"));

            if (!user.getPassword().equals(senha)) {
                String token = tokenService.gerarToken(user);
                return ResponseEntity.ok(token);
            }
            else  {
                return ResponseEntity.badRequest().body("Senha invalida");
            }

        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException("Usuário não encontrado");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return ResponseEntity.badRequest().body("Email ja registrado.");

        }

        User novoUsuario = new User() {
            @Override
            public String getEmail() {
                return super.getEmail();
            }

            @Override
            public String getPassword() {
                return super.getPassword();
            }
        };
        userRepository.save(novoUsuario);
        String token = tokenService.gerarToken(novoUsuario);
        return ResponseEntity.ok(token);
    }

}
