package com.guisfco.api.reflection;

import java.util.Arrays;

public class Main {

    static void main() throws NoSuchFieldException, IllegalAccessException {
        var clazz = Person.class;
        IO.println(clazz.getName());
        IO.println(clazz.getSimpleName());

        /*
         * The methods getFields, getMethods, getConstructors returns only items with public access level, including the inherited ones.
         * Now, the methods such as getDeclaredFields, getDeclaredMethods and getDeclaredConstructors returns all access levels, but excludes the inherited ones.
         * */

        IO.println("\nReading fields:");
        for (var field : clazz.getDeclaredFields()) {
            IO.println("\t" + field.getName());
        }

        IO.println("\nReading methods:");
        for (var method : clazz.getDeclaredMethods()) {
            IO.println("\t" + method.getName());
        }

        IO.println("\nReading constructors:");
        for (var constructor : clazz.getDeclaredConstructors()) {
            IO.println("\t" + constructor.getName() + Arrays.toString(constructor.getParameters()));
        }

        IO.println("\nGetting fields:");

        // Getting private field (with no getter method available) and changing its visibility
        var person = new Person("Guilherme", 25);
        var field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        IO.println(field.get(person));
    }
}
