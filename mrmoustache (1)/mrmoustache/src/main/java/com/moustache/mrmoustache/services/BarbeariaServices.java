package com.moustache.mrmoustache.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moustache.mrmoustache.model.Barbearia;
import com.moustache.mrmoustache.repositorio.RepoBarbearia;

@Service
public class BarbeariaServices {
    
    private final RepoBarbearia repoBarb;

    public BarbeariaServices(RepoBarbearia repoBarb) {
        this.repoBarb = repoBarb;
    }

    // Retorna os primeiros N barbearias ordenados pelo ID (padrão do banco)
    public List<Barbearia> listarPrimeiros(int n) {
        return repoBarb.findAll(PageRequest.of(0, n)).getContent();
    }

    // Busca uma barbearia pelo ID
    public Optional<Barbearia> findById(Long id) {
        return repoBarb.findById(id);
    }

    // Busca uma barbearia pelo email
    public Optional<Barbearia> findByEmail(String email) {
        return repoBarb.findByEmail(email);
    }

    // Busca uma barbearia por nome
    public Optional<Barbearia> findByNome(String nome) {
        return repoBarb.findByNome(nome);
    }

    public boolean verificarLogin(String email, String senha) {
    Optional<Barbearia> opt = repoBarb.findByEmailAndSenha(email, senha);
    return opt.isPresent();
}

 public Barbearia findByEmailAndSenha(String email, String senha) {
        return repoBarb.findByEmailAndSenha(email, senha).orElse(null);
    }

    // Salva/cadastra uma nova barbearia
    public Barbearia save(Barbearia barbearia) {
        return repoBarb.save(barbearia);
    }

}
