package hackerrank;

import java.util.PriorityQueue;

/**
 * Created by BudaiK on Mar, 2020.
 */
class MyIterator {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[][] data = null;
    int[] k = null;

    public MyIterator(int[][] data) {
        this.data = data;
        k = new int[data.length];
        this.preProcess(data);
    }

    int next() {
        int tmp = pq.remove();
        this.postProcess(tmp);
        return tmp;

    }

    boolean hashNext() {
        return pq.isEmpty();

    }

    public void preProcess(int[][] data) {
        for (int i = 0; i < k.length; i++) {
            pq.add(data[i][k[i]]);
        }
    }

    public void postProcess(int removedData) {
        for (int i = 0; i < k.length; i++) {
            if (k[i] < data[i].length && data[i][k[i]] == removedData) {
                k[i] = k[i] + 1;
                if (k[i] < data[i].length) {
                    pq.add(data[i][k[i]]);
                }
                return;
            }
        }
    }
}

class IteratorInKSortedArray {

    public static void main(String[] args) {
        int[][] in = {
                {1, 5, 7},
                {2, 3, 10},
                {4, 6, 9}
        };


        MyIterator itr = new MyIterator(in);
        while (!itr.hashNext()) {
            System.out.print(itr.next() + " ");
        }

    }

}
