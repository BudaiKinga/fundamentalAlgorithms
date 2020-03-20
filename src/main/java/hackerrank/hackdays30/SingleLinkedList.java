package hackerrank.hackdays30;

/**
 * Created by BudaiK on Mar, 2020.
 */

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class SingleLinkedList {

    public static  Node insert(Node head,int data) {
        Node n = new Node(data);
        if (head == null) {
            return n;
        }
        Node it = head;
        while (it.next != null) {
            it = it.next;
        }
        it.next = n;
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}