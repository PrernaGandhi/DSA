package com.dsa.coursera_algo_part_1.bst;

/*
    A BST is a binary tree in symmetric order

    A binary tree is either:
        1. Empty
        2. Two disjoint binary tress (left and right)

               4
              /   \
             1     5
               \    \
                3    9
               /    /
              2    7


 */
public class BST<K extends Comparable<K>, V extends Comparable<V>> {

    private Node<K, V> root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /*
     1 + logN(depth of tree)
     */
    private Node<K, V> put(Node<K, V> current, K key, V value) {
        Node<K, V> node = new Node<>(key, value, 1);
        if (current == null) {
            return node;
        }

        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = put(current.left, key, value);
        } else if (compare > 0) {
            current.right = put(current.right, key, value);
        } else {
            current.value = value;
        }
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }

    /*
     cost : 1 + logN
     */
    public V get(K key) {
        Node<K, V> current = root;

        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }

    public V getRecursive(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> current, K key) {
        if (current == null) {
            return null;
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            return get(current.left, key);
        } else if (compare > 0) {
            return get(current.right, key);
        } else {
            return current.value;
        }

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

    public Node<K, V> min() {
        return min(root);
    }

    private Node<K, V> min(Node<K, V> current) {
        if (current == null) {
            return null;
        }
        while (current.left != null) {
            current = current.left;
        }
        return current;

    }

    public Node<K, V> max() {
        if (root == null) {
            return null;
        }
        Node<K, V> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    /*
        largest value that is smaller than the Key

                4
              /   \
             1     5
               \    \
                3    9
               /    /
              2    7

        Now floor (2) would be 2
        Now floor (3) would be 3
        Now floor (6) would be 5

     */
    public V floor(K key) {
        Node<K, V> current = root;
        if (root == null) {
            return null;
        }

        Node<K, V> tempAns = current;
        while (current != null) {
            int compare = key.compareTo(current.key);
            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                tempAns = current;
                current = current.right;
            } else {
                tempAns = current;
                break;
            }
        }
        return tempAns.value;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<K, V> root) {
        if (root == null) {
            return 0;
        }
        return root.count;
    }

    public int rank(K key) {
        return rank(key, root);
    }

    /*
        We want to find number of keys less than Key k
        so if we have a key and we want to know number of
        keys less than key, it would be size of left sub tree
     */
    private int rank(K key, Node<K, V> current) {
        if (current == null) {
            return 0;
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            return rank(key, current.left);
        } else if (compare > 0) {
            return 1 + size(current.left) + rank(key, current.right);
        } else {
            return size(current.left);
        }
    }

    /*
        lazy approach -> mark with a color that it is deleted as long as there is
        not many deletions

     */
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K, V> delete(Node<K, V> current, K key) {
        if (current == null) {
            return null;
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            // temp node needs to be deleted
            Node<K, V> temp = current;
            // find next min in right sub tree
            // so that we can delete this node and
            // set as root, since it is min in right sub tree,
            // so it would be greater than elements of left sub tree
            // current node is updated to min element in right sub tree
            current = min(temp.right);
            // now we can delete the min element in right sub tree
            current.right = deleteMin(temp.right);
            // current element left is set set to whatever was in left sub tree
            current.left = temp.left;
        }
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<K, V> deleteMin(Node<K, V> current) {
        if (current.left == null) {
            return current.right;
        }
        current.left = deleteMin(current.left);
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }
}
