import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Queue;
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

    public void inOrderTraversalRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversalRecursion(node.left);
        System.out.print(node.data + "-");
        inOrderTraversalRecursion(node.right);
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
        Stack<TreeNode> stack = new Stack<>();
        if (node == null) {
            return;
        }

        stack.push(node);
        while (!stack.empty()) {
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
        while(!stack.isEmpty()){
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

    public void levelOrderTraversal(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(curr.data + "-");
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
    }

    public int numberOfNodes(TreeNode node){
        // can we use level Traversal for this? YES
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            if(current == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(current.data + "-");
                count++;
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add((current.right));
                }
            }
        }
        return count;
    }

    public int sumOfNodes(TreeNode node){
        int sum = 0;
        if(node == null){
            return 0;
        }
        // I'll be using In-order Traversal (DFS) to iterate through the entire binary tree's nodes and calculate the sum, finally, will be returning it
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = node;

        while(current != null || stack.size() != 0) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            sum += current.data;
            current = current.right;
        }
        return sum;
    }

    public int heightOfTreeUsingRecursion(TreeNode node){
        int height = 0;

        if(node == null){
            return 0;
        }

        height = 1 + Math.max(heightOfTreeUsingRecursion(node.left), heightOfTreeUsingRecursion(node.right));

        return height;
    }

    public int heightOfTree(TreeNode node){ // using level-order traversal
        int height = 0;
        // use the level-order traversal to solve this question (BFS)
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            if(current == null){
                //System.out.println();
                height += 1;
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                //System.out.print(current.data + "-");
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
        return height;
    }

    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public TreeInfo diameterOfTheTree(TreeNode node){
        // we have three cases to consider
        /*
                  1
                 / \
                2   3
               / \ / \
              4  5 6  7
             /      \
            /        \
           8          9

        Case 1: we calculate the left-subtree from thr root
        Case 2: we calculate the right-subtree from thr root
        Case 3: we calculate the left-most skewed tree + right-most skewed tree + 1
        FIND MAX -> O(N^2)



        */

        if(node == null){
            return new TreeInfo(0,0);
        }
        // this approach gives us O(N)
        TreeInfo left = diameterOfTheTree(node.left);
        TreeInfo right = diameterOfTheTree(node.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diameter1 = left.diameter;
        int diameter2 = right.diameter;
        int diameter3 = left.height + right.height + 1;

        int result = Math.max(diameter1, Math.max(diameter2, diameter3));

        TreeInfo result_info = new TreeInfo(myHeight, result);
        return result_info;
    }

    public int balanceBinarytree(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftBalancedTree = balanceBinarytree(root.left);
        if(leftBalancedTree == -1){
            return -1;
        }

        int rightBalancedTree = balanceBinarytree(root.right);
        if(rightBalancedTree == -1){
            return -1;
        }

        if(Math.abs(leftBalancedTree - rightBalancedTree) > 1){
            return -1;
        }
        return (Math.max(leftBalancedTree, rightBalancedTree) + 1);
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
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Level-Order traversal using Iteration");
        tree.levelOrderTraversal(tree.root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Level-Order traversal using Iteration");
        int count = tree.numberOfNodes(tree.root);
        System.out.println(count);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("sumOfNodes using Iteration");
        int sum = tree.sumOfNodes(tree.root);
        System.out.println(sum);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("heightOfTree using Iteration");
        int height = tree.heightOfTree(tree.root);
        System.out.println(height);
        System.out.println();
        System.out.println("heightOfTree using Recursion");
        int heightUsingRecursion = tree.heightOfTree(tree.root);
        System.out.println(heightUsingRecursion);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("diameterOfTheTree using Iteration");
        int answer = tree.diameterOfTheTree(tree.root).diameter;
        System.out.println(answer);
        System.out.println("-------------------------------");
        System.out.println("Balanced Binary tree or not?    ");
        int balance = tree.balanceBinarytree(tree.root);
        System.out.println(balance);
        System.out.println();

    }
}
