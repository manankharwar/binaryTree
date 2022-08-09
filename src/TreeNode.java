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

    public void inOrderTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        if(node == null){
            return;
        }
        TreeNode current = root;
        while(current != null || stack.size() != 0){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }


    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        //List<Integer> result = tree.inOrderTraversalRecursion(tree.root);
        //System.out.println(result);
        tree.inOrderTraversal(tree.root);
    }
}
