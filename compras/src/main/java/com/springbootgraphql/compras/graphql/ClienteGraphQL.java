package com.springbootgraphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(final Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(final Long id, final String nome, final String email) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        return clienteService.save(cliente);
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }

}
