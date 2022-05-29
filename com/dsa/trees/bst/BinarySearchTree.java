package com.dsa.trees.bst;

import com.dsa.trees.Node;
import com.dsa.trees.Tree;

// we need to extend Comparable interface because we need to compare values
// in each step while inserting, traversing, etc.
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    //           (12)
    //          /    \
    //        (4)    (20)
    //        / \    /  \
    //      (1) (8)(16) (27)

    private Node<T> rootNode;

    @Override
    public void insert(T data) {
        // this is the first time we insert the root node
        // in BST, parent root is null
        if (rootNode == null) {
            rootNode = new Node<>(data, null);
        } else {
            // there are already items in binary search tree
            insert(data, rootNode);
        }
    }

    private void insert(T data, Node<T> node) {
        // we have to traverse the left sub tree
        // if data value is smaller than the node value
        if (node.getData().compareTo(data) > 0) {

            // if we have a left child we go there
            if (node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                // the left child is null, so we create a new node here
                node.setLeftChild(new Node<>(data, node));
            }
        } else {
            // we go to the right sub tree
            if (node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                // the left child is null, so we create a new node here
                node.setRightChild(new Node<>(data, node));
            }
        }
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
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void traversal() {

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

    @Override
    public T getMin() {
        // check if BST is empty
        if (rootNode == null) {
            return null;
        }
        return getMin(rootNode);
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    @Override
    public T getMax() {
        // if BST is empty
        if (rootNode == null) {
            return null;
        }
        return getMax(rootNode);
    }

    private T getMax(Node<T> node) {

        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();
    }

    @Override
    public Node<T> getSmallest(Node<T> node, int k) {

        // +1 because we count the root node of the sub structure
        int numberOfNodesInLeftSubTree = treeSize(node.getLeftChild()) + 1;

        if (numberOfNodesInLeftSubTree == k) {
            return node;
        }
        if (numberOfNodesInLeftSubTree > k)
            return getSmallest(node.getLeftChild(), k);
        if (numberOfNodesInLeftSubTree < k)
            return getSmallest(node.getRightChild(), k - numberOfNodesInLeftSubTree);
        return null;
    }

    private int treeSize(Node<T> node) {
        if (node == null) {
            return 0;
        }
        // size of left sub tree + size of right sub tree + 1
        return treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1;
    }

    public Node<T> getRootNode() {
        return rootNode;
    }
}
