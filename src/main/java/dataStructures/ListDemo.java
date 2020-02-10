package dataStructures;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class ListDemo {

    private LinkedList<Integer> myDoublyLinkedList = new LinkedList<>();

    public static void main(String[] args) {
        ListDemo ld = new ListDemo();
        ld.createAndPrintValues();
    }

    private void createAndPrintValues() {
        generateValues();
        printValues();
    }

    private void printValues() {
        ListIterator<Integer> listIterator = myDoublyLinkedList.listIterator();
        while (listIterator.hasNext()) {
            int elem = listIterator.next();
            System.out.println(elem);
        }
        System.out.println("removing first with pollFirst");
        System.out.println(myDoublyLinkedList.pollFirst());

        System.out.println("removing first with poll");
        System.out.println(myDoublyLinkedList.poll());

        System.out.println("examining last with peekLasy");
        System.out.println(myDoublyLinkedList.peekLast());

        System.out.println("Remaining elements:");
        listIterator = myDoublyLinkedList.listIterator();
        while (listIterator.hasNext()) {
            int elem = listIterator.next();
            System.out.println(elem);
        }
    }

    private void generateValues() {
        myDoublyLinkedList.addFirst(9);
        myDoublyLinkedList.add(4);
        myDoublyLinkedList.add(19);
        myDoublyLinkedList.addLast(10);
    }
}
