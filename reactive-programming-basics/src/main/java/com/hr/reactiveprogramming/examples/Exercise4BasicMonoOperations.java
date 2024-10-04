package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;

import java.io.IOException;
import java.util.Optional;

public class Exercise4BasicMonoOperations {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Optional<Integer> optionalInteger = ReactiveSources.intNumberMono().blockOptional();
        System.out.println(optionalInteger.isPresent() ? optionalInteger.get() : null);

        /*
            Get List as Mono. Here the list is considered as a single item and is returned in one go.
         */
        ReactiveSources.userListMono().subscribe(list -> System.out.println("Mono User List : "+list.get(0)));


        System.out.println("Press a key to end");
        System.in.read();
    }

}
