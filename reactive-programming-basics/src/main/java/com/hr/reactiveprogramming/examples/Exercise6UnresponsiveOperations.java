package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;

import java.io.IOException;
import java.time.Duration;

public class Exercise6UnresponsiveOperations {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        final String value = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
        System.out.println(value);

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}
