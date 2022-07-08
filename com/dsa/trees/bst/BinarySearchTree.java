package com.dsa.trees.bst;

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

    private void insert(T data, Node<T> rootNode) {
        // we have to traverse the left sub tree
        // if data value is smaller than the rootNode value
        if (data.compareTo(rootNode.getData()) < 0) {

            // if we have a left child, we traverse the left sub tree
            if (rootNode.getLeftChild() != null) {
                insert(data, rootNode.getLeftChild());
            } else {
                // the left child is null, so we create a new
                // left node here with the data value
                rootNode.setLeftChild(new Node<>(data, rootNode));
            }
        } else {
            // we go to the right sub tree
            if (rootNode.getRightChild() != null) {
                insert(data, rootNode.getRightChild());
            } else {
                // the right child is null, so we create a new node here with the data value
                rootNode.setRightChild(new Node<>(data, rootNode));
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
        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            // case 1: when the node to be removed have no children (leaf node)
            if (node.getRightChild() == null && node.getLeftChild() == null) {
                System.out.println("Removing a node with no child ..... ");

                Node<T> parentNode = node.getParentNode();
                // if the node to be removed is left child of parent node
                // remove left child of parent node
                if (parentNode != null && parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(null);
                }
                // if the node to be removed is the right child of the parent node
                // remove the right child of the parent node
                else if (parentNode != null && parentNode.getRightChild() == node) {
                    parentNode.setRightChild(null);
                }

                // the parent node can only be null,
                // if it is the root element
                // this means we are removing the rootNode
                // so root node = null
                if (parentNode == null) {
                    rootNode = null;
                }
                // make the node eligible for garbage collection
                node = null;
            }
            // case 2 (a) : when we have a single right child
            //              2                       10            5          5
            //               \                     /             /            \
            //                5                   5             2              7
            //                 \                    \
            //                  10                   7

            else if (node.getLeftChild() == null && node.getRightChild() != null) {
                System.out.println("Removing a node with single right child ..... ");

                Node<T> parent = node.getParentNode();
                // if node to be removed is left child of parent
                // then set left child to be the node's right child
                // (as the right child of node to be removed is not null)
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                }
                // if the node to be removed is the right child of the parent
                // then set right child to be node's right child as
                // node has one right child
                else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }

                // when we have root node and a right child
                if (parent == null) {
                    rootNode = node.getRightChild();
                }
                // now we need to update the child that it's parent has changed
                node.getRightChild().setParentNode(parent);
                // make it available for garbage collection
                node = null;
            }
            // case 2 (b): when we have a single left child
            //              10               10            5          5
            //            /                 /             /            \
            //           5                 5             2              7
            //            \               /
            //             7             2
            else if (node.getRightChild() == null && node.getLeftChild() != null) {
                System.out.println("Removing a node with single left child ..... ");

                Node<T> parent = node.getParentNode();
                // if the node to be removed is the left child of the parent
                // we set the left child of the parent to be node's left child
                // as node to be removed has 1 left child
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                }
                // if the node to be removed is the right child of the parent
                // then we set the parent's right child to be node's left child
                // as the node to be removed has 1 left child
                else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }

                // when we have root node and a right child
                if (parent == null) {
                    rootNode = node.getLeftChild();
                }

                // update the node's child that it's parent has changed
                node.getLeftChild().setParentNode(parent);
                // make node eligible for garbage collection
                node = null;
            }
            // case 3 : remove node with two children
            //              5
            //            /  \
            //          3      9
            //         / \    / \
            //        2   4  6  10
            //                \
            //                 7
            //                  \
            //                   8
            //
            // now let's try to remove 9
            //
            //              5
            //            /  \
            //          3      8
            //         / \    / \
            //        2   4  6  10
            //                \   \
            //                 7  12
            //                  \
            //                   9
            // now remove leaf node 9

            else {
                System.out.println("Removing a node with 2 children ..... ");
                // get predecessor, it would be a leaf node,
                // the largest item in the left sub tree
                Node<T> predecessor = getPredecessor(node.getLeftChild());

                // swap the node to be removed with the predecessor
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);
                // we send data with predecessor
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

    // inorder traversal
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

    // minimum of the BST would be the left most node
    // of the tree
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

    // maximum of the BST would be the right
    // most node of the tree
    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public Integer getSum(Node<T> node) {
        // base case
        // check if node is null
        // then return 0
        if (node == null)
            return 0;
        // get sum of left sub tree
        int leftSum = getSum(node.getLeftChild());
        // get sum of right sub tree
        int rightSum = getSum(node.getRightChild());
        // total sum = sum of current node + sum of left sub tree + sum of right sub tree
        System.out.println("Sum so far for Node " + node + " : " + (leftSum + rightSum + (Integer) node.getData()));
        return leftSum + rightSum + (Integer) node.getData();
    }

    // to find kth smallest item
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
