package com.calculator.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Calculator Spring Boot application.
 * This class launches the Spring Boot application.
 */
@SpringBootApplication
public class CalculatorApplication {

    /**
     * Main method that starts the Spring Boot application.
     *
     * @param args application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
