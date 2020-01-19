package step_5;

import java.util.ArrayList;

import step_4.Person;

public class DataStructures {

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        Person myPerson = new Person("Jon", "Snow");
        personList.add(myPerson);   // добавить новый элемент в конец списка
        personList.add(myPerson);

        System.out.println("Size: " + personList.size());

        for (Person obj : personList) {
            System.out.println(obj);
        }

        myPerson.firstName = "New name";
        for (Person obj : personList) {
            System.out.println(obj);
        }

        System.out.println("---------------------------");

        Person myPerson2 = new Person("Arya", "Stark");
        personList.add(1, myPerson2); // добавить новый элемент в заданую позицию
        System.out.println("Size: " + personList.size());

        for (Person obj : personList) {
            System.out.println(obj);
        }

        System.out.println("Get by index " + personList.get(1)); // получить элемент по индексу
        System.out.println("Remove by index " + personList.remove(0)); // удалить элемент по индексу

        System.out.println("Size: " + personList.size());
    }
}
