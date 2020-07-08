package com.springbootgraphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springbootgraphql.compras.Cliente;
import com.springbootgraphql.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cliente(final Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente saveCliente(final Long id, final String nome, final String email) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Boolean deleteCliente(Long id) {
        if (clienteRepository.findById(id).isPresent()){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
