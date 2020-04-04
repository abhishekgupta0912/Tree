package Traverse;

import Node.Node;
import implementation_BST.MyBST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traverse {
    MyBST b = new MyBST();
    Node root = b.getRoot();

    // THE THREE METHODS USE RECURSION

    public void preorder(Node node) { // root --> left subtree --> right subtree
        if (node != null) {
            System.out.print(node.getData() + " --> ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    public void postorder(Node node) { // left subtree --> right subtree --> root
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getData() + " --> ");
        }
    }

    public void inorder(Node node) {  // left subtree --> root --> right subtree
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getData() + " --> ");
            inorder(node.getRight());
        }
    }

    // METHODS TO PRINT USING LOOP

    public void preordeerloop(Node node) {
        if (node == null)
            System.out.println("Empty Tree");
        else {
            Stack<Node> s = new Stack<>();
            s.push(node);
            while (!s.empty()) {
                Node temp = s.pop();
                System.out.print(temp.getData() + " --> ");
                if (temp.getRight() != null)
                    s.push(temp.getRight());
                if (temp.getLeft() != null)
                    s.push(temp.getLeft());
            }
        }
    }

    public void inorderloop(Node node) {
        if (node == null)
            System.out.println("Empty Tree");
        else {
            Stack<Node> s = new Stack<Node>();
            Node currNode = node;
            boolean temp = false;
            while (!temp) {
                if (currNode != null) {
                    s.push(currNode);
                    currNode = currNode.getRight();
                } else {
                    if (s.empty())
                        temp = true;
                    else {
                        currNode = s.pop();
                        System.out.print(currNode.getData() + " --> ");
                        currNode = currNode.getRight();
                    }
                }
            }
        }
    }

    public void levelorder(Node node) { //
        if (node == null)
            System.out.println("Empty tree");
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while (!q.isEmpty()) {
                Node cur = q.remove();
                System.out.print(cur.getData() + " --> ");
                if (cur.getLeft() != null)
                    q.add(cur.getLeft());
                if (cur.getRight() != null)
                    q.add(cur.getRight());
            }
        }
    }


}
