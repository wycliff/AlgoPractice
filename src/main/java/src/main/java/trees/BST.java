package src.main.java.trees;

public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public static BST insert(int value, BST binaryTree) {
        return insertHelper(binaryTree, value);
    }

    public static BST insertHelper(BST tree, int value) {
        if (tree == null) {
            return new BST(value);
        }

        if (value < tree.value) {
            tree.left = insertHelper(tree.left, value);
        } else {
            tree.right = insertHelper(tree.right, value);
        }

        return tree;
    }


    public static boolean contains(int value, BST binaryTree) {
        return binarySearch(binaryTree, value);
    }

    public static boolean binarySearch(BST binaryTree, int value) {
        if (binaryTree == null) {
            return false;
        }

        if (binaryTree.value == value) {
            return true;
        } else if (value > binaryTree.value) {
            return binarySearch(binaryTree.right, value);
        } else {
            return binarySearch(binaryTree.left, value);
        }
    }

    public static BST remove(int value, BST binaryTree) {
        //is the value a leaf
        return removeHelper(value, binaryTree);
    }

    public static BST removeHelper(int value, BST binaryTree) {
        if (binaryTree == null) {
            return binaryTree;
        }

        if (value > binaryTree.value) {
            return removeHelper(value, binaryTree.right);
        } else if (value < binaryTree.value) {
            return removeHelper(value, binaryTree.left);
        } else {

            //Case1 : if it is a leaf
            if (isLeaf(binaryTree)) {
                return null;
            }

            //Case2: non-null children
            if(binaryTree.right!=null){
                binaryTree.value = getSmallestValue(binaryTree.right);
                binaryTree = removeHelper(binaryTree.value , binaryTree.right);
                return binaryTree;
            }else if(binaryTree.left != null){
                binaryTree.value = binaryTree.left.value;
                binaryTree.left = binaryTree.left.left;
                return binaryTree;
            }
        }

        return binaryTree;
    }

    public static int getSmallestValue(BST tree){
        if(tree.left==null)
            return tree.value;
        else return getSmallestValue(tree.left);
    }

    public static boolean isLeaf(BST treeNode) {
        return treeNode.right == null && treeNode.left == null;
    }

    public static boolean checker(BST binaryTree, int value) {
        if (binaryTree == null) {
            return false;
        }

        if (binaryTree.value == value) {
            System.out.println(binaryTree.value);
            return true;
        } else if (value > binaryTree.value) {
            System.out.println(binaryTree.value);
            return checker(binaryTree.right, value);
        } else {
            System.out.println(binaryTree.value);
            return checker(binaryTree.left, value);
        }
    }

    public static void main(String args[]){
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);



       root =  insert(12, root);
       // System.out.println(contains(12,insert(12, root) ));

        //remove(15,root);
        System.out.println(contains(12,root));
        checker(root,12);
    }
}
