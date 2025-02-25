package edu.iu.p466.prime_service.controller;

import edu.iu.p466.prime_service.service.IPrimeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimeController {

    IPrimeService primesService;
    
    //prime service injection
    public PrimeController(IPrimeService primesService)
    {
        this.primesService = primesService;
    }
    //calls service to check if number is prime
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        return primesService.isPrime(n);
    }
}
