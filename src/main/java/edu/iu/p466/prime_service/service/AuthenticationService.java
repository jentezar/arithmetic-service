package edu.iu.p466.prime_service.service;

import edu.iu.p466.prime_service.model.Customer;
import edu.iu.p466.prime_service.repository.IAuthenticationRepository;
import org.apache.catalina.Authenticator;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService implements IAuthenticationService, UserDetailsService {

    private final IAuthenticationRepository authenticationRepository;

    //authentication repository injection
    public AuthenticationService(IAuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }
    //hashes password and registers user
    @Override
    public boolean register(Customer customer) throws IOException {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(customer.getPassword());
        customer.setPassword(passwordEncoded);

        return authenticationRepository.save(customer);
    }
    //loads user details 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Customer customer = authenticationRepository.findByUsername(username);
            if (customer == null) {
                throw new UsernameNotFoundException("");
            }

            return User
                    .withUsername(username)
                    .password(customer.getPassword())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //authenticate user with hashed password
    @Override
    public boolean login(String username, String password) throws IOException {
        Customer customer = authenticationRepository.findByUsername(username);

        if (customer == null) {
            return false;
        }
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

        return bc.matches(password, customer.getPassword());
    }
}

