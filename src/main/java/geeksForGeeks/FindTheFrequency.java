package geeksForGeeks;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BudaiK on Feb, 2020.
 * <p>
 * https://practice.geeksforgeeks.org/problems/find-the-frequency/1
 * <p>
 * Given a vector of N positive integers and an integer X. The task is to find the frequency of X in vector.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * First line of input contains number of testcases T. For each testcase there will be three lines. First line of which contains N, size of vector. Second line contains N positive integers seperated by space, and third line contains X, whose frequency is required.
 * <p>
 * Output Format:
 * For each testcase, print the frequency of X.
 * <p>
 * User Task:
 * Your task is to complete the function findFrequency() which should count the frequency of X and return it.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 106
 * 1 <= V[i] <= 1016
 * <p>
 * Example:
 * Input:
 * 1
 * 5
 * 1 1 1 1 1
 * 1
 * Output:
 * 5
 */
public class FindTheFrequency {


    public static void main(String[] args) {
        FindTheFrequency fr = new FindTheFrequency();
        int res = fr.findFrequency(Arrays.asList(1, 2, 3, 2, 4, 5, 6, 2, 3, 5, 2), 2);
        System.out.println("Res = " + res);
    }

    private int findFrequency(List<Integer> vector, int elem) {
        int count = 0;
        for (int v : vector) {
            if (v == elem) {
                count++;
            }
        }
        return count;
    }
}
