##### **BST**
    
    A BST is a binary tree in symmetric order

    A binary tree is either:
        1. Empty
        2. Two disjoint binary tress (left and right)

##### **2-3 search tree :**
    2-3 search tree allows, 1 or 2 keys per node
        2-node: one key, two children
        3-node: two keys, three children

                    M
     3 node     /       \   2 node
              E  J       R
    smaller /   |   \    /  \
    than  A C   H    L  P   S X
    E         b/w
    E and J

##### **Red Black Trees :**
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
    Searching: 
        search in red black trees is same as in bst
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
        Color Flip:

                        |                                           ||
                        E                                           E
                   //        \\                                 /       \
                A                S             ----->        A             S
             /    \            /    \                    /     \         /     \
         less     b/w        b/w    greater            less   b/w      b/w     greater
         than   A and E    E and S    than             than  A and E  E ans S    than
          A                            S                A                          S

