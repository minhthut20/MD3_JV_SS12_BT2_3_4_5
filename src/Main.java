public class Main {
    public static void main(String[] args) {
        BST BST = new BST();
        BST.insert(27);
        BST.insert(14);
        BST.insert(10);
        BST.insert(19);
        BST.insert(35);
        BST.insert(31);
        BST.insert(42);
        System.out.println("Inorder");
        BST.inorder();
        System.out.println();
        System.out.println("Postorder");
        BST.postOrder();
        System.out.println();
        System.out.println("Preorder");
        BST.preOrder();
        System.out.println();
        System.out.println("Breadth-first");
        BST.breadthFirst();
        BST.deleteKey(35);
        System.out.println();
        System.out.println("New");
        BST.breadthFirst();
        System.out.println();
        System.out.println(BST.search(10)?"Exist":"Does not exist");
    }
}
