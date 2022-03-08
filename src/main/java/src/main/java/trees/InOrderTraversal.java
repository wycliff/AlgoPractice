package src.main.java.trees;

import static src.main.java.trees.TreeNode.visit;

public class InOrderTraversal {
    static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            visit(node);
            inOrderTraversal(node.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>(10);
        node.setLeft(6);
        node.getLeft().setLeft(4);
        node.getLeft().setRight(8);
        node.setRight(15);
        node.getRight().setLeft(13);
        node.getRight().setRight(17);

        inOrderTraversal(node);
    }
}
