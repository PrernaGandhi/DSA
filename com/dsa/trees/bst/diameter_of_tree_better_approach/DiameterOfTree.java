package com.dsa.trees.bst.diameter_of_tree_better_approach;

import com.dsa.trees.bst.Node;

/*
        Diameter of tree :

        Diameter means the number of nodes in the
        longest path between leaf nodes nodes of a tree.
        Diameter may or may not pass through the root nos
                 o
               /   \
              /     \
             /\     /\
            /__\   /__\

        left tree returns left height, and left diameter
        right tree returns right tree, and right diameter

        Height = 1 + max(leftHeight, rightHeight)
        Diameter = max(leftHeight + rightHeight, leftDiameter, rightDiameter)

                    o                                                       o
                 /     \                                                /       \
               o         o                                            o           o
             /   \          \                                      /     \
            o     o          o                                   o         o
                /   \          \                              /    \         \
               o     @          o                            o      o         o
                              /   \                               /         /   \
                             o     @                             o         o     o
                                                                  \             /
                                                                   @           @

          Diameter passing through                          Diameter not passing through
          he root node                                      the root node
          -- 9                                              -- 9

        Time complexity = O(N)
                    20
                 /     \
               15       22
             /   \
           14      16
         /            \
       13               17
    /                     \
  12                        18

        height - 5
        diameter - 6
 */
class Pair {
    int height;
    int diameter;
}

public class DiameterOfTree {
    private Pair heightDiameter(Node<Integer> root) {
        if (root == null) {
            Pair pair = new Pair();
            pair.height = 0;
            pair.diameter = 0;
            return pair;
        }
        Pair leftAns = heightDiameter(root.getLeftChild());
        Pair rightAnswer = heightDiameter(root.getRightChild());

        int lh = leftAns.height;
        int ld = leftAns.diameter;

        int rh = rightAnswer.height;
        int rd = rightAnswer.diameter;

        int height = 1 + Math.max(lh, rh);
        int diameter = Math.max(lh + rh, Math.max(ld, rd));
        Pair pair = new Pair();
        pair.height = height;
        pair.diameter = diameter;
        return pair;
    }

    public int diameter(Node<Integer> root) {
        Pair pair = heightDiameter(root);
        return pair.diameter;
    }

    public int height(Node<Integer> root) {
        Pair pair = heightDiameter(root);
        return pair.height;
    }

}
