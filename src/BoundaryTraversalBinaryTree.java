import java.util.ArrayList;
import java.util.List;
class Node{
    int data;
    Node left;
    Node right;

    Node(int val){
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
public class BoundaryTraversalBinaryTree {




    boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

    public void leftBoundary(Node root, List<Integer> res){
        Node cur = root.left;

        while(cur != null){
            if(!isLeaf(cur)){
                res.add(cur.data);
            }

            if(cur.left != null){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
    }

    public void rightBoundary(Node root, List<Integer> res){
        Node cur = root.right;
        List<Integer> temp = new ArrayList<>();

        while(cur!=null){
            if(!isLeaf(cur)){
                temp.add(cur.data);
            }

            if(cur.right!=null){
                cur = cur.right;
            } else{
                cur =  cur.left;
            }
        }
        for(int i = temp.size() - 1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }

    public void addLeafNodes(Node root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
        }
        if(root.left!=null){
            addLeafNodes(root.left, res);
        }
        if(root.right!=null){
            addLeafNodes(root.right, res);
        }
    }
    List<Integer> printBoundary(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // If the root is not a leaf,
        // add its value to the result
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // Add the left boundary, leaves,
        // and right boundary in order
        leftBoundary(root, res);
        addLeafNodes(root, res);
        rightBoundary(root, res);

        return res;
    }

    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BoundaryTraversalBinaryTree sol = new BoundaryTraversalBinaryTree();

        List<Integer> result = sol.printBoundary(root);
        System.out.print("Boundary Traversal: ");
        sol.printResult(result);
    }
}
