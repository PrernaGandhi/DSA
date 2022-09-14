package com.dsa.coursera_algo_part_1.sorts.heap_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Heap sort uses max heap under the hood
    Build max heap using bottom-up method
    sort down - delete the largest remaining item

    Nlog N in place sorting algorithm, but not stable
    poor use of cache memory

    Example :

    array -> "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"

    Now if we represent the same in tree form

                         0
                         S
                  1   /     \    2
                   O           R
            3   /    \  4  5 /    \  6
              T       E     X       A
            /  \     /  \
          M     P   L    E
         7      8   9    10
 => Now lets start to build max heap
            n/2 = 11/ 2 = 5
            Element at index 5 is X
            since it has no children so it is placed in correct position if we consider it to be the root

                        0
                         S
                  1   /     \    2
                   O           R
            3   /    \  4  5 /    \  6
              T       E     X       A
            /  \     /  \
          M     P   L    E
         7      8   9    10


            now element at index 4 is E
            now lets consider this sub tree
             E
           /   \
          L     E
           now we find greater of two children, L is greater

           now we check with the root element E, since L is greater than E,
           max heap property is violated,
           hence we exchange
                L
               / \
              E   E
           now parent index  =  child index = 9
           now since there is no child of element at index 9, we move forward

                         0
                         S
                  1   /     \    2
                   O           R
            3   /    \  4  5 /    \  6
              T       L     X       A
            /  \     /  \
          M     P   E    E
         7      8   9    10


           now element at index 3 is T
           now lets consider this sub tree
                T
              /   \
             M     P
           now lets find the max of two children, which is P

           lets compare with T, since P is smaller than T, so it is already in correct position
           now parent index  =  child index = 8,
           now since there is no child of element at index 9, we move forward

                         0
                         S
                  1   /     \    2
                   O           R
            3   /    \  4  5 /    \  6
              T       L     X       A
            /  \     /  \
          M     P   E    E
         7      8   9    10

        now element at index 2 is R,
        now lets consider this sub tree
            R
          /   \
         X     A
        greater of two children is X, comparing with R,
        R is smaller than X, so we exchange
            X
           / \
          R   A
        now parent index = child index = 5, since it has no children we move forward,

                         0
                         S
                  1   /     \    2
                   O           X
            3   /    \  4  5 /    \  6
              T       L     R       A
            /  \     /  \
          M     P   E    E
         7      8   9    10

        now element at index 1 is O
                O
              /   \
            T       L
          /   \   /   \
         M     P E     E
        the max of two children is T, compare with O
        since T is greater so exchange,
                T
              /   \
            O       L
          /   \   /   \
         M     P E     E

        now the parent index = child index = 3
        now lets consider this sub tree
            O
           / \
          M   P
        max of two children = P
        compare with O, since P is greater than O, swap
            P
          /   \
         M     O
        parent index = child index = 8
        but since it has no child, we move forward

                         0
                         S
                  1   /     \    2
                   T           X
            3   /    \  4  5 /    \  6
              P       L     R       A
            /  \     /  \
          M     O   E    E
         7      8   9    10

        now element at index 0 is S
        max of both children, X, compare with S
        since S is smaller than X, swap
                         0
                         X
                  1   /     \    2
                   T           S
            3   /    \  4  5 /    \  6
              P       L     R       A
            /  \     /  \
          M     O   E    E
         7      8   9    10

        parent index = child index = S
        max of two children, R, compare with S,
        since S is greater than R, so S is in the right position,

        as this point, we have the max heap ready
=>Now let's sort down the elements
                         0
                         X
                  1   /     \    2
                   T           S
            3   /    \  4  5 /    \  6
              P       L     R       A
            /  \     /  \
          M     O   E    E
         7      8   9    10
        exchange X(0) and E(10)
                         0
                         E
                  1   /     \    2
                   T           S
            3   /    \  4  5 /    \  6
              P       L     R       A
            /  \     /  \
          M     O   E    X
         7      8   9    10

        now assume we only have elements till position 9,

        lets find correct position of E(0),
        max of two children, T
        compare with E,
        since E is less than T, swap,
                         0
                         T
                  1   /     \    2
                   E           S
            3   /    \  4  5 /    \  6
              P       L     R       A
            /  \     /  \
          M     O   E    X
         7      8   9    10
        parent index = child index E(1)
        max of two children, P,
        compare with E, since E is smaller than P,
        swap
                         0
                         T
                  1   /     \    2
                   P           S
            3   /    \  4  5 /    \  6
              E       L     R       A
            /  \     /  \
          M     O   E    X
         7      8   9    10
        parent index = child index E(3)
        max of two children, O, since E is smaller than M,
        swap
                         0
                         T
                  1   /     \    2
                   P           S
            3   /    \  4  5 /    \  6
              M       L     R       A
            /  \     /  \
          E     O   E    X
         7      8   9    10

        now exchange T(0) with E(9)
                         0
                         E
                  1   /     \    2
                   P           S
            3   /    \  4  5 /    \  6
              M       L     R       A
            /  \     /  \
          E     O   T    X
         7      8   9    10
         now assume we only have elements till index 8
         now lets find position for E(0)
         max of two children S,
         compare with E, since E is smaller than S,
         swap
                         0
                         S
                  1   /     \    2
                   P           E
            3   /    \  4  5 /    \  6
              M       L     R       A
            /  \     /  \
          E     O   T    X
         7      8   9    10
         parent index = child index = E(2)
         max of two children R,
         compare with E,
         since E is smaller than R,
         swap
                         0
                         S
                  1   /     \    2
                   P           R
            3   /    \  4  5 /    \  6
              M       L     E       A
            /  \     /  \
          E     O   T    X
         7      8   9    10

        now exchange S(0) with O(8)
                         0
                         O
                  1   /     \    2
                   P           R
            3   /    \  4  5 /    \  6
              M       L     E       A
            /  \     /  \
          E     S   T    X
         7      8   9    10

        assume we only have elements till index 7
        lets find position for O(0)
        max of both children R,
        since O is smaller than R swap
                         0
                         R
                  1   /     \    2
                   P           O
            3   /    \  4  5 /    \  6
              M       L     E       A
            /  \     /  \
          E     S   T    X
         7      8   9    10
       parent index = child index O(2)
       max of both children E,
       compare with O,
       since O is greater than E, O is at the right position

       exchange R(0) with E(7)
                         0
                         E
                  1   /     \    2
                   P           O
            3   /    \  4  5 /    \  6
              M       L     E       A
            /  \     /  \
          R     S   T    X
         7      8   9    10
         now assume we only have elements till index 6,
         now let's find position for E(0)
         max of two children P,
         compare with E,
         since E is smaller than P, swap
                         0
                         P
                  1   /     \    2
                   E           O
            3   /    \  4  5 /    \  6
              M       L     E       A
            /  \     /  \
          R     S   T    X
         7      8   9    10
        parent index = child index = E(1)
        max of two children = M
        compare with E, since E is smaller than M, swap
                         0
                         P
                  1   /     \    2
                   M           O
            3   /    \  4  5 /    \  6
              E       L     E       A
            /  \     /  \
          R     S   T    X
         7      8   9    10

        exchange P(0) with A(6)
                         0
                         A
                  1   /     \    2
                   M           O
            3   /    \  4  5 /    \  6
              E       L     E       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

       assume we only have elements till index 5
       lets find position for A(0)
       max of two children, O
       compare with A, since A is smaller, swap
                         0
                         O
                  1   /     \    2
                   M           A
            3   /    \  4  5 /    \  6
              E       L     E       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

       now A has only one child E which is greater than A,
       so swap
                         0
                         O
                  1   /     \    2
                   M           E
            3   /    \  4  5 /    \  6
              E       L     A       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

        exchange O(0) with A(5)

        assume we only have elements till index 4
                         0
                         A
                  1   /     \    2
                   M           E
            3   /    \  4  5 /    \  6
              E       L     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

        max of two children M
        since M is greater than A, swap
                         0
                         M
                  1   /     \    2
                   A           E
            3   /    \  4  5 /    \  6
              E       L     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10
        max of two children, L, compare with A, swap
                         0
                         M
                  1   /     \    2
                   L           E
            3   /    \  4  5 /    \  6
              E       A     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

       exchange M(0) with A(4)
                         0
                         A
                  1   /     \    2
                   L           E
            3   /    \  4  5 /    \  6
              E       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10
       assume we only have elements till index 3
       lets find position for A
       max of two children
       L, compare with A, A smaller so swap
                         0
                         L
                  1   /     \    2
                   A           E
            3   /    \  4  5 /    \  6
              E       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10
        A has only one child E,
        since E is greater than A so swap
                         0
                         L
                  1   /     \    2
                   E           E
            3   /    \  4  5 /    \  6
              A       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

         exchange L(0) with A(3)
                         0
                         A
                  1   /     \    2
                   E           E
            3   /    \  4  5 /    \  6
              L       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

         assume we only have elements till index 2
         lets find position for A
         max of two children E(1)
         swap
                         0
                         E
                  1   /     \    2
                   A           E
            3   /    \  4  5 /    \  6
              L       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

        exchange E(0) with E(2)
                         0
                         E
                  1   /     \    2
                   A           E
            3   /    \  4  5 /    \  6
              L       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10
      lets find position for E(0), it is at correct position

      exchange E(0) with A(1)
                         0
                         A
                  1   /     \    2
                   E           E
            3   /    \  4  5 /    \  6
              L       M     O       P
            /  \     /  \
          R     S   T    X
         7      8   9    10

      lets find position for A(0), it is at the correct place,

      now the elements are sorted

 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        buildMaxHeap(elements);
        sortDown(elements, elements.length - 1);
        return elements;
    }

    private void sortDown(T[] elements, int length) {
        while (length >= 0) {
            exchange(elements, 0, length);
            sink(elements, 0, --length);
        }
    }

    private void buildMaxHeap(T[] elements) {
        for (int parentIndex = elements.length / 2; parentIndex >= 0; parentIndex--) {
            sink(elements, parentIndex, elements.length - 1);
        }
    }

    private void sink(T[] elements, int parentIndex, int length) {
        // this takes longer, and hence not used much
        while (parentIndex * 2 < length) {
            // this should be inside the loop
            int childIndex = parentIndex * 2 + 1;
            if (childIndex < length && less(elements[childIndex], elements[childIndex + 1])) {
                childIndex++;
            }
            if (!less(elements[parentIndex], elements[childIndex])) {
                break;
            }
            exchange(elements, parentIndex, childIndex);
            parentIndex = childIndex;
        }
    }
}
