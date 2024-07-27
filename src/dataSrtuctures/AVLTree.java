package dataSrtuctures;

import java.util.Map;
import java.util.TreeMap;

public class AVLTree {

    public static class Node{
        private int value;

        private int height = 0;
        private Node left ;
        private Node right = null;


        public Node(int value) {
            this.value = value;
        }



    }


    private static Node root;

    int height(Node n) {
        return n == null ? -1 : n.height;
    }

    void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }


    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        } else if (root.value > key) {
            root.left = insert(root.left, key);
        } else if (root.value < key) {
            root.right = insert(root.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(root);
    }

//    Node delete(Node node, int key) {
//        if (node == null) {
//            return node;
//        } else if (node.value > key) {
//            node.left = delete(node.left, key);
//        } else if (node.value < key) {
//            node.right = delete(node.right, key);
//        } else {
//            if (node.left == null || node.right == null) {
//                node = (node.left == null) ? node.right : node.left;
//            } else {
//                Node mostLeftChild = mostLeftChild(node.right);
//                node.value = mostLeftChild.value;
//                node.right = delete(node.right, node.value);
//            }
//        }
//        if (node != null) {
//            node = rebalance(node);
//        }
//        return node;
//    }

    Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.value == key) {
                break;
            }
            current = current.value < key ? current.right : current.left;
        }
        return current;
    }

    public void inOrder(Node current){
        if(current.left != null){
            inOrder(current.left);
            System.out.print(current.value + " ");
            if(current.right != null)
                inOrder(current.right);
        }
        else{
            System.out.print(current.value + " ");
        }

    }


    public void printTree(Node root){
//        Map<Node> childs = new TreeMap();
    }



    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        root = new Node(30);


         tree.insert(root, 50);
        tree.insert(root, 23);
        tree.insert(root, 27);
        tree.insert(root, 24);
        tree.insert(root, 10);

        System.out.println("  " + root.value);
        System.out.println(root.left.value + "  " + root.right.value);



//        tree.inOrder(root);

    }
}
