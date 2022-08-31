package src.main.java.trees;

import java.util.*;

public class LevelOrderTraversal {
    static List<Integer> levelOrderTraversal(TreeNode node) {
        List<Integer> output = new ArrayList();

        if (node == null) {
            return output;
        }

        //Initialize queue
        //todo Queue of nodes : Incomplete
        Queue<TreeNode> bfsQueue = new LinkedList<>();

        //Mark visited and enqueue
        bfsQueue.add(node);

        while (!bfsQueue.isEmpty()) {
            TreeNode currNode = bfsQueue.poll();
            output.add((Integer) currNode.getData());

            if (currNode.getLeft() != null)
                bfsQueue.add(currNode.getLeft());

            if (currNode.getLeft() != null)
                bfsQueue.add(currNode.getRight());
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>(10);
        node.setLeft(6);
        node.getLeft().setLeft(4);
        node.getLeft().setRight(8);
        node.setRight(15);
        node.getRight().setLeft(13);
        node.getRight().setRight(17);

        List<Integer> output = levelOrderTraversal(node);
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}
