package com.guisfco;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    static void main() {
        // Using existing Functional Interfaces to apply some behavior
        Function<String, String> toUpperCase = s -> s.toUpperCase();
        Consumer<String> greeting = name -> IO.println("Hello, " + name);

        var name = toUpperCase.apply("Guilherme");
        greeting.accept(name);

        Callable<Void> callExternalService = () -> {
            IO.println("Calling external service...");
            throw new RuntimeException("Could not call external service");
        };

        ignoreException(callExternalService);
    }

    // Using Functional Interfaces as parameter
    static void ignoreException(Callable<Void> callable) {
        try {
            callable.call();
        } catch (Exception e) {
            IO.println("An exception was thrown and it will be ignored: " + e);
        }

    }
}
