// Pacote: com.Moustache.MrMoustache.repositorio
package com.moustache.mrmoustache.repositorio;

import com.moustache.mrmoustache.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoCliente extends JpaRepository<Cliente, Long> {

    // Métodos essenciais para as validações no Service
    boolean existsById(Long id);
    boolean existsByEmail(String email);
    Optional<Cliente> findByEmailAndSenha(String email, String senha);


    // Métodos para buscar um cliente (útil para o update e login futuro)
    Optional<Cliente> findById(Long id);
    Optional<Cliente> findByEmail(String email);

}
