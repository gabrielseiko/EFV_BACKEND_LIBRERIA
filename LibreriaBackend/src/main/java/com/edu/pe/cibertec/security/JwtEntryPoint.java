package com.edu.pe.cibertec.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.apachecommons.CommonsLog;

@Component
@CommonsLog
public class JwtEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        log.error("JwtEntryPoint>> SC_UNAUTHORIZED >> no autorizado");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario no Autorizado");
    }
}
