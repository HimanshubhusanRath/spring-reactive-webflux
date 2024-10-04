package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8ErrorHandling {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens

        // This code swallows (handles) the error
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(
//                        x -> System.out.println(x),
//                        throwable -> System.out.println(throwable)
//                );

        // This code does not swallow (handle) the error, throws it but can also perform certain action on error
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(err -> System.out.println("Error occurred : "+err))
//                .subscribe(x -> System.out.println(x));

        // Print values from intNumbersFluxWithException and continue on errors
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, item) -> System.out.println(" Error occurred for the value : " + item))
//                .subscribe(x -> System.out.println(x));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorResume(error -> Flux.just(-1, -2))
//                .subscribe(x -> System.out.println(x));

        // Print a message upon subscription is completed
//        ReactiveSources.intNumbersFlux()
//                .doFinally(
//                        signalType -> {
//                            if (SignalType.ON_COMPLETE.equals(signalType)) {
//                                System.out.println("Subscription is completed");
//                            } else if (SignalType.ON_ERROR.equals(signalType)) {
//                                System.out.println("Error in Subscription");
//                            }
//                        }
//                )
//                .subscribe(x -> System.out.println(x));

        // Print a message upon error in subscription
        ReactiveSources.intNumbersFluxWithException()
                .doFinally(
                        signalType -> {
                            if (SignalType.ON_COMPLETE.equals(signalType)) {
                                System.out.println("Subscription is completed");
                            } else if (SignalType.ON_ERROR.equals(signalType)) {
                                System.out.println("Error in Subscription");
                            }
                        }
                )
                .subscribe(x -> System.out.println(x));


        System.out.println("Press a key to end");
        System.in.read();
    }

}
