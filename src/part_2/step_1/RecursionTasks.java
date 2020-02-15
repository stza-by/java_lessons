package part_2.step_1;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionTasks {

    int fibonVersion1(int n) {
        if (n <= 1) return n;

        return fibonVersion1(n - 1) + fibonVersion1(n - 2);
    }

    int fibonVersion2(int n) {

        if (n <= 1) return n;

        ArrayList<Integer> fibNumbers = new ArrayList<>(Arrays.asList(0, 1));

        for (int index = 2; index <= n; index++) {
            int current = fibNumbers.get(index - 1) + fibNumbers.get(index - 2);
            fibNumbers.add(current);
        }

        return fibNumbers.get(n);
    }
}
