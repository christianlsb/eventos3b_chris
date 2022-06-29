package br.com.split.config;


import br.com.split.models.Usuario;
import br.com.split.repository.UserRepository;
import br.com.split.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

//INTERCEPTA AS REQUISIÇÕES HTTP
public class TokenAuthencationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String tokenFromHandler = getTokenFromHeader(request);
        boolean tokenValid = tokenService.isTokenValid(tokenFromHandler);
        if(tokenValid){
            this.authenticate(tokenFromHandler);
        }

        filterChain.doFilter(request, response);

    }

    //AUTENTICA O TOKEN
    private void authenticate(String tokenFromHandler){
        Long user_id = tokenService.getTokenId(tokenFromHandler);

        Optional<Usuario> optUser = userRepository.findById(user_id);
        if (optUser.isPresent()){

            Usuario user = optUser.get();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, user.getRoles());

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request){
        // VERIFICA SE O TOKEN POSSUI UMA AUTHORIZATION OU É do TIPO BEARER
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            token = null;
        }

    
        return token != null ? token.substring(7, token.length()) : null;


    }



}
