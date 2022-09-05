package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.quick_union;

import com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.UnionFind;

/*
    This is a lazy approach, we do work, only when we have to, i.e, only when we are asked whether
    the two points are connected or not, we do the work

    For this, we use an array to store this data. Initially, the array would look something like this

    Value   0   1   2   3   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    Now let's walk through an example
    For union operations union(p, q) we update p's root to be equal to root of q,
    which is nothing but arr[root(p)] = root(q)

    union(3, 8)

    Value   0   1   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    0   1   2   4   5   6   7   8   9
                                |
                                3

    union(1, 0)

    Value   0   0   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    0   2   4   5   6   7   8   9
    |                       |
    1                       3

    union(4, 5)

    Value   0   0   2   8   5   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    0   2   5   6   7   8   9
    |       |           |
    1       4           3

    union(4, 1)

    4 -> root of 5 -> 5
    1 -> root of 1 -> 0

    so we make 5 a child of 0

    Value   0   0   2   8   5   0   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

        0   2   6   7   8   9
      /  \              |
     1    5             3
          |
          4

    For connected queries we need to do more work, we need to find the root
    of each and compare if it is equal or not,
    connected(p, q) -> we find root of p, we find root of q, and then compare
    both values.

    connected(1, 3) => false, not connected
    root of 1 -> 0 -> 0
    root of 3 -> 8 -> 8
    0 =/= 8, hence they don't lie in the same connected component

    connected(0, 4) => true, connected
    root of 0 -> 0
    root of 4 -> 5 -> 0
    0 == 0, hence they lie in the same connected components

    Time complexity :

    Initialization      :   O(N)
    Union               :   O(N)
    Find                :   O(N)


    The time complexity is O(N^2) which is too slow

 */
public class QuickUnion implements UnionFind {
    private final int[] array;

    public QuickUnion(int n) {
        this.array = new int[n];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = i;
        }
    }

    public int root(int child) {
        int parent = array[child];
        while (parent != child) {
            child = parent;
            parent = array[child];
        }
        return child;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        array[root(p)] = root(q);
    }

    public void print() {
        for (int child = 0; child < array.length; child++) {
            int parent = array[child];
            int temp = child;
            System.out.print(temp);
            while (parent != temp) {
                System.out.print(" -> " + parent);
                temp = parent;
                parent = array[temp];
            }
            System.out.println();
        }
    }

}
