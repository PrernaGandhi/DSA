package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.path_compression;

import com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.UnionFind;

/*
    This is an enhancement to the weighted quick union approach that we have seen earlier.
    This works the exact same way but while we are finding the root during union, we update each node on
    the way to root to each of it's parent to be the top parent

    For this, we use an array to store this data. Initially, the array would look something like this

    Value   0   1   2   3   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    size    1   1   1   1   1   1   1   1   1   1

    Now let's walk through an example
    For union operations union(p, q) we update p's root to be equal to root of q,
    which is nothing but arr[root(p)] = root(q), only if size of root(q) > size of root(q)

    union(3, 8)

    In this case, root of 3 is 3 and
    root of 8 is 8 and the size of both is 1,
    hence it doesn't really matter who becomes
    the parent and who becomes the child
    Value   0   1   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    size    1   1   1   1   1   1   1   1   2   1

    0   1   2   4   5   6   7   8   9
                                |
                                3

    union(1, 0)

    this is similar to the above case

    Value   0   0   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    2   1   1   1   1   1   1   1   2   1

    0   2   4   5   6   7   8   9
    |                       |
    1                       3

    union(4, 5)

    Value   0   0   2   8   5   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    2   1   1   1   1   2   1   1   2   1

    0   2   5   6   7   8   9
    |       |           |
    1       4           3

    union(4, 1)

    4 -> root of 5 -> 5
    size of 5 is 2
    1 -> root of 1 -> 0
    size of 0 is 2
    so it doesn't matter who is the child and who is the parent
    so we make 5 a child of 0

    Also we update root of 4 to be 0

    Value   0   0   2   8   0   0   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    4   1   1   1   1   2   1   1   2   1

        0    2   6   7   8   9
      / | \              |
     1  4  5             3


    union(4, 8)
    root of 4 -> 5 -> 0
    size of 0 is 4
    root of 8 -> 8
    size of 8 is 2

    So the smaller tree would be the child and the larger tree would be the parent
    Value   0   0   2   8   0   0   6   7   0   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    6   1   1   1   1   2   1   1   2   1

         0       2   6   7   9
      / | \ \
     1  8  5 4
        |
        3

    union(7, 9)
    root of 7 -> 7
    size of 7 is 1
    root of 9 -> 9
    size of 9 is 1

    so it doesn't matter who is the parent and who is the child

    Value   0   0   2   8   0   0   6   9   0   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    6   1   1   1   1   2   1   1   2   2

         0       2   6   9
      / | \ \            |
     1  8  5 4           7
        |
        3

    union(7, 6)
    root of 7 is 9
    size of 9 is 2
    root of 6 is 6
    size of 6 is 1

    Now we make 6 as child of 9

    Value   0   0   2   8   0   0   9   9   0   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    6   1   1   1   1   2   1   1   2   3

         0       2   9
      / | \ \       / \
     1  8  5 4     6   7
        |
        3

    union(1, 7)
    root of 1 is 0
    size of 0 is 6
    root of 7 is 9
    size of 9 is 3

    so we make 9 child of 0

    Value   0   0   2   8   0   0   9   9   0   0
    Index   0   1   2   3   4   5   6   7   8   9
    size    9   1   1   1   1   2   1   1   2   3

          0       2
      / / | \ \
     1  8 5  4 9
        |     / \
        3    6   7

    For connected queries we need to do more work, we need to find the root
    of each and compare if it is equal or not,
    connected(p, q) -> we find root of p, we find root of q, and then compare
    both values.

    connected(1, 3) => true, connected
    root of 1 -> 0 -> 0
    root of 3 -> 8 -> 0
    0 == 0, hence they lie in the same connected component

    connected(0, 4) => true, connected
    root of 0 -> 0
    root of 4 -> 5 -> 0
    0 == 0, hence they lie in the same connected components

    Time complexity :

    Initialization      :   O(N)
    Union               :   O(N + MlogN)
    Find                :   O(N + MlogN)

 */
public class PathCompressionQuickUnion implements UnionFind {
    private final int[] array;

    private final int[] size;

    public PathCompressionQuickUnion(int n) {
        this.array = new int[n];
        this.size = new int[n];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = i;
            this.size[i] = 1;
        }
    }

    public int root(int child) {
        int parent = array[child];
        while (parent != child) {
            array[child] = array[array[child]];
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
        int pRoot = root(p);
        int qRoot = root(q);
        if (size[pRoot] > size[qRoot]) {
            array[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            array[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
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
