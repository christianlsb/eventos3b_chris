//package br.com.split.controllers;
//
//import br.com.split.dto.LoginDTO;
//import br.com.split.dto.TokenDTO;
//import br.com.split.services.TokenService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;
//
//
//
//    @PostMapping
//    public ResponseEntity<TokenDTO> auth(@RequestBody @Validated LoginDTO loginDTO){
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
//                loginDTO.getPassword());
//
//        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        String token = tokenService.generateToken(authentication);
//
//
//        return ResponseEntity.ok(TokenDTO.builder().type("Bearer").token(token).build());
//
//    }
//
//
//}
