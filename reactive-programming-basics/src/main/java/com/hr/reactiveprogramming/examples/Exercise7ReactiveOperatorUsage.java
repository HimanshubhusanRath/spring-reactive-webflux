package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;

import java.io.IOException;

public class Exercise7ReactiveOperatorUsage {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux().log()
//                .filter(n -> n > 5)
//                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .filter( n-> n>5)
//                .map( n-> n*10).log()
//                .subscribe(x -> System.out.println(x));

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .filter( n-> n >5)
//                        .map(n->n*10)
//                                .take(3)
//                .subscribe(x -> System.out.println(x));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
//        ReactiveSources.intNumbersFlux().log()
//                .filter( n -> n>20)
//                        .defaultIfEmpty(-1)
//                                .subscribe(x -> System.out.println(x));

        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here

        // Print only distinct numbers from intNumbersFluxWithRepeat
//        ReactiveSources.intNumbersFluxWithRepeat()
//                .distinct()
//                .log()
//                .subscribe(i -> System.out.println(i));

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers (skip the number if it is same as last number)
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(i -> System.out.println(i));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
