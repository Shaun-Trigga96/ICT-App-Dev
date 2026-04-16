/**
 * Name: Chuma
 * Surname: Nxazonke
 * Student No: 219181187
 */
public class PartD_Trees {

        // Binary Search Tree
        static class BST {
            class Node {
                int key;
                Node left, right;

                Node(int item) {
                    key = item;
                    left = right = null;
                }
            }

            Node root;

            public BST() {
                root = null;
            }

            // Insert a new key
            public void insert(int key) {
                root = insertRec(root, key);
            }

            private Node insertRec(Node root, int key) {
                if (root == null) {
                    root = new Node(key);
                    return root;
                }

                if (key < root.key) {
                    root.left = insertRec(root.left, key);
                } else if (key > root.key) {
                    root.right = insertRec(root.right, key);
                }

                return root;
            }

            // Search for a key
            public boolean search(int key) {
                return searchRec(root, key);
            }

            private boolean searchRec(Node root, int key) {
                if (root == null) return false;
                if (root.key == key) return true;

                if (key < root.key) {
                    return searchRec(root.left, key);
                } else {
                    return searchRec(root.right, key);
                }
            }

            // Delete a key
            public void delete(int key) {
                root = deleteRec(root, key);
            }

            private Node deleteRec(Node root, int key) {
                if (root == null) return root;

                if (key < root.key) {
                    root.left = deleteRec(root.left, key);
                } else if (key > root.key) {
                    root.right = deleteRec(root.right, key);
                } else {
                    // Node with only one child or no child
                    if (root.left == null) {
                        return root.right;
                    } else if (root.right == null) {
                        return root.left;
                    }

                    // Node with two children: get inorder successor
                    root.key = minValue(root.right);

                    // Delete the inorder successor
                    root.right = deleteRec(root.right, root.key);
                }

                return root;
            }

            // find and return the node containing the smallest value in the entire tree.
            private int minValue(Node root) {
                int minValue = root.key;
                while (root.left != null) {
                    minValue = root.left.key;
                    root = root.left;
                }
                return minValue;
            }

            // Inorder traversal
            public void inorder() {
                inorderRec(root);
                System.out.println();
            }

            private void inorderRec(Node root) {
                if (root != null) {
                    inorderRec(root.left);
                    System.out.print(root.key + " ");
                    inorderRec(root.right);
                }
            }

            // Preorder traversal
            public void preorder() {
                preorderRec(root);
                System.out.println();
            }

            private void preorderRec(Node root) {
                if (root != null) {
                    System.out.print(root.key + " ");
                    preorderRec(root.left);
                    preorderRec(root.right);
                }
            }

            // Postorder traversal
            public void postorder() {
                postorderRec(root);
                System.out.println();
            }

            private void postorderRec(Node root) {
                if (root != null) {
                    postorderRec(root.left);
                    postorderRec(root.right);
                    System.out.print(root.key + " ");
                }
            }
        }

        public static void run() {
            System.out.println("=== Part D: Trees ===");

            BST tree = new BST();

            // Insert nodes
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            // Print traversals
            System.out.print("Inorder traversal: ");
            tree.inorder();

            System.out.print("Preorder traversal: ");
            tree.preorder();

            System.out.print("Postorder traversal: ");
            tree.postorder();

            // Search for nodes
            System.out.println("Search for 40: " + tree.search(40));
            System.out.println("Search for 90: " + tree.search(90));

            // Delete nodes
            System.out.println("Delete 20");
            tree.delete(20);
            System.out.print("Inorder traversal after deletion: ");
            tree.inorder();

            System.out.println("Delete 30");
            tree.delete(30);
            System.out.print("Inorder traversal after deletion: ");
            tree.inorder();

            System.out.println("Delete 50");
            tree.delete(50);
            System.out.print("Inorder traversal after deletion: ");
            tree.inorder();

            System.out.println();
        }
    }

