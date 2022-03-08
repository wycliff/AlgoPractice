package src.main.java.trees;

public class TreeNode<T extends Comparable<T>> {
    private final T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setLeft(T left) {
        this.left = new TreeNode<>(left);
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void setRight(T right) {
        this.right = new TreeNode<>(right);
    }

    public boolean equals(Object obj) {
        final boolean b = (obj instanceof TreeNode) && this.compareTo((TreeNode) obj) == 0;
        return b;
    }

    public int compareTo(TreeNode<T> node) {
        return node.data.compareTo(this.data);
    }

    public T getData() {
        return this.data;
    }

    public static void visit(TreeNode node){
        System.out.println(node.data);
    }
}


