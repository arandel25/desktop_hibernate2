/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import entidade.Endereco;

/**
 * @author Felipe
 */
public class EnderecoWebService {

    private Client client;
    private WebResource webResource;

    public EnderecoWebService() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
//        Utilizado para imprimir as operacoes no console
        client.addFilter(new LoggingFilter(System.out));
//        
        webResource = client.resource("https://viacep.com.br/ws/");
    }

    public Endereco pesquisaCep(String cep) {
        return webResource.path(cep).path("/json").get(Endereco.class);
//        return webResource.path(cep).path("/json").get(new GenericType<Endereco>() {
//        });
    }
    
}
