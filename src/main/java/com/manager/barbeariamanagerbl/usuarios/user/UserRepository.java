package com.manager.barbeariamanagerbl.usuarios.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.tipo_usuario.id = :tipoId")
    List<User> findTipoUsuario(@Param("tipoId") Integer tipoId);



}

