package dataStructures;

public class Tree<E>
{
    Node<E> root;

    public static <E> int height(Node<E> node)
    {
        if (node == null)
        {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1, null, null);
        Node<Integer> node2 = new Node<>(2, node1, null);
        Node<Integer> node4 = new Node<>(4, null, null);
        Node<Integer> node3 = new Node<>(3, node2, node4);
        Node<Integer> node6 = new Node<>(6, null, null);
        Node<Integer> node9 = new Node<>(9, null, null);
        Node<Integer> node7 = new Node<>(7, node6, node9);
        Node<Integer> node5 = new Node<>(5, node3, node7);

        System.out.println("Tree height: " + Tree.height(node5));
    }
}
