package geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
 */

public class BSTNodesFromRange {

    //Complete this function
    public static int getCountOfNode(Node root, int l, int h) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                continue;
            }
            if (current.data < l) {
                queue.add(current.right);
                continue;
            }
            if (current.data > h) {
                queue.add(current.left);
                continue;
            }
            result++;
            queue.add(current.left);
            queue.add(current.right);
        }
        return result;
    }


    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
