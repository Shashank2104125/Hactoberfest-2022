import java.util.ArrayList;
import java.util.*;

public class binaryTree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println(height(root));
        System.out.println(size(root));
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        printLeftView(root);
    }

    // implemnentation of binary tree with the help of linked list

    static Node createTree() {
        Node root = null;
        System.out.println("Enter a data");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        root = new Node(data);
        System.out.println("Enter left data  for" + " " + data);
        root.left = createTree();
        System.out.println("Enter right data for" + " " + data);
        root.right = createTree();
        return root;
    }

    // finding the height of binary tree with the help of linked list
    static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // finding the size of the of tree with the help of the linked list
    static int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    // finding the maximum in the binary tree
    static int minimum(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }

    // traversal
    // inorder
    static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    // preOrder
    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);

    }

    static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);

        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // right view of a binarty treee using the liked list

    static void printLeftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        for (Node cur : list) {
            System.out.println(cur.data + " ");
        }
    }

    static void printLeftViewUtil(Node root, ArrayList<Node> list, int level) {
        if (root == null)
            return;

        if (list.get(level) == null) {
            list.add(root);
        }
        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);

    }

}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}
