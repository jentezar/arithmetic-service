package edu.iu.p466.prime_service.repository;

import edu.iu.p466.prime_service.model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {
    //saves new user
    boolean save(Customer customer) throws IOException;
    //find existin user
    Customer findByUsername(String username) throws IOException;
}
