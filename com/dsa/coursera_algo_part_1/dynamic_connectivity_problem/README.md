We are trying to solve the Dynamic Connectivity Problem,

Given two points we check if there is a path between those two points.
Take a look at the below example to understand more about the problem


    A
    o   .___.___.   .___.   .___.   .___.
    |   |       |   |   |   |   |   |   |
    .___.   .___.   .   .___.   .   .   .
    |   |   |       |       |   |   |   |
    .   .   .___.___.   .___.   .   .   .
        |       |           |           |
    .___.   .   .___.   .   .   .___.___.
        |   |   |       |   |   |       |
    .   .   .___.   .___.___.___.___.___o
                                        B

Now we need to find if there is a path from A to B.

To understand how to solve dynamic connectivity problem, we must be
familiar with concept of **_"Connected Components"_**

If two objects or points lie in the same connected components,
they are connected. 

Now that we are familiar with connected components,
We can solve this using union find method.
Union find method has essentially two operations to perform,
union operation and find operation.
The union operation connects two points, and the find operation
tells us if the two points are connected or not.

There are two approaches we can have for this :

##### **Quick Find(Eager Approach) :**
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

##### **Quick Union(Lazy Approach):**

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

    0   1   2   4   5   6   7   8
                                |
                                3

    union(1, 0)

    Value   0   0   2   8   4   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    0   2   4   5   6   7   8
    |                       |
    1                       3

    union(4, 5)

    Value   0   0   2   8   5   5   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

    0   2   5   6   7   8
    |       |           |
    1       4           3

    union(4, 1)

    4 -> root of 5 -> 5
    1 -> root of 1 -> 0

    so we make 5 a child of 0

    Value   0   0   2   8   5   0   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9

        0   2   6   7   8
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

With a slight improvement to Quick Union, we can optimize the find
and the union operation to complexity O(logN) and this approach is
called weighted quick union

##### **Weighted Quick Union:**
    This is an enhancement to the quick union approach that we have seen earlier.
    This works the exact same way but when we merge two trees, we are mindful to place
    the smaller tree as a child of bigger tree and not vice-versa.

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

    Value   0   0   2   8   5   0   6   7   8   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    4   1   1   1   1   2   1   1   2   1

        0   2   6   7   8   9
      /  \              |
     1    5             3
          |
          4

    union(4, 8)
    root of 4 -> 5 -> 0
    size of 0 is 4
    root of 8 -> 8
    size of 8 is 2

    So the smaller tree would be the child and the larger tree would be the parent
    Value   0   0   2   8   5   0   6   7   0   9
    Index   0   1   2   3   4   5   6   7   8   9
    size    6   1   1   1   1   2   1   1   2   1

        0       2   6   7   9
      / | \
     1  8  5
        |  |
        3  4

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
    Union               :   O(M + logN)
    Find                :   O(M + logN)

##### **Path Compression weighted Quick Union:**
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
