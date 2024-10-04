package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.StreamSources;

public class Exercise1BasicStreamOperations {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // StreamSources.intNumbersStream().forEach(n -> System.out.print(n+" "));

        // Print numbers from intNumbersStream that are less than 5
        // StreamSources.intNumbersStream().filter(n -> n<5).forEach(n -> System.out.print(n));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // StreamSources.intNumbersStream().filter(n -> n>5).skip(1).limit(2).forEach(n -> System.out.print(n + " "));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // System.out.print(StreamSources.intNumbersStream().filter(x -> x  >5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        // StreamSources.userStream().map(u -> u.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream


        StreamSources.userStream().filter(
                user -> StreamSources.intNumbersStream().anyMatch( i -> i == user.getId())
            ).forEach(u -> System.out.println(u.getFirstName()));


    }

}
