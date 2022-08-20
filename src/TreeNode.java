import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree{
    TreeNode root;
    List<Integer> list = new LinkedList<>();

    public void inOrderTraversalRecursion(TreeNode node) {
        TreeNode current = node;
        if (current == null) {
            return;
        }
        inOrderTraversalRecursion(current.left);
        System.out.print(current.data + "-");
        inOrderTraversalRecursion(current.right);
    }

    public void inOrderTraversalIteratively(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        if(node == null) {
            return;
        }
        TreeNode current = node;
        while(current != null || stack.size() != 0) {
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + "-");
            current = current.right;
        }
    }

//    public List<Integer> inOrderTraversalRecursion(TreeNode node){
//        traversalRecursion(node);
//        return list;
//    }
//
//    public void traversalRecursion(TreeNode node){
//        if(node == null){
//            return;
//        }
//        traversalRecursion(node.left);
//        list.add(node.data);
//        traversalRecursion(node.right);
//    }

//    public void inOrderTraversal(TreeNode node){
//        Stack<TreeNode> stack = new Stack<>();
//        if(node == null){
//            return;
//        }
//        TreeNode current = root;
//        while(current != null || stack.size() != 0){
//            while(current != null){
//                stack.push(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            System.out.print(current.data + " ");
//            current = current.right;
//        }
//    }

    public void preOrderTraversalUsingRecursion(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data + "-");
        preOrderTraversalUsingRecursion(node.left);
        preOrderTraversalUsingRecursion(node.right);
    }
//
    public void preOrderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (node == null) {
            return;
        }

        stack.push(node);
        while (stack.empty() == false) {
            TreeNode current = stack.pop();
            System.out.print(current.data + "-");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void postorderTraversalUsingRecursion(TreeNode node){
        if(node == null){
            return;
        }
        //TreeNode current = node;

        postorderTraversalUsingRecursion(node.left);
        postorderTraversalUsingRecursion(node.right);
        System.out.print(node.data + "-");
    }

    public void postorderTraversalUsingIteration(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> output = new Stack<>();
        if(node == null){
            return;
        }
        stack.push(node);
        while(stack.isEmpty() == false){
            TreeNode element = stack.pop();
            output.push(element.data);

            if(element.left != null){
                stack.push(element.left);
            }

            if(element.right != null){
                stack.push(element.right);
            }
        }

        // print postorder traversal
        while (!output.empty()) {
            System.out.print(output.pop() + "-");
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.right.right.left = new TreeNode(7);
        tree.root.right.right.right = new TreeNode(8);
        tree.root.left.left.left = new TreeNode(9);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.left.left = new TreeNode(11);
        tree.root.left.right.left.right = new TreeNode(12);
        tree.root.right.right.left.left = new TreeNode(13);
        tree.root.right.right.left.right = new TreeNode(14);
        System.out.println("In-Order traversal using Recursion");
        tree.inOrderTraversalRecursion(tree.root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("In-Order traversal using Iteration");
        tree.inOrderTraversalIteratively(tree.root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Pre-Order traversal using Recursion");
        tree.preOrderTraversalUsingRecursion(tree.root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Pre-Order traversal using Iteraiton");
        tree.preOrderTraversal(tree.root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Post-Order traversal using Recursion");
        tree.postorderTraversalUsingRecursion(tree.root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Post-Order traversal using Iteration");
        tree.postorderTraversalUsingIteration(tree.root);
    }
}
