package geeksForGeeks.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class AllBitsOfLengthN {

    public static void main(String[] args) {
        int n = 3;
        Queue<String> queue = new LinkedList<>();
        generateBits(n, queue );
        print(queue);
    }

    private static void print(Queue<String> queue) {
        for(String s : queue) {
            System.out.println(s);
        }
    }

    private static void generateBits(int n, Queue<String> queue) {
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                queue.add("0");
                queue.add("1");
                continue;
            }
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                String elem = queue.poll();
                queue.add(elem + "0");
                queue.add(elem + "1");
            }
        }
    }
}
