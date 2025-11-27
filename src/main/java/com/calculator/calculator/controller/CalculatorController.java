package com.calculator.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller providing calculator operations.
 */
@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    /**
     * Adds two numbers.
     *
     * @param a first number
     * @param b second number
     * @return sum
     */
    @GetMapping("/add")
    public double add(@RequestParam final double a, @RequestParam final double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     */
    @GetMapping("/subtract")
    public double subtract(@RequestParam final double a, @RequestParam final double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     */
    @GetMapping("/multiply")
    public double multiply(@RequestParam final double a, @RequestParam final double b) {
        return a * b;
    }

    /**
     * Divides two numbers.
     */
    @GetMapping("/divide")
    public double divide(@RequestParam final double a, @RequestParam final double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Computes a to the power of b.
     */
    @GetMapping("/power")
    public double power(@RequestParam final double a, @RequestParam final double b) {
        return Math.pow(a, b);
    }

    /**
     * Computes square root.
     */
    @GetMapping("/sqrt")
    public double sqrt(@RequestParam final double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Nombre négatif impossible");
        }
        return Math.sqrt(a);
    }

    /**
     * Computes natural log.
     */
    @GetMapping("/log")
    public double log(@RequestParam final double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Nombre doit être > 0");
        }
        return Math.log(a);
    }

    /**
     * Computes log base 10.
     */
    @GetMapping("/log10")
    public double log10(@RequestParam final double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Nombre doit être > 0");
        }
        return Math.log10(a);
    }

    /**
     * Computes factorial.
     */
    @GetMapping("/factorial")
    public long factorial(@RequestParam final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Nombre doit être >= 0");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Computes sine in degrees.
     */
    @GetMapping("/sin")
    public double sin(@RequestParam final double a) {
        return Math.sin(Math.toRadians(a));
    }

    /**
     * Computes cosine in degrees.
     */
    @GetMapping("/cos")
    public double cos(@RequestParam final double a) {
        return Math.cos(Math.toRadians(a));
    }

    /**
     * Computes tangent in degrees.
     */
    @GetMapping("/tan")
    public double tan(@RequestParam final double a) {
        return Math.tan(Math.toRadians(a));
    }

    /**
     * Computes arcsine in degrees.
     */
    @GetMapping("/asin")
    public double asin(@RequestParam final double a) {
        return Math.toDegrees(Math.asin(a));
    }

    /**
     * Computes arccosine in degrees.
     */
    @GetMapping("/acos")
    public double acos(@RequestParam final double a) {
        return Math.toDegrees(Math.acos(a));
    }

    /**
     * Computes arctangent in degrees.
     */
    @GetMapping("/atan")
    public double atan(@RequestParam final double a) {
        return Math.toDegrees(Math.atan(a));
    }
}
