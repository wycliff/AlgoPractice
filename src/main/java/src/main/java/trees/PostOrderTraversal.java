package src.main.java.trees;

import static src.main.java.trees.TreeNode.visit;

public class PostOrderTraversal {
    static void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            visit(node);
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

        postOrderTraversal(node);
    }
}
