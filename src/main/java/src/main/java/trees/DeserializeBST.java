package src.main.java.trees;

public class DeserializeBST {
    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>(10);
        node.setLeft(6);
        node.getLeft().setLeft(4);
        node.getLeft().setRight(8);
        node.setRight(15);
        node.getRight().setLeft(13);
        node.getRight().setRight(17);
    }

    private TreeNode deserializeBST(){
        return new TreeNode(0);
    }
}
