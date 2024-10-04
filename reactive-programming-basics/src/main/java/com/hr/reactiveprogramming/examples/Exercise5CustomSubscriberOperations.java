package com.hr.reactiveprogramming.examples;

import com.hr.reactiveprogramming.datasources.ReactiveSources;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5CustomSubscriberOperations {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                num -> System.out.println(num),
//                err -> System.out.println(err),
//                () -> System.out.println("Completed")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

    static class MySubscriber<T> extends BaseSubscriber<T> {

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscription happened");
            request(1);
        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println(value.toString() + " received");
            request(1);
        }

        @Override
        protected void hookOnComplete() {
            System.out.println("Completed");
        }
    }

}