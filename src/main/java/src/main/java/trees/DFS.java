package src.main.java.trees;

public class DFS {
    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>(10);
        node.setLeft(6);
        node.getLeft().setLeft(4);
        node.getLeft().setRight(8);
        node.setRight(15);
        node.getRight().setLeft(13);
        node.getRight().setRight(17);

        System.out.println(hasPathToSum(node, 20));
        System.out.println(getPathWithMaxSum(node));
    }

    private static boolean hasPathToSum(TreeNode<Integer> root, int targetSum) {
        if(root == null)
            return false;
        final boolean isLeaf = root.getRight() == null & root.getLeft() == null;
        if(isLeaf){
            return root.getData() == targetSum;
        }

        int remainingSum = targetSum - root.getData();
        return hasPathToSum(root.getLeft(), remainingSum) ||  hasPathToSum(root.getRight(), remainingSum);
    }


    private static int getPathWithMaxSum(TreeNode<Integer> root){
        int maxPathSum = 0;
        if(root == null)
            return 0;

        final boolean isLeaf = root.getRight() == null & root.getLeft() == null;
        if(isLeaf){
            //maxPathSum
            return root.getData();
        }

        maxPathSum = Math.max(getPathWithMaxSum(root.getLeft()),getPathWithMaxSum(root.getRight()));
        return maxPathSum +=  maxPathSum;
    }
}
