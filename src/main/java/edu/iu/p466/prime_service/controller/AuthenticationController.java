package edu.iu.p466.prime_service.controller;

import edu.iu.p466.prime_service.model.Customer;
import edu.iu.p466.prime_service.service.IAuthenticationService;
import edu.iu.p466.prime_service.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    IAuthenticationService authenticationService, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    //cals service to register customer
    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer) {
        try {
            return authenticationService.register(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //returns jwt token if credentials are authorized
    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customer.getUsername(),
                        customer.getPassword()
                )
        );
        return tokenService.generateToken(authentication);
    }


}
