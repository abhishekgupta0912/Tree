package implementation_BST;

import Node.Node;

public class MyBST {
    Node root;

    public MyBST() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node parent = null;
            Node temp = root;
            while (temp != null) {
                parent = temp;
                if (temp.getData() >= newNode.getData())
                    temp = temp.getLeft();
                else
                    temp = temp.getRight();

            }
            if (newNode.getData() <= parent.getData())
                parent.setLeft(newNode);
            else
                parent.setRight(newNode);
        }
    }

    public Node delete(int data) {
        Node temp = root;
        Node parent = null;
        Node response = null;

        //search for the node to be deleted
        while (temp != null && temp.getData() != data) {
            parent = temp;
            if (temp.getData() >= data)
                temp = temp.getLeft();
            else
                temp = temp.getRight();
        }


        if (temp != null) {
            response = temp;

            if (temp.getLeft() == null && temp.getRight() == null) { //if it is a leaf node or node with no child
                if (parent != null) {
                    if (parent.getData() > data)
                        parent.setLeft(null);
                    else
                        parent.setRight(null);
                } else root = null;
            } else if (temp.getLeft() != null && temp.getRight() == null) {  // if node has 1 child on left
                if (parent != null) {
                    if (parent.getData() > data)
                        parent.setLeft(temp.getLeft());
                    else
                        parent.setRight(temp.getLeft());
                } else root = root.getLeft();
            } else if (temp.getRight() != null && temp.getLeft() == null) { // if the node has 1 child on right
                if (parent != null) {
                    if (parent.getData() < data)
                        parent.setRight(temp.getRight());
                    else
                        parent.setLeft(temp.getRight());
                } else root = root.getRight();
            } else { // node has both the child. We can  either use inorder successor or inorder predecessor
                // this is by successor

                Node successor = getSuccessor(temp);
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                if (parent != null) {
                    if (parent.getData() > data)
                        parent.setLeft(successor);
                    else
                        parent.setRight(successor);
                } else {
                    successor.setLeft(root.getLeft());
                    root = successor;
                }
            }
        }
        return response;
    }

    public Node getRoot() {
        return this.root;
    }

    public Node getSuccessor(Node node) {
        Node successor = null;
        node = node.getRight();
        while (node != null) {
            successor = node;
            node = node.getLeft();
        }
        successor = delete(successor.getData());
        return successor;
    }

    // this is when u want to use in order predecessor
/*    public Node getPredecessor(Node node ){
        Node predecessor=null;
        node=node.getLeft();
        while (node!=null){
            predecessor=node;
            node=node.getRight();
        }
        delete(predecessor.getData());
        return predecessor;
    }*/
}
