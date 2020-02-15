package part_2.step_1;

public class Recursion {

    public static void main(String[] args) {

        new Recursion().recursionFunction(10);

//        RecursionTasks tasks = new RecursionTasks();
//
//        System.out.println(tasks.fibonVersion1(10));
//        System.out.println(tasks.fibonVersion2(10));
    }


    void recursionFunction(int n) {
        System.out.print(n + " ");
        if (n == 0) return;
        recursionFunction(n - 1);
        // System.out.print(n + " ");
    }

}

/*
 * 1. Реализуйте собственную рекурсивную функцию, которая вернет ArrayList с числами от 0 до 10
 *
 * 2. Реализовать функцию вычисляющую определенное количество чисел фибоначи Фибоначи с помощью рекурсии
 *
 *      static int fibon(int n) {}
 *
 * 3. Реализовать задание 2 без использования рекурсии
 *
 * 4. Релизовать кэширование запросов
 *
 * 5. Определить какой метод работает быстрее
 * https://www.baeldung.com/java-measure-elapsed-time
 */



