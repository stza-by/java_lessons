package part_1.step_4;

public class OOP {

    public static void main(String[] args) {
        Person person1 = new Person("Jon", "Show");
        System.out.println(person1);
        Person person2 = new Person("Jon", "Show");
        System.out.println(Person.instanceCount);
    }
}

/*
1. Статические поля и методы
2. Изменяемые и неизменяемые объекты
 */
