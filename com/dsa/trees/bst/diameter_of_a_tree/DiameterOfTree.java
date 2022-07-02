package com.dsa.trees.bst.diameter_of_a_tree;

import com.dsa.trees.bst.Node;

/*
    Diameter is the max distance between two nodes
    = Left height + right height --> this is a guess,
    this will not work in all situations, like in the
    below case,

                o
              /   \
             o     o
            / \
           o   o
          /     \
         o       o
        /         \
       o           o
     A               B
       According to the formula,
        diameter = left height + right height
                 = 4 + 1
                 = 5

        But distance between A and B = 6
        so actual diameter = 6


    Cases :
        1.  One node lies in the left sub tree,
            one node lies in the right sub tree,
            in this case diameter = leftHeight + rightHeight
            Time complexity : O(NlogN)

         2. Both nodes lie in the left sub tree,
            in this case diameter = left tree diameter
            Time complexity : O(N*N)


         3. Both nodes lie in the right sub tree
            in this case diameter = right tree diameter
            Time complexity : O(N*N)

        Time complexity : (N*h)
        where N is no of nodes and h is height of the tree
 */
public class DiameterOfTree {
    public int calculateDiameter(Node<Integer> rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int height = height(rootNode.getLeftChild()) + height(rootNode.getRightChild());
        int leftDiameter = calculateDiameter(rootNode.getLeftChild());
        int rightDiameter = calculateDiameter(rootNode.getRightChild());
        return Math.max(height, Math.max(leftDiameter, rightDiameter));
    }

    private int height(Node<Integer> rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = height(rootNode.getLeftChild());
        int right = height(rootNode.getRightChild());
        return Math.max(left, right) + 1;
    }
}
