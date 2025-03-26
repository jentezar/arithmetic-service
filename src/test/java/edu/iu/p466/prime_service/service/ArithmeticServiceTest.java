package edu.iu.p466.prime_service.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticServiceTest {

    private final ArithmeticService arithmeticService = new ArithmeticService();

    @Test
    void testAdd() {
        assertEquals(4, arithmeticService.add(2, 2));
        assertEquals(0, arithmeticService.add(0, 0));
        assertEquals(-1, arithmeticService.add(-2, 1));
        assertEquals(100, arithmeticService.add(40, 60));
    }
} 