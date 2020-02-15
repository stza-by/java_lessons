package part_1.step_3;
import java.util.Scanner;

public class Loops {

    static String menuItems = "1. Пункт 1\n" +
            "2. Пункт 2\n";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(menuItems);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("Вы выбрали первый пункт");
                break;
            case 2:
                System.out.println("Вы выбрали второй пункт");
                break;
            default:
                System.out.printf("Вы ввели: %d", userInput);
        }
    }
}

/*
1. Какие виды циклов вы знаете ?
2. Операторы break & continue
3. Оператор switch
4. Напишите программу которая будет циклически выполняться пока пользователь не введет 0
 */