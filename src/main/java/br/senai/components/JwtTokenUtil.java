package br.senai.components;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    private static final long JWT_TOKEN_VALIDATY = 5 * 60 * 60;

    // JWT KEY
    @Value("$jwt.secret")
    private String secret_key;



}
