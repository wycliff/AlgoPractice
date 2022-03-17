package src.main.java.trees;

import java.util.*;

public class LevelOrderTraversal {
    static List<Integer> levelOrderTraversal(TreeNode node, int nodeCount) {
        List<Integer> output = new ArrayList();

        if (node == null) {
            return output;
        }

        //Initialize queue
        //todo Queue of nodes : Incomplete
        Queue<Integer> bfsQueue = new LinkedList<>();

        //Mark visited and enqueue
        bfsQueue.add((int) node.getData());

        TreeNode currentNode = node;
        while (!bfsQueue.isEmpty()) {
            Integer currNode = bfsQueue.poll();
            output.add(currNode);

            if (currentNode.getLeft().getData() != null)
                bfsQueue.add((int) currentNode.getLeft().getData());

            if (currentNode.getLeft().getData() != null)
                bfsQueue.add((int) currentNode.getRight().getData());

            for (int i = 0; i < 2; i++) {
                Integer leftNode = bfsQueue.poll();
                output.add(leftNode);

                currentNode = node.getLeft();

                if (currentNode.getLeft().getData() != null)
                    bfsQueue.add((int) currentNode.getLeft().getData());

                if (currentNode.getRight().getData() != null)
                    bfsQueue.add((int) currentNode.getRight().getData());
            }
            
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

        levelOrderTraversal(node, 7);
    }
}
