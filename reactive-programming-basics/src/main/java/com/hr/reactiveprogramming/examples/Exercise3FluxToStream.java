package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3FluxToStream {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        final List<Integer> list = ReactiveSources.intNumbersFlux().log().toStream().
                collect(Collectors.toList());
        System.out.println("List Size : "+list.size());

    }

}
