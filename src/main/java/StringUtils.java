import java.util.HashMap;
import java.util.Map;

/**
 * Created by BudaiK on Feb, 2021.
 */
public class StringUtils {

    public static void main(String[] args) {
        // compute if absent
        Map<Integer, Map<String, String>> myMap = new HashMap<>();

        myMap.computeIfAbsent(1, key -> new HashMap<>()).put("str1", "str2");
        myMap.computeIfAbsent(1, key -> new HashMap<>()).put("str1", "str3");
        myMap.computeIfAbsent(1, key -> new HashMap<>()).put("str1", "str4");

        for (int i = 0; i < 3; i++) {
            System.out.println(myMap.get(i));
        }


        // Replace colon in a string
        String str = "*Molecule:Treatment*";
        str = str.replaceAll(":", "\\:");
        System.out.println(str);
    }
}
