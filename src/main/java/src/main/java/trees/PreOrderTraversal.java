package src.main.java.trees;

import static src.main.java.trees.TreeNode.visit;

public class PreOrderTraversal {
    static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
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

        preOrderTraversal(node);
    }

}
