package streams;

import java.util.List;
import java.util.function.Predicate;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", FEMALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Jane", PREFER_NOT_TO_SAY)
        );

//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);
        Predicate<Person> personPredicate = person -> person.gender.equals(PREFER_NOT_TO_SAY);
        boolean containsOnlyFemales = people.stream()
                .noneMatch(personPredicate);
        System.out.println(containsOnlyFemales);


    }


    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY,
    }
}