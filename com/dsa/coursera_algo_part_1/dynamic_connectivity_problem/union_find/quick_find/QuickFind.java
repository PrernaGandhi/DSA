package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.quick_find;

import com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.UnionFind;

/*
    This is an eager approach, the idea here is that we are able to quickly find is two points are connected
    or not, but the union operation takes a bit longer.

    For this, we use an array to store this data. Initially, the array would look something like this


    Value   0   1   2   3   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    Now let's walk through an example
    union(3, 8)

    Value   0   1   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    union(1, 0)

    Value   0   0   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    union(4, 5)

    Value   0   0   2   8   5   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    union(5, 1)

    Value   0   0   2   8   0   0   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9


    connected(1, 3) => false, not connected

    connected(0, 4) => true, connected


    Time complexity :

    Initialization      :   O(N)
    Union               :   O(N)
    Find                :   O(1)


    For n union operations, the time complexity is O(N^2) which is very slow
 */
public class QuickFind implements UnionFind {
    private final int[] array;

    public QuickFind(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return array[p] == array[q];
    }

    @Override
    public void union(int p, int q) {
        int newValue = array[q];
        int oldValue = array[p];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldValue) {
                array[i] = newValue;
            }
        }
    }
}
