package com.breed.govern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GovernApplicationTests {

    @Test
    void contextLoads() {



        double d=((45d/100)*(5.2d/100))+((30d/100)*(8.2d/100))+((20d/100)*(27.75d/100))+((5d/100)*(1.1d/100));
        System.out.println(d);
    }

}
