package edu.iu.p466.prime_service.controller;

import edu.iu.p466.prime_service.service.IArithmeticService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ArithmeticController {

    private final IArithmeticService arithmeticService;
    
    public ArithmeticController(IArithmeticService arithmeticService) {
        this.arithmeticService = arithmeticService;
    }

    @GetMapping("/add/{n}/{m}")
    public int add(@PathVariable int n, @PathVariable int m) {
        return arithmeticService.add(n, m);
    }
} 