package go.azabelin.homework3;

import java.util.Arrays;
import java.util.HashMap;

public class DuplicatesChecker {
    public static void printDuplicates(String[] names) {
        HashMap<String, Integer> tmp = new HashMap<>();

        for (String name: names) {
            if (tmp.containsKey(name)) {
                Integer count = tmp.get(name);
                count++;
                tmp.put(name, count);
            } else {
                tmp.put(name, 1);
            }
        }

        System.out.println(Arrays.asList(tmp));
    }
}
