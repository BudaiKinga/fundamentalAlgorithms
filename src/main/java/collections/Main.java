package collections;

import graph.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main
{

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.empty()) {
            System.out.println(stack.pop());
        }

        List<Integer> listOfFindings = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int listSize = listOfFindings.size();
        System.out.println("List size: " + listSize);
        int startIndex = 0;
        int batchSize = 3;
        int endIndex;
        while (startIndex < listSize) {
            endIndex = startIndex + batchSize;
            if (endIndex > listSize) {
                endIndex = listSize;
            }
            List<Integer> elems = listOfFindings.subList(startIndex, endIndex);
            System.out.println(elems);
            startIndex = endIndex;
        }


        Set<Integer> intsHashSet = new HashSet<>();
        intsHashSet.add(9);
        intsHashSet.add(8);
        intsHashSet.add(7);

        System.out.println("HashSet of ints performs contains on value");
        System.out.println(intsHashSet.contains(1));

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        set1.retainAll(set2);

        System.out.println("intersection of two sets can be obtained by retainAll (from Collection) method ");
        System.out.println(Arrays.toString(set1.toArray()));

        List<Pair> mypairs = new ArrayList<>();
        mypairs.add(new Pair(1,2));
        System.out.println(mypairs);
    }

}
