package geeksForGeeks.practice;

import java.util.Arrays;

/**
 * Created by BudaiK on Feb, 2020.
 *
 * https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
 */
public class Triplet {

    public boolean findTripletsOn3(int arr[] , int n)
    {
        int[][][] sol = new int [n][n][n];
        for (int i =0; i<n; i++) {
            for (int j =0; j<n; j++) {
                for (int k =0; k<n; k++) {
                    if (arr[i]+arr[j]+arr[k] == 0 && i != j && j!= k &&i!=k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Triplet tr = new Triplet();
        int[] a = new int[] {1,2,3};
        int[] b = new int[] {0, -1, 2, -3, 1};
        System.out.println("First O(n^3): ");
        System.out.println(tr.findTripletsOn3(a, a.length));
        System.out.println(tr.findTripletsOn3(b, b.length));

        System.out.println("First O(n^2): ");
        System.out.println(tr.findTripletsOn2(a, a.length));
        System.out.println(tr.findTripletsOn2(b, b.length));


    }

    private boolean findTripletsOn2(int[] b, int length) {
        // sort
        Arrays.sort(b);

        for (int i =0; i<length-1; i++) {
            int elem = b[i];
            int l = i+1;
            int r = length-1;
            while (l<r) {
                int sum = elem + b[l] + b[r];
                if (sum == 0) {
                    return true;
                }
                if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return false;
    }
}
