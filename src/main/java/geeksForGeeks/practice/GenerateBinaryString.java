package geeksForGeeks.practice;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/generate-binary-string/0
 */

public class GenerateBinaryString {

    public static List<String> results = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nrTest = sc.nextInt();
        for (int i = 0; i < nrTest; i++) {
            String input = sc.next();
            generate(input);
            print();
        }
    }

    public static void generate(String input) {
        int regex = -1;
        int last = 0;
        while ((regex = input.indexOf("?", last)) > 0) {
            String first = input.substring(last, regex);
            addToResults(first);
            addToResults();
            input = input.substring(regex);
        }


//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == '?') {
//                addToResults();
//            } else {
//                //add character to every element
//                addToResults(String.valueOf(c));
//            }
//        }
    }

    public static void addToResults() {
        if (results.isEmpty()) {
            results.add("1");
            results.add("0");
            return;
        } else {
            List<String> other = new LinkedList<>();
            for (String res : results) {
                String newElem = res + "0";
                other.add(newElem);
                newElem = res + "1";
                other.add(newElem);

            }
            results = new LinkedList<>(other);
        }


    }

    public static void addToResults(String c) {
        if (results.isEmpty()) {
            results.add(c);
            return;
        }
        List<String> other = new LinkedList<>();
        for (String res : results) {
            String newElem = res + c;
            other.add(newElem);
        }
        results = new LinkedList<>(other);
    }

    public static void print() {
        if (results.size() > 0) {
            for (int i = 0; i < results.size() - 1; i++) {
                System.out.print(results.get(i) + " ");
            }
            System.out.println(results.get(results.size() - 1));
        }
    }
}