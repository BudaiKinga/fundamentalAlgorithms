package collections;

import graph.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main
{

    public static void main(String[] args)
    {
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
