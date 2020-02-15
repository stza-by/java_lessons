package part_2.step_2;

import java.util.HashMap;

public class Collections {

    HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new CollectionsTasks().parseStr("I love programming");
    }
}

/*
 1. Написать функцию, которая принимает строку и выодит на экран таблицу из двух колонок.
 Левая колонока - это символы, правая - количество в строке

  б -- 2
  к -- 10
  т -- 1
  е -- 12

 2. Отфильтровать все символы которые не являються буквами
 */
