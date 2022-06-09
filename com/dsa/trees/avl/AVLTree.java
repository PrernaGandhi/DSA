package com.dsa.trees.avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    //           (D)                                    (B)
    //          /   \       Right rotation             /   \
    //        (B)   (E)    ---------------->         (A)    (D)
    //       /   \         <----------------               /   \
    //     (A)    (C)       Left rotation                (C)   (E)


    private Node<T> rootNode;

    @Override
    public void insert(T data) {
        // base case
        // if this is the first element of AVL tree
        if (rootNode == null) {
            // parent of root node is null
            rootNode = new Node<>(data, null);
        }

        insert(data, rootNode);
    }

    private void insert(T data, Node<T> node) {
        // go to left sub tree
        if (node.getData().compareTo(data) > 0) {
            // if left child is not null, traverse left child
            if (node.getLeftChild() != null)
                insert(data, node.getLeftChild());
                // when left child is null then we create left child
            else
                node.setLeftChild(new Node<>(data, node));
        } // go to right sub tree
        else {
            // if right child exists, traverse the right child
            if (node.getRightChild() != null)
                insert(data, node.getRightChild());
                // if right child is null, create the right child
            else
                node.setRightChild(new Node<>(data, node));
        }
        updateHeight(node);
        // settle the violation
        // check whether AVL properties are violated or not

    }

    // can be achieved in O(1) running time
    private void rightRotation(Node<T> node) {
        Node<T> temp = node.getLeftChild();
        Node<T> grandChild = temp.getRightChild();

        // make rotation
        temp.setRightChild(node);
        node.setLeftChild(grandChild);

        // we have to notify the parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // we need to handle parents of the node
        Node<T> parent = node.getParentNode();
        node.setParentNode(temp);
        temp.setParentNode(parent);
    }

    // can be achieved in O(1) running time
    private void leftRotation(Node<T> node) {
        Node<T> temp = node.getRightChild();
        Node<T> grandChild = temp.getLeftChild();

        // make rotation
        temp.setLeftChild(node);
        node.setRightChild(grandChild);
        // we have to notify the parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // we need to handle parents of the node
        Node<T> parent = node.getParentNode();
        node.setParentNode(temp);
        temp.setParentNode(parent);
    }

    @Override
    public void remove(T data) {

        if (rootNode != null)
            remove(data, rootNode);
    }

    private void remove(T data, Node<T> node) {
        if (node == null)
            return;
        if (node.getData().compareTo(data) > 0) {
            remove(data, node.getLeftChild());
        } else if (node.getData().compareTo(data) < 0) {
            remove(data, node.getRightChild());
        } else {
            // case 1: when the node to be removed have no children
            if (node.getRightChild() == null && node.getLeftChild() == null) {
                System.out.println("Removing a node with no child ..... ");

                Node<T> parentNode = node.getParentNode();
                if (parentNode != null && parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(null);
                } else if (parentNode != null && parentNode.getRightChild() == node) {
                    parentNode.setRightChild(null);
                }
                if (parentNode == null) {
                    rootNode = null;
                }
                // make the node eligible for garbage collection
                node = null;
                updateHeight(parentNode);
            }
            // case 2 (a) : when we have a single right child
            else if (node.getLeftChild() == null && node.getRightChild() != null) {
                System.out.println("Removing a node with single right child ..... ");

                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }

                // when we have root node and a right child
                if (parent == null) {
                    rootNode = node.getRightChild();
                }
                // update parent node for the left child of the node
                // to be removed
                node.getRightChild().setParentNode(parent);
                node = null;
                updateHeight(parent);
            }
            // case 2 (b): when we have a single left child
            else if (node.getRightChild() == null && node.getLeftChild() != null) {
                System.out.println("Removing a node with single left child ..... ");

                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }

                // when we have root node and a right child
                if (parent == null) {
                    rootNode = node.getLeftChild();
                }

                // update parent node for the left child of the node
                // to be removed
                node.getLeftChild().setParentNode(parent);
                node = null;
                updateHeight(parent);

            }
            // remove two children
            else {
                System.out.println("Removing a node with 2 children ..... ");
                // get predecessor, it would be a leaf node,
                // the largest item in the left sub tree
                Node<T> predecessor = getPredecessor(node.getLeftChild());

                // swap the node to be removed with the predecessor
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                remove(data, predecessor);

            }
        }

        // settle the violations
        // check if avl tree properties are violated or not

    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void traverse() {

        // check if BST is empty
        if (rootNode == null) {
            return;
        }

        traverse(rootNode);
        System.out.println();
    }

    private void traverse(Node<T> node) {
        if (node.getLeftChild() != null) {
            traverse(node.getLeftChild());
        }
        System.out.print(node + " ");
        if (node.getRightChild() != null) {
            traverse(node.getRightChild());
        }
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    private int height(Node<T> node) {
        if (node == null)
            return -1;
        return node.getHeight();
    }

    // balance factor to decide the left heavy or right heavy cases
    private int getBalanceFactor(Node<T> node) {
        if (node == null)
            return 0;
        return height(node.getLeftChild()) - height(node.getRightChild());
    }
}
