package com.springbootgraphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springbootgraphql.compras.Cliente;
import com.springbootgraphql.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cliente(final Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRepository.findAll();
    }

}