package hackerrank.hackdays30;

/**
 * Created by BudaiK on Mar, 2020.
 */

import java.util.Scanner;

public class MaxHourGlassSum {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int max = getMaxHourGlass(arr);
        System.out.println(max);

        scanner.close();
    }

    private static int getMaxHourGlass(int[][] arr) {
        int max = -70;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int currentSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1] +
                        arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (currentSum > max) {
                    max = currentSum;
                }
            }
        }
        return max;
    }
}
