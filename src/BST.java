
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    public void insert(int key) {
        root = insert_Recursive(root, key);
    }

    public Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    public void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST
    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    public void postOrder() {
        postOrder_Recursive(root);
    }

    void postOrder_Recursive(Node root) {
        if (root != null) {
            postOrder_Recursive(root.left);
            postOrder_Recursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    public void preOrder() {
        preOrder_Recursive(root);
    }

    void preOrder_Recursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder_Recursive(root.left);
            preOrder_Recursive(root.right);
        }
    }

    public void breadthFirst() {
        breadthFirst_Recursive(root);
    }

    void breadthFirst_Recursive(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            /*add left child to the queue */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    Node delete_Recursive(Node root, int key)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (key < root.key)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root)  {
        //initially minval = root
        int minval = root.key;
        //find minval
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    public boolean search(int key)  {
        root = search_Recursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }

    //recursive insert function
    Node search_Recursive(Node root, int key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
}
