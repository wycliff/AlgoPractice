package src.main.java.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeInversion {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    //Iterative solution
    public static void invertBinaryTree(BinaryTree tree) {
        Queue<BinaryTree> q = new LinkedList<>();

        if(tree == null){
            return;
        }

        q.add(tree);

        while(!q.isEmpty()){
            BinaryTree currentTree = q.poll();

            if(currentTree == null)
                continue;

            swapChildren(currentTree);
            q.add(currentTree.left);
            q.add(currentTree.right);
        }
    }

    //recursive solution
    public static void invertBinaryTree2(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        swapChildren(tree);
        invertBinaryTree2(tree.left);
        invertBinaryTree2(tree.right);
    }

    public static void swapChildren(BinaryTree tree){
        BinaryTree temp =  tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }
}
