package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;

import java.io.IOException;

public class Exercise2BasicFluxOperations {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(u -> System.out.println(u));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
