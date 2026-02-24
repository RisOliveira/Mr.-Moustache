// Pacote: com.Moustache.MrMoustache.services
package com.moustache.mrmoustache.services;

import com.moustache.mrmoustache.model.Cliente;
import com.moustache.mrmoustache.repositorio.RepoCliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.PageRequest;

@Service
public class ClienteServices {

    private final RepoCliente repoCli;
    
    public ClienteServices(RepoCliente repoCli) {
        this.repoCli = repoCli;
    }

    // Retorna os primeiros N clientes ordenados pelo ID (padrão do banco)
    public List<Cliente> listarPrimeiros(int n) {
        return repoCli.findAll(PageRequest.of(0, n)).getContent();
    }
    
    public Optional<Cliente> findById(Long id) {
        return repoCli.findById(id);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        // agora o email é o identificador visual/único
        if (repoCli.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Erro: E-mail já está em uso!");
        }
        // Salva a senha conforme recebida (sem PasswordEncoder)
        // Se desejar criptografar, providencie a lógica/serviço apropriado
        return repoCli.save(cliente);
    }

    @Transactional
    public Cliente update(Long id, Cliente dadosAtualizados) {
        Cliente clienteExistente = repoCli.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " não encontrado."));

        // Valida se o novo 'email' já não pertence a outro cliente
        repoCli.findByEmail(dadosAtualizados.getEmail()).ifPresent(cli -> {
            if (!cli.getId().equals(id)) throw new RuntimeException("E-mail já pertence a outro cliente.");
        });

        // Atualiza os dados
        clienteExistente.setNome(dadosAtualizados.getNome());
        clienteExistente.setEmail(dadosAtualizados.getEmail());
        clienteExistente.setTipoCabelo(dadosAtualizados.getTipoCabelo());
        clienteExistente.setTipoRosto(dadosAtualizados.getTipoRosto());
        clienteExistente.setCep(dadosAtualizados.getCep());

        // Atualiza a senha diretamente se uma nova for fornecida
        if (dadosAtualizados.getSenha() != null && !dadosAtualizados.getSenha().isBlank()) {
            clienteExistente.setSenha(dadosAtualizados.getSenha());
        }

        return repoCli.save(clienteExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!repoCli.existsById(id)) {
            throw new RuntimeException("Cliente com ID " + id + " não encontrado para exclusão.");
        }
        repoCli.deleteById(id);
    }

    public Cliente findByEmailAndSenha(String email, String senha) {
        return repoCli.findByEmailAndSenha(email, senha).orElse(null);
    }
}