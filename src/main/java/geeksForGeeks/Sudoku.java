package geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sudoku {

//    public static int[][] d = new int[][]{
//            {3, 0, 6, 5, 0, 8, 4, 0, 0},
//            {5, 2, 0, 0, 0, 0, 0, 0, 0},
//            {0, 8, 7, 0, 0, 0, 0, 3, 1},
//            {0, 0, 3, 0, 1, 0, 0, 8, 0},
//            {9, 0, 0, 8, 6, 3, 0, 0, 5},
//            {0, 5, 0, 0, 9, 0, 6, 0, 0},
//            {1, 3, 0, 0, 0, 0, 2, 5, 0},
//            {0, 0, 0, 0, 0, 0, 0, 7, 4},
//            {0, 0, 5, 2, 0, 6, 3, 0, 0}};

    // public static int[][] d;
    // public static int i = -1, j = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nrTest = sc.nextInt();

        for (int test = 0; test < nrTest; test++) {
            List<Pair> zeros = new ArrayList<>();
            int[][] d = new int[9][9];
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    d[row][col] = sc.nextInt();
                    if (d[row][col] == 0) {
                        zeros.add(new Pair(row, col));
                    }
                }
            }

            int[][] s = new int[d.length][d.length];
            for (int i = 0; i < d.length; i++) {
                s[i] = Arrays.copyOf(d[i], d[i].length);
            }


            int zeroIndex = 0;
            while (zeroIndex >= 0 && zeroIndex < zeros.size()) {
                // find
                Pair p = getNextZero(zeros, zeroIndex);
                int i = p.getKey();
                int j = p.getValue();
                // step
                s[i][j]++;

                // check 1
                if (s[i][j] > 9) {
                    s[i][j] = 0;
                    zeroIndex--;
                    continue;
                }
                // check 2
                boolean isOk = checkRules(s, i, j);
                if (isOk) {
                    zeroIndex++;
                }
            }
            print(s);
        }
    }

    private static boolean checkRules(int[][] s, int i, int j) {
        int elem = s[i][j];
        for (int k = 0; k < 9; k++) {
            if (j != k && s[i][k] == elem) {
                return false;
            }
            if (i != k && s[k][j] == elem) {
                return false;
            }
        }
        int starti = i / 3;
        int startj = j / 3;
        for (int k = starti * 3; k < (starti + 1) * 3; k++) {
            for (int kk = startj * 3; kk < (startj + 1) * 3; kk++) {
                if (k != i && kk != j && s[k][kk] == elem) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Pair getNextZero(List<Pair> zeros, int zeroIndex) {
        return zeros.get(zeroIndex);
    }

    private static boolean isSolved(int[][] s) {
        for (int[] ints : s) {
            for (int j = 0; j < s.length; j++) {
                if (ints[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] s) {
        for (int[] ints : s) {
            for (int j = 0; j < s.length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
        System.out.println();
    }

    private static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        int getKey() {
            return i;
        }

        int getValue() {
            return j;
        }
    }
}
