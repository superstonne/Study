package org.jinlong.study.java8;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OptionalDemo {

    public static void main(String[] args) {
        Optional<Person> person = Optional.of(new Person("Nick", 20));
        Optional<Person> nullPerson = Optional.ofNullable(null);

        System.out.println(person.filter((p) -> p.getAge() == 20));

        System.out.println(person.get());

//        System.out.println(nullPerson.get());

        System.out.println(nullPerson.orElse(new Person("Nick1", 20)));
        System.out.println(person.orElse(new Person("Nick1", 20)));

        nullPerson.orElseGet(() -> { return new Person("a", 20);});

        nullPerson.orElseThrow(() -> new NullPointerException("a"));

        person.ifPresent(person1 -> {
            if (person1.getName().equals("Nick")) {
                System.out.println("Nick");
            } else {
                System.out.println("Wrong");
            }
        });

        Optional<String> personString = person.map((p) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(p.getAge());
            builder.append(p.getName());
            return builder.toString();
        });


        Optional<Persona> persona = person.flatMap((p) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(p.getAge());
            builder.append(p.getName());
            return Optional.of(new Persona(p.getName(), p.getAge()));
        });

        System.out.println(persona);

        System.out.println(personString.get());


    }
}

class Persona {
    private String name;
    private int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
