package com.dsa.trees.bst.kth_smallest_element_in_bst;

import com.dsa.trees.bst.Node;

/*
    To find kth smallest element in BST
        Approach 1 :
            inorder -> then store in array
            then find value of arr[k - 1]
            Time complexity : O(N)
            Space complexity : O(N)

        Approach 2 :
            inorder, and have variable count,
            as soon as the count == k,
            we get the k th smallest element
            Time complexity : O(k)
            in worst case, time complexity
            would be O(N) if k = N
            Space complexity : O(1)

 */
public class KthSmallestElementInBST {
    int ans = -1;
    int K;

    private void find(Node<Integer> rootNode) {
        if (rootNode == null || K == 0) {
            return;
        }
        find(rootNode.getLeftChild());
        K--;
        if (K == 0) {
            ans = rootNode.getData();
            System.out.println(rootNode.getData());
            return;
        }
        find(rootNode.getRightChild());
    }

    public int findKthSmallest(Node<Integer> rootNode, int k) {
        K = k;
        find(rootNode);
        return ans;
    }
}
