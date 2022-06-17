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
        else if (node.getData().compareTo(data) < 0) {
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
        settleViolations(node);
    }

    // can be achieved in O(1) running time
    private void rightRotation(Node<T> node) {
        System.out.println("Right rotation on the node " + node);
        Node<T> tempLeftChild = node.getLeftChild();
        Node<T> grandChild = tempLeftChild.getRightChild();

        // make rotation
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        // we have to notify the parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // we need to handle parents of the node
        Node<T> parent = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(parent);

        // we have to handle the parents
        if (tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }
        if (tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }

        // if there is no parent after it has become the root node
        if (node == rootNode) {
            rootNode = tempLeftChild;
        }

        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    // can be achieved in O(1) running time
    private void leftRotation(Node<T> node) {
        System.out.println("Left rotation on the node " + node);

        Node<T> tempRightChild = node.getRightChild();
        Node<T> grandChild = tempRightChild.getLeftChild();

        // make rotation
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);
        // we have to notify the parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // we need to handle parents of the node
        Node<T> parent = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(parent);

        // we have to handle the parents
        if (tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }
        if (tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }

        // if there is no parent after it has become the root node
        if (node == rootNode) {
            rootNode = tempRightChild;
        }

        updateHeight(node);
        updateHeight(tempRightChild);

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

                Node<T> parent = node.getParentNode();
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(null);
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(null);
                }
                if (parent == null) {
                    rootNode = null;
                }
                // make the node eligible for garbage collection
                node = null;
                // updating height of parent as node is removed
                updateHeight(parent);
                settleViolations(parent);
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
                settleViolations(parent);
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
                settleViolations(parent);
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

                // since this calls the leaf node removal,
                // so we don't have to update the height here
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
        //               5 (2)
        //             /   \
        //            /     \
        //           /       \
        //         2 (1)      7 (0)
        //       /  \         /  \
        //      null 4(0)  null  null
        //      (-1) /\    (-1)  (-1)
        //        null null
        //        (-1)  (-1)
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    private int height(Node<T> node) {
        // if the node is null,
        // we assign -1 value,
        if (node == null)
            return -1;
        return node.getHeight();
    }

    // balance factor to decide the left heavy or right heavy cases
    // if balance factor is positive, then the tree is left heavy
    // if balance factor is negative, then the tree is right heavy
    private int getBalanceFactor(Node<T> node) {
        if (node == null)
            return 0;
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    // we need to settle violations for the node inserted or deleted
    private void settleViolations(Node<T> node) {
        // we have to check up-to the root node
        // it has O(log N) time running complexity
        while (node != null) {
            updateHeight(node);
            settleViolationsHelper(node);
            node = node.getParentNode();
        }
    }

    private void settleViolationsHelper(Node<T> node) {
        int balanceFactor = getBalanceFactor(node);

        // left heavy situation if balance factor is greater than 1
        // but it maybe a left-right heavy situation or a left-left heavy situation
        if (balanceFactor > 1) {
            // left right heavy situation
            if (getBalanceFactor(node.getLeftChild()) < 0) {
                leftRotation(node.getLeftChild());
            }
            // for left right heavy situation,
            // first we do a left rotation,
            // then a right rotation
            // if we have left left heavy situation,
            // then we just need to do a single right rotation
            rightRotation(node);
        }
        // right heavy situation if balance factor is lesser than 1
        // but it maybe a right-right heavy situation or a right-left heavy situation
        if (balanceFactor < -1) {
            // right left heavy situation
            if (getBalanceFactor(node.getRightChild()) > 0) {
                rightRotation(node.getRightChild());
            }
            // for right left heavy situation,
            // first we do a right rotation,
            // then a left rotation
            // if we have right right heavy situation,
            // then we just need to do a single left rotation
            leftRotation(node);
        }
    }
}
