package com.dsa.coursera_algo_part_1.bst.red_black_trees;

/*

    Represent 2-3 tree as a BST
    Internal left-leaning links as "glue" for 3 nodes

                A   B
            /     |     \
       less      b/w     greater
       than    A and B     than
        A                   B

                   |
                   |
                   v

                   B
   color red  //       \
             A         greater
          /     \        than
        less     b/w      B
        than   A and B
         A


    1. No node has two red links connected to it
    2. Every path from root to null link has same number of black links
    3. red links lean left

    Example :
    Note: // represents red color
                            M
                        /       \
                      J           R
                   //    \      /    \
                  E       L    P      X
               /     \              //
             C         H           S
           //
          A
 */
public class RedBlackTrees<K extends Comparable<K>, V extends Comparable<V>> {

    private Node<K, V> root;

    /*
        search in red black trees is same as in bst
     */
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            get(root.left, key);
        } else if (cmp > 0) {
            get(root.right, key);
        }
        return root.value;
    }

    /*
        Rotate Left :
        Make the right leaning red link to lean left
            |                                      |
            E                                      S
        /      \\                 ---->       //       \
      less       S                           E          greater
      than    /     \                     /    \         than S
       E    b/w     greater             less    b/w
          E and S    than S            than E  E and S

    It maintains the symmetric order and maintain perfect black balance

     */
    private Node<K, V> rotateLeft(Node<K, V> node) {

        assert RBTHelper.isRed(node.right);

        Node<K, V> current = node.right;
        // set E's right child to be between E and S
        node.right = current.left;
        // set S's left to be E which was earlier it's parent
        current.left = node;
        // change color of S to be color of E
        current.color = node.color;
        // change color of E to be red
        node.color = ColorConstants.RED;
        // return S as it is the new root for this
        // subtree now
        return current;
    }

    /*
         Rotate Right :
         Make the left leaning red link to lean right
                 |                                      |
                 S                                      E
             //      \                 ---->       /        \\
           E       greater                      less          S
        /     \     than S                     than E      /     \
      less     b/w                                       b/w    greater
     than E  E and S                                  E and S    than S

     It maintains the symmetric order and maintain perfect black balance

      */
    private Node<K, V> rotateRight(Node<K, V> node) {

        assert RBTHelper.isRed(node.left);

        Node<K, V> current = node.left;
        // set S's left child to be between E and S
        node.left = current.right;
        // set E's right to be S which was earlier it's parent
        current.right = node;
        // change color of E to be color of S
        current.color = node.color;
        // change color of S to be red
        node.color = ColorConstants.RED;
        // return S as it is the new root for this
        // subtree now
        return current;
    }

    /*
        Color Flip:

                        |                                           ||
                        E                                           E
                   //        \\                                 /       \
                A                S             ----->        A             S
             /    \            /    \                    /     \         /     \
         less     b/w        b/w    greater            less   b/w      b/w     greater
         than   A and E    E and S    than             than  A and E  E ans S    than
          A                            S                A                          S
     */
    private void flipColor(Node<K, V> node) {
        assert RBTHelper.isRed(node.left);
        assert RBTHelper.isRed(node.right);
        // change E color to be RED
        node.color = ColorConstants.RED;
        // change A color to be BLACK
        node.left.color = ColorConstants.BLACK;
        // change S color to be BLACK
        node.right.color = ColorConstants.BLACK;
    }

    /*
        Insertion :
            1. Insert into tree with exactly one node
                i. insertion to left
                    b   ->      b
                             //
                            a
                ii. insertion to right
                    a   ->      a    ->       b
                                 \\         //
                                  b        a
            2. Insert into tree with exactly two nodes
                i.  larger than the two nodes
                        b           b               b
                     //     -->  //   \\  -->    /     \
                     a           a     c        a       c
                ii.  smaller than the two nodes
                       c     ->     c     ->      b
                     //           //           //   \\
                    b            b             a     c
                               //
                              a
                iii.  between the two nodes
                        c   ->      c      ->     c   ->     b    ->     b
                      //          //             //        // \\       /   \
                     a            a             b         a     c     a     c
                                    \\         //
                                     b        a

     Right child red, left child black -- > rotate left
     Left child, left left grandchild red -- > rotate right
     both children red -- > flip colors

     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node<K, V> insert(Node<K, V> current, K key, V value) {
        if (current == null) {
            return new Node<>(key, value, ColorConstants.RED);
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = insert(current.left, key, value);
        } else if (compare > 0) {
            current.right = insert(current.right, key, value);
        } else {
            current.value = value;
        }

        /*
                    a   ->      a    ->       b
                                 \\         //
                                  b        a

         */
        if (RBTHelper.isRed(current.right) && !RBTHelper.isRed(current.left)) {
            current = rotateLeft(current);
        }
        /*
                       c     ->     c     ->      b
                     //           //           //   \\
                    b            b             a     c
                               //
                              a

         */
        if (RBTHelper.isRed(current.left) && RBTHelper.isRed(current.left.left)) {
            current = rotateRight(current);
        }
        /*
                        b           b               b
                     //     -->  //   \\  -->    /     \
                     a           a     c        a       c

         */
        if (RBTHelper.isRed(current.left) && RBTHelper.isRed(current.right)) {
            flipColor(current);
        }

        return current;
    }

    public int calculateHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node<K, V> current) {
        if (current == null) {
            return 0;
        }
        int lh = calculateHeight(current.left);
        int rh = calculateHeight(current.right);
        return 1 + Math.max(lh, rh);
    }


    public void print() {
        Node<K, V> current = root;
        for (int i = 1; i <= calculateHeight(current); i++) {
            levelOrder(current, i);
            System.out.println();
        }
    }

    public void levelOrder(Node<K, V> current, int level) {
        if (current == null) {
            return;
        }
        if (level == 1) {
            System.out.print(current.value + " ");
        } else {
            levelOrder(current.left, level - 1);
            levelOrder(current.right, level - 1);
        }
    }
}
