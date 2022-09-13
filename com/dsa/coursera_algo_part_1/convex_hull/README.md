##### **Convex Hull**

    Convex Hull is formed by a set of points that are on the boundary enclosing all the other points

            (0, 3),
            (1, 1),
            (2, 2),
            (4, 4),
            (0, 0),
            (1, 2),
            (3, 1),
            (3, 3)

        ^
        |
      4 -                           o E
        |
      3 o G                  o D
        |
      2 -      o F    o C
        |
      1 -      o B           o A
        |
      P o ---- | ---- | ---- | ---- | ---->
        0      1      2      3      4


        Sort by y co-ordinate

           P (0, 0),
           B (1, 1),
           A (3, 1),
           F (1, 2),
           C (2, 2),
           G (0, 3),
           D (3, 3),
           E (4, 4)

        Sort by polar angle

           P (0, 0),
           A (3, 1),
           B (1, 1),
           C (2, 2),
           D (3, 3),
           E (4, 4),
           F (1, 2),
           G (0, 3)

    Now we push first two items to the stack

                    |   A (3, 1)    |
    Stack - >       |   P (0, 0)    |
                     ---------------

    Now iterate all the points starting from the third point,

    current element - > B (1, 1)
            XX -> pop the top element from the stack -> A (3, 1)

                            |               |
            Stack - >       |   P (0, 0)    |
                             ---------------

            Compare(A, P, B),
            it is counter clockwise so we add both A and B to the stack
                            |   B (1, 1)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------

       current element - > C (2, 2)
            XX -> pop the top element from the stack -> B (1, 1)
                            |               |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(B, A, C)
            it is clock wise
             so we remove the top element from stack
             and replace XX with the element removed
             XX -> A (3, 1)

                            |               |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(A, C, P)
            it is counter clockwise,
            so add A, C
                            |   C (2, 2)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------

       current element - > D (3, 3)
            XX -> pop the top element from the stack -> C (2, 2)
                            |               |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(B, A, D)
            it is clock wise
             so we remove the top element from stack
             and replace XX with the element removed
             XX -> A (3, 1)

                            |               |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(A, D, P)
            it is counter clockwise,
            so add A, D
                            |   D (3, 3)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------

       current element - > E (4, 4)
            XX -> pop the top element from the stack -> D (3, 3)
                            |               |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(B, E, D)
            it is clock wise
             so we remove the top element from stack
             and replace XX with the element removed
             XX -> A (3, 1)

                            |               |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(A, E, P)
            it is counter clockwise,
            so add A, E
                            |   E (4, 4)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------

      current element - > F (1, 2)
            XX -> pop the top element from the stack -> E (4, 4)
                            |               |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(E, F, A)
            it is counter clockwise,

                            |   F (1, 2)    |
                            |   E (4, 4)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------

       current element - > G (0, 3)
            XX -> pop the top element from the stack -> F (1, 2)
                            |   E (4, 4)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------
           Compare(F, E, G)
            it is clock wise
             so we remove the top element from stack
             and replace XX with the element removed
             XX -> E (4, 4)
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------
            Compare(A, E, F)
            it is counter clockwise,
            so add F, E
                            |   F (0, 3)    |
                            |   E (4, 4)    |
                            |   A (3, 1)    |
            Stack - >       |   P (0, 0)    |
                             ---------------

    Convex hull is Formed by P(0, 0) A(3, 1) E(4, 4) G(0, 3)
