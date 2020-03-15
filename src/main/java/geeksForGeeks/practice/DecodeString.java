package geeksForGeeks.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by BudaiK on Mar, 2020.
 * <p>
 * https://practice.geeksforgeeks.org/problems/decode-the-string/0
 */
public class DecodeString {

    private static final String INPUT = "3[a3[b]1[ab]]";
    private static final String INPUT1 = "3[b2[ca]]";
    private static final String INPUT2 = "1[b]";
    //bcacabcacabcaca
    //bcacabcacabcaca

    public static void main(String[] args) {
        int[] ints = {1, 2, 1};
        List<Integer> res = Arrays.stream(ints).boxed().collect(Collectors.toList()).subList(1,2);



        DecodeString ds = new DecodeString();

        String result = ds.decode(INPUT2);
        System.out.println(result);
    }

    private String decode(String input) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                stack.push(i);
                continue;
            }
            if (input.charAt(i) == ']') {
                int oldLength = input.length();
                input = decodeInterval(input, stack.pop(), i);
                int newLength = input.length();
                i += newLength - oldLength;
            }
        }

        return input;
    }

    private String decodeInterval(String input, int start, int end) {
        int indexOfCount = start;
        while (indexOfCount > 0 && Character.isDigit(input.charAt(indexOfCount - 1))) {
            indexOfCount--;
        }
        int count = Integer.parseInt(input.substring(indexOfCount, start));
        String stringToDecode = input.substring(start + 1, end);
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < count; i++) {
            decoded.append(stringToDecode);
        }
        input = input.replace(input.substring(indexOfCount, end+1), decoded.toString());

        return input;
    }
}
