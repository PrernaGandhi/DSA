package com.dsa.trees.construct_tree_from_preorder_and_inorder;

import com.dsa.trees.bst.Node;

/*
    Pre-order   :   3, 9, 20, 15, 7
    In-order    :   9, 3, 15, 20, 7

    Output :            3
                       /  \
                      9    20
                          /  \
                         15   7

    Explanation :
        First node in pre order will be the root node
        then we identify where root node is present in
        the in-order traversal,
        the elements right to the root in the in-order are
        the elements of right sub tree,
        the elements left to the root in the in-order are
        the elements of the left sub tree


            Pre-order   :   3, 9, 20, 15, 7
                            ^             ^
                            |             |
                         preStart       preEnd
            In-order    :   9, 3, 15, 20, 7
                            ^             ^
                            |             |
                          inStart       inEnd

       Let's try to solve a smaller problem

       to build left sub tree, we need the following

            leftInorder                                 leftPreorder
        /               \                           /                 \
leftInorderStart    leftInorderEnd        leftPreorderStart      leftPreorderEnd
       |                 |                         |                    |
       v                 v                         v                    v
    inStart         rootIndex - 1             preStart + 1      rootIndex - inStart + preStart


        Since elements in left sub tree would be equal,
        so left inorder and left preorder will have
        equal number of elements

        Number of elements in leftInorder   = leftInorderEnd - leftInorderStart
                                            = rootIndex - 1 - inStart
        Number of elements in leftPreorder  = leftPreorderEnd - leftPreorderStart
                                            = leftPreorderEnd - preStart - 1

        Equating to number of elements,
            leftPreorderEnd - preStart - 1 = rootIndex - 1 - inStart
            leftPreorderEnd                = rootIndex - 1 - inStart + preStart + 1
            leftPreorderEnd                = rootIndex - inStart + preStart


            rightInorder                                 rightPreorder
        /               \                           /                 \
rightInorderStart    rightInorderEnd        rightPreorderStart      rightPreorderEnd
       |                 |                         |                    |
       v                 v                         v                    v
 rootIndex + 1         inEnd                leftPreEnd + 1           preEnd



 */
public class ConstructTree {

    private Node<Integer> buildTreeHelper(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        int rootNodeData = preorder[preStart];
        int leftInStart = inStart;
        // find index of root element in inorder array
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootNodeData) {
                rootIndex = i;
                break;
            }
        }
        int leftInEnd = rootIndex - 1;
        int leftPreStart = preStart + 1;

        // leftPreEnd - leftPreStart = leftInEnd - leftInStart
        int leftPreEnd = leftInEnd - leftInStart + leftPreStart;

        int rightInStart = rootIndex + 1;
        int rightInEnd = inEnd;
        // rightInEnd - rightInStart = rightPreEnd - rightPreStart
        // rightPreStart = rightPreEnd - rightInEnd + rightInStart
        // or leftPreEnd + 1
        // Root Left Right
        //      ^   ^
        //      |   |
        //     lPS lPE
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;

        Node<Integer> rootNode = new Node<>(rootNodeData, null);
        rootNode.setLeftChild(buildTreeHelper(inorder, preorder, leftInStart, leftInEnd, leftPreStart, leftPreEnd));
        rootNode.setRightChild(buildTreeHelper(inorder, preorder, rightInStart, rightInEnd, rightPreStart, rightPreEnd));
        return rootNode;
    }

    public Node<Integer> buildTree(int[] inorder, int[] preorder) {
        int n = inorder.length;
        return buildTreeHelper(inorder, preorder, 0, n - 1, 0, n - 1);
    }

    public void print(Node<Integer> rootNode) {
        int height = calculateHeight(rootNode);

        for (int i = 1; i <= height; i++) {
            levelOrder(rootNode, i);
            System.out.println();
        }
    }

    private void levelOrder(Node<Integer> rootNode, int i) {
        if (rootNode == null) {
            return;
        }

        if (i == 1) {
            System.out.print(rootNode + " ");
        } else {
            levelOrder(rootNode.getLeftChild(), i - 1);
            levelOrder(rootNode.getRightChild(), i - 1);
        }
    }

    private int calculateHeight(Node<Integer> rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = calculateHeight(rootNode.getLeftChild());
        int right = calculateHeight(rootNode.getRightChild());
        return Math.max(left, right) + 1;

    }
}
