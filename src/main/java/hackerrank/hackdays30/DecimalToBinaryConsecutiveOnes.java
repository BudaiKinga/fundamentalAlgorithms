package hackerrank.hackdays30;

/**
 * Created by BudaiK on Mar, 2020.
 */

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryConsecutiveOnes {

    private static Stack<Integer> stack = new Stack<>();

    private static int getConsecutive(int n) {
        /*
        while(n > 0):
            remainder = n%2;
            n = n/2;
            Insert remainder to front of a list or push onto a stack
        */
        int remainder;
        while (n > 0) {
            remainder = n % 2;
            n = n / 2;
            stack.push(remainder);
        }

        String res = "";
        int maxNrOfCons = 0;
        int currNr = 0;
        while (!stack.empty()) {
            int r = stack.pop();
            res+= String.valueOf(r);
            if (r == 1) {
                currNr++;
            } else {
                if (maxNrOfCons < currNr) {
                    maxNrOfCons = currNr;
                }
                currNr = 0;
            }
        }
        System.out.println(res);
        if (currNr > maxNrOfCons) {
            return currNr;
        }
        return maxNrOfCons;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        int consOne = getConsecutive(n);
        System.out.println(consOne);
    }
}
