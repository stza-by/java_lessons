package part_2.step_2;

import java.util.HashMap;
import java.util.Set;

public class CollectionsTasks {

    void parseStr(String str) {

        HashMap<Character, Integer> charTable = new HashMap<>();

        for (Character letter : str.toCharArray()) {

            if (letter.equals(' ')) continue;

            if (!charTable.containsKey(letter)) {
                charTable.put(letter, 1);
            } else {
                int oldValue = charTable.get(letter);
                charTable.put(letter, ++oldValue);
            }
        }

        for (Character key : charTable.keySet())
            System.out.println(key + " -- " + charTable.get(key));
    }
}
