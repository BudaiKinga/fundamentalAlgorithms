package problems;

import dataStructures.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class MaxRange {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int[] array = new int[]{1, 5, 6, 4, 3};
        Map<Integer, Integer> q = new HashMap<>();
        q.put(2, 4);
        q.put(1, 2);
        q.put(3, 5);
        q.put(1, 4);

        Set<Integer> tree = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            tree.add(array[i]);
        }

        System.out.println(tree);

    }
}
