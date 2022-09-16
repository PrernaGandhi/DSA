package com.dsa.coursera_algo_part_1.bst.red_black_trees;

public class RBTHelper {

    private RBTHelper() {
    }

    public static boolean isRed(Node node) {
        if (node == null) {
            return ColorConstants.BLACK;
        }
        return node.color == ColorConstants.RED;
    }
}
