package com.wallace.spring.boot.padroes.projetos.dto;

import java.io.Serializable;

// Esta classe é um DTO para a resposta de autenticação, contendo o token JWT
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}