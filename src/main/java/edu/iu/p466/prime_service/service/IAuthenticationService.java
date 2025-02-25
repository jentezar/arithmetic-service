package edu.iu.p466.prime_service.service;

import edu.iu.p466.prime_service.model.Customer;

import java.io.IOException;

public interface IAuthenticationService {
    //register customer
    boolean register(Customer customer) throws IOException;
    //authenticate customer
    boolean login(String username, String password) throws IOException;
}
