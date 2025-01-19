package com.manager.barbeariamanagerbl.autenticacao.login;

import com.manager.barbeariamanagerbl.autenticacao.token.TokenService;
import com.manager.barbeariamanagerbl.usuarios.user.User;
import com.manager.barbeariamanagerbl.usuarios.user.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
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
    public ResponseEntity<?> login(@RequestBody User userDTO) {
        try {

            User user = userRepository.findByEmail(userDTO.getEmail())
                    .orElseThrow(() -> new UserPrincipalNotFoundException("Usuário não encontrado"));


            if (userDTO.getPassword().equals(user.getPassword())) {
                String token = tokenService.gerarToken(user);

                return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
            }
        } catch (UserPrincipalNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Email ja existe");
        }

        userRepository.save(user);
        String token = tokenService.gerarToken(user);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/getuser")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    /*@PostMapping("/register")
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
    }*/

}
