package Main;

import Traverse.Traverse;
import implementation_BST.MyBST;

public class Main {
    public static void main(String[] args) {
        MyBST btree = new MyBST();
        Traverse t = new Traverse();
        btree.insert(10);
        btree.insert(6);
        btree.insert(12);
        btree.insert(7);
        btree.insert(3);
        btree.insert(4);
        btree.insert(2);
        btree.insert(11);
        btree.insert(15);
        btree.insert(13);
        btree.insert(16);

       /* System.out.println("PostOrder --> ");
        t.postorder(btree.getRoot());*/

        System.out.println("\nPreOrder -->");
        t.preorder(btree.getRoot());
        System.out.println();
        t.preordeerloop(btree.getRoot());

     /*   System.out.println("\nInOrder -->");
        t.inorder(btree.getRoot());
        System.out.println();
        t.inorderloop(btree.getRoot());

        System.out.println("\nLevelOrder --> ");
        t.levelorder(btree.getRoot());*/
    }
}
