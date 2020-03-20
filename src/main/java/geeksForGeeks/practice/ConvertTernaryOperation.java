package geeksForGeeks.practice;

/**
 * Created by BudaiK on Mar, 2020.
 */
public class ConvertTernaryOperation {

    public static Node convertExp(String str, int i)
    {

        if(i > str.length())
            return null;

        Node root = new Node(str.charAt(i));
        i++;
        if(i < str.length() && str.charAt(i) == '?')
            root.left = convertExp(str, i+1);
        if(i < str.length() && str.charAt(i) == ':')
            root.right = convertExp(str, i+1);

        return root;
    }

    public static class Node {
        char val;
        Node left;
        Node right;

        public Node(char v) {
            this.val =v;
        }
    }
}
