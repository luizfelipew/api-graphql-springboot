package com.springbootgraphql.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b){
        return a + b;
    }

    public Cliente cliente(){
        return new Cliente("Luiz Felipe", "teste@email.com");
    }

}
