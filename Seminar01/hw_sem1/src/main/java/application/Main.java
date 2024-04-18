package application;

import com.google.gson.Gson;
import domain.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", "Ivanov", 29);
        Person person2 = new Person("Ivan", "Ivanov", 29);
        Person person3 = new Person("Petya", "Ivanov", 29);
        Person person4 = new Person("Ivan", "Ivanov", 19);
        System.out.println(person1.hashCode());
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));
        System.out.println(person1.equals(person4));

        Gson gson = new Gson();
        String json = gson.toJson(person1);
        System.out.println(json);
        Person readPerson = gson.fromJson(json, Person.class);
        System.out.println(readPerson);
    }
}
