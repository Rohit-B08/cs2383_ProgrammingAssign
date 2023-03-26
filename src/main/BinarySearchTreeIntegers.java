public class BinarySearchTreeIntegers {

    // BST uses Nodes
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = null;
            right = null;
        }
    }

    Node root;
    Node targetNode;

    // Constructors to make new Tree
    BinarySearchTreeIntegers() {
        root = null;
    }

    BinarySearchTreeIntegers(int value) {
        root = new Node(value);
    }


    // Insert a node into the tree by calling recursive method
    void insertNode(int key) {
        System.out.println("Adding " + key);
        root = insert_recursively(root, key);
    }

    // Delete a node in the tree by calling recursive method
    void deleteNode(int key) {
        System.out.println("Deleting " + key);
        targetNode = delete_recursively(root, key);
    }

    // Search for a value in the tree by calling recursive method
    void searchNode(int key) {
        System.out.println("Searching for the value " + key);
        targetNode = search_recursively(root, key);
    }

    /** Recursive function to insert a node in BST */
    Node insert_recursively(Node root, int key){
        // If at end of branch or empty tree
        if (root == null) {
            root = new Node(key);
            return root;
        }
        else if (key < root.key){
            // go left in tree
            root.left = insert_recursively(root.left, key);
        }
        else if (key > root.key){
            root.right = insert_recursively(root.right, key);
        }
        // or if it is the same value, don't add a new Node
        return root;
    }

    /** Search for a value in a BST recursively*/
    public Node search_recursively(Node root, int value){
        // Base case: empty tree, value not found, or the root has the value
        if (root == null || root.key == value) {
            if (root != null) {
                System.out.println("Found " + root.key);
            } else {
                System.out.println("Could not find value " + value);
            }
            return root;
        }

        // If the value is smaller than the root
        if (value < root.key){
            return search_recursively(root.left, value);
        }

        // Else the value is larger than the root
        return search_recursively(root.right, value);
    }

    /** Delete a value in a BST recursively
     * Must attached root/children together */
    public Node delete_recursively(Node root, int value){

        // Base case: empty tree
        if (root == null){
            return root;
        }

        // Traverse down tree to the left if value is smaller
        if (value < root.key) {
            root.left = delete_recursively(root.left, value);
        }
        // Traverse down tree to right if value is larger
        else if (value > root.key){
            root.right = delete_recursively(root.right, value);
        }
        // If value is same as root (i.e., found value).
        // How to delete depends on the number of children nodes
        else {
            // Only one child or no child? Return the child or null.
            if (root.left==null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }

            // Two children? Need to find the the inorder successor
            // which is the smallest value in the right subtree
            // i.e., next bigger value that is still smaller than parent
            root.key = minValue(root.right);

            // Set the node to the new value
            root.right = delete_recursively(root.right, root.key);
        }
        return root;
    }

    public int minValue(Node root){
        // initialize it with the child
        int minValue = root.key;
        // keep searching left until minimum value found
        while (root.left != null){
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // This method calls method to print the tree inorder
    void inorder() { inorder_recursive(root); }

    // This method will do an inorder traversal
    // and print the value at each step to check tree contents
    void inorder_recursive(Node root)
    {
        if (root != null) {
            inorder_recursive(root.left);
            System.out.println(root.key);
            inorder_recursive(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeIntegers tree = new BinarySearchTreeIntegers();

        // Example insertion, search, and deletion
        tree.insertNode(50);
        tree.insertNode(20);
        tree.insertNode(60);
        tree.insertNode(75);
        tree.insertNode(25);
        tree.insertNode(10);
        tree.insertNode(70);

        System.out.println("Current tree contains: ");
        tree.inorder();

        System.out.println("Searching for various values:");
        tree.searchNode(45);
        tree.searchNode(50);
        tree.searchNode(75);
        tree.searchNode(10);

        System.out.println("Deleting and searching for values");
        tree.deleteNode(10);
        tree.searchNode(10);
        tree.deleteNode(60);
        tree.searchNode(70);
        tree.deleteNode(50);
        tree.searchNode(70);
        tree.searchNode(50);

        System.out.println("Final tree contains:");
        tree.inorder();
    }
}
