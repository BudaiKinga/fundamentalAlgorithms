package dataStructures;

public class Node<E>
{
    E value;
    Node<E> left;
    Node<E> right;

    public Node(E value, Node<E> left, Node<E> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
