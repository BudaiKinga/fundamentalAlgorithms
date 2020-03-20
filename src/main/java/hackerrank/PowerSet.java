package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by BudaiK on Mar, 2020.
 */
public class PowerSet {

    public static void main(String[] args) {
        System.out.println(powerSet(new int[] {1,2,3}));
    }

    private static List<List<Integer>> powerSet(int[] ints) {
        List<List<Integer>> result = new LinkedList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        LinkedList<Integer> e = new LinkedList<>(Arrays.asList(1, 2, 3));
        e.get(1);
        resultSet.add(e);
        resultSet.add(new LinkedList<>(Arrays.asList(1,2,3)));
        return new LinkedList<>(resultSet);
    }
}
