package com.troyka.market.web.controller;

import com.troyka.market.domain.dto.AuthenticationRequest;
import com.troyka.market.domain.dto.AuthenticationResponse;
import com.troyka.market.domain.service.TroykaUserDetailsService;
import com.troyka.market.web.security.JWTUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3005")
public class AuthController {
    private Log LOGGER = LogFactory.getLog(AuthController.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TroykaUserDetailsService troykaUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            LOGGER.info("Hemos entrado al Metodo authenticate");
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            UserDetails userDetails = troykaUserDetailsService.loadUserByUsername(request.getUsername());
            String jwt= jwtUtil.generateToken(userDetails);
            LOGGER.debug("El tiempo de duracion del token es: " + jwtUtil.validateToken(jwt,userDetails));
           return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
        }catch (BadCredentialsException e){
           return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
