package com.dsa.trees.bst.tree_traversal;


import com.dsa.trees.bst.Node;
import com.dsa.trees.bst.height_of_bst.HeightOfBST;

import java.util.*;

public class Traversals<T> {
    //           (12)
    //          /    \
    //        (4)    (20)
    //        / \    /  \
    //      (1) (8)(16) (27)
    //
    //  inorder :   1 4 8 12 16 20 27
    //  preorder:   12 4 1 8 20 16 27
    //  postorder:  1 8 4 16 27 20 12
    //  level-order: 12 4 20 1 8 16 27

    public void inorder(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() != null) {
            inorder(node.getLeftChild());
        }

        System.out.print(node + " ");

        if (node.getRightChild() != null) {
            inorder(node.getRightChild());
        }
    }

    public void preorder(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node + " ");

        if (node.getLeftChild() != null) {
            preorder(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            preorder(node.getRightChild());
        }
    }

    public void postorder(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() != null) {
            postorder(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            postorder(node.getRightChild());
        }

        System.out.print(node + " ");
    }

    // matches with implementation of bfs
    // for level order height is the most important
    public void levelOrder(Node<T> node) {
        if (node == null)
            return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current + " ");
            if (current.getLeftChild() != null)
                queue.add(current.getLeftChild());
            if (current.getRightChild() != null)
                queue.add(current.getRightChild());
        }
    }

    /*
    //           (12)
    //          /    \
    //        (4)    (20)
    //        / \    /  \
    //      (1) (8)(16) (27)

           Zig zag level order traversal : 12 20 4 1 8 16 27
     */
    public void zigZaglevelOrder(Node<T> node) {
        if (node == null)
            return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);
        node.setVisited(true);
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node<T> current = queue.poll();
            // stack will store elements of same level
            // and then pop out in reverse order
            Stack<Node<T>> stack = new Stack<>();
            stack.push(current);
            while (size-- > 0) {
                // polling all elements of current level
                // and pushing into stack
                current = queue.poll();
                if (current != null) {
                    stack.push(current);
                }
            }
            while (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current + " ");
                // we store elements based on the
                // orientation for all the
                // elements in the given level
                if (isLeftToRight) {
                    if (current.getLeftChild() != null)
                        queue.add(current.getLeftChild());
                    if (current.getRightChild() != null)
                        queue.add(current.getRightChild());
                } else {
                    if (current.getRightChild() != null)
                        queue.add(current.getRightChild());

                    if (current.getLeftChild() != null) {
                        queue.add(current.getLeftChild());
                    }
                }
            }
            isLeftToRight = !isLeftToRight;
        }
    }

    /*
    //           (12)
    //          /    \
    //        (4)    (20)
    //        / \    /  \
    //      (1) (8)(16) (27)

        reverse level order - 1 8 16 27 4 20 12
     */
    public void reverseLevelOrder(Node<T> node) {
        if (node == null)
            return;
        Queue<Node<T>> queue = new LinkedList<>();
        Stack<Node<T>> stack = new Stack<>();
        queue.add(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            // store the value in stack
            stack.push(current);
            if (current.getRightChild() != null) {
                queue.add(current.getRightChild());
            }
            if (current.getLeftChild() != null) {
                queue.add(current.getLeftChild());
            }
        }

        // level order traversal stored in stack
        // so when it is popped out,
        // it is printed in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void levelOrderTraversalUsingHeight(Node<T> root) {
        if (root == null) return;

        HeightOfBST heightOfBST = new HeightOfBST();
        int height = heightOfBST.height(root);
        for (int i = 1; i <= height; i++) {
            levelOrder(root, i);
            System.out.println();
        }
    }

    /*             0
    //           (12)
    //          /    \
    //     -1 (4)    (20) +1
    //        / \    /  \
    //      (1) (8)(16) (27)
            -2   0   0   +2
            root node will have horizontal distance 0
            elements to the left will be -1
            elements to the right will be +1

        Vertical order traversal - [1] [4] [8, 12, 16] [20] [27]

        Horizontal distance              Elements
                -2                          [1]
                -1                          [4]
                 0                      [8, 12, 16]
                 1                          [20]
                 2                          [27]


        For vertical order traversal, horizontal distance is important
     */
    public void verticalOrderTraversalUsingHeight(Node<T> root) {
        if (root == null) return;

        HeightOfBST heightOfBST = new HeightOfBST();
        int height = heightOfBST.height(root);
        TreeMap<Integer, Set<Node>> treeMap = new TreeMap<>();
        for (int i = 1; i <= height; i++) {
            levelOrder(root, 0, treeMap);
        }

        for (Map.Entry<Integer, Set<Node>> m : treeMap.entrySet()) {
            System.out.print(m.getValue() + " ");
        }
    }

    private void levelOrder(Node<T> root, int hd, TreeMap<Integer, Set<Node>> treeMap) {
        if (root == null) {
            return;
        }
        Set<Node> nodes = treeMap.get(hd);

        if (nodes == null) {
            nodes = new HashSet<>();
        }
        nodes.add(root);
        treeMap.put(hd, nodes);
        levelOrder(root.getLeftChild(), hd - 1, treeMap);
        levelOrder(root.getRightChild(), hd + 1, treeMap);

    }

    public void zigZaglevelOrderTraversalUsingHeight(Node<T> root) {
        if (root == null) return;

        HeightOfBST heightOfBST = new HeightOfBST();
        int height = heightOfBST.height(root);
        boolean isLeftToRight = true;
        for (int i = 1; i <= height; i++) {
            levelOrder(root, i, isLeftToRight);
            isLeftToRight = !isLeftToRight;
        }
    }

    private void levelOrder(Node<T> root, int height, boolean isLeftToRight) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.print(root.getData() + " ");
        } else if (height > 1) {
            if (isLeftToRight) {
                levelOrder(root.getLeftChild(), height - 1);
                levelOrder(root.getRightChild(), height - 1);
            } else {
                levelOrder(root.getRightChild(), height - 1);
                levelOrder(root.getLeftChild(), height - 1);
            }
        }

    }

    public void reverseLevelOrderTraversalUsingHeight(Node<T> root) {
        if (root == null) return;

        HeightOfBST heightOfBST = new HeightOfBST();
        int height = heightOfBST.height(root);
        for (int i = height; i > 0; i--) {
            levelOrder(root, i);
        }
    }

    private void levelOrder(Node<T> root, int height) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.print(root.getData() + " ");
        } else if (height > 1) {
            levelOrder(root.getLeftChild(), height - 1);
            levelOrder(root.getRightChild(), height - 1);
        }
    }
}
