package com.wallace.spring.boot.padroes.projetos.dto;

import java.io.Serial;
import java.io.Serializable;

// Esta classe é um DTO (Data Transfer Object) para a requisição de autenticação
public class JwtRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

    // Construtor padrão necessário para deserialização JSON
    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}