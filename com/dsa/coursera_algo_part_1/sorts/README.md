#### **Sorting Techniques**

##### **Selection Sort :**
    Selection sort works by finding the smallest element to the right and exchanging with the current index

    Example :
        7   10  5   3   8   4   2   9   6
        ^
        |
       i,j

            find the smallest element
                7   10  5   3   8   4   2   9   6
                ^                       ^
                |                       |
                i                       j

            exchange
                2   10  5   3   8   4   7   9   6
                ^                       ^
                |                       |
                i                       j


        2   10  5   3   8   4   7   9   6
            ^
            |
            i,j

            find the smallest element
                2   10  5   3   8   4   7   9   6
                    ^       ^
                    |       |
                    i       j

            exchange
                2   3   5   10   8   4   7   9   6
                    ^       ^
                    |       |
                    i       j

        2   3   5   10   8   4   7   9   6
                ^
                |
                i,j

            find the smallest element
                2   3   5   10   8   4   7   9   6
                        ^            ^
                        |            |
                        i            j

            exchange
                2   3   4   10   8   5   7   9   6
                        ^            ^
                        |            |
                        i            j

        2   3   4   10   8   5   7   9   6
                    ^
                    |
                    i,j

            find the smallest element
                2   3   4   10   8   5   7   9   6
                            ^        ^
                            |        |
                            i        j

            exchange
                2   3   4   5   8   10   7   9   6
                        ^            ^
                        |            |
                        i            j

        2   3   4   5   8   10   7   9   6
                        ^
                        |
                        i,j

            find the smallest element
                2   3   4   5   8   10   7   9   6
                                ^                ^
                                |                |
                                i                j

            exchange
                2   3   4   5   6   10   7   9   8
                                ^                ^
                                |                |
                                i                j

        2   3   4   5   6   10   7   9   8
                             ^
                             |
                            i,j

            find the smallest element
                2   3   4   5   6   10   7   9   8
                                    ^    ^
                                    |    |
                                    i    j

            exchange
                2   3   4   5   6   7   10   9   8
                                    ^    ^
                                    |    |
                                    i    j


        2   3   4   5   6   7   10   9   8
                                ^
                                |
                                i,j

            find the smallest element
                2   3   4   5   6   7   10   9   8
                                        ^        ^
                                        |        |
                                        i        j

            exchange
                2   3   4   5   6   7   8   9   10
                                        ^        ^
                                        |        |
                                        i        j

        2   3   4   5   6   7   8   9   10
                                    ^
                                    |
                                    i,j

            find the smallest element
                2   3   4   5   6   7   8   9   10
                                            ^
                                            |
                                            i,j

            exchange
                2   3   4   5   6   7   8   9   10
                                            ^
                                            |
                                            i,j

        2   3   4   5   6   7   8   9   10
                                         ^
                                         |
                                        i,j

            find the smallest element
                2   3   4   5   6   7   8   9   10
                                                 ^
                                                 |
                                                i,j

            exchange
                2   3   4   5   6   7   8   9   10
                                                 ^
                                                 |
                                                i,j

##### **Insertion Sort :**
    Insertion sort works on the premise that the elements on the left are already sorted and
    as we encounter a new element, we sort elements to the left
    
    Example :
    
        i
        |
        v
        7   10  5   3   8   4   2   9   6
        ^
        |
        j
        
    
            i
            |
            v
        7   10  5   3   8   4   2   9   6
        ^    ^
        |    |
       j-1   j
        
        j > j-1, break
      
                i
                |
                v
        7   10  5   3   8   4   2   9   6
            ^   ^
            |   |
           j-1  j
           
                j < j - 1, swap   
                        i
                        |
                        v
                7   5   10  3   8   4   2   9   6
                ^   ^
                |   |
               j-1  j
      
                j < j - 1, swap   
                        i
                        |
                        v
                5   7   10  3   8   4   2   9   6
                ^
                |   
                j

                    i
                    |
                    v
        5   7   10  3   8   4   2   9   6
                ^   ^
                |   |
               j-1  j
        j < j-1, swap
                            i
                            |
                            v
                5   7   3  10   8   4   2   9   6
                    ^   ^
                    |   |
                   j-1  j
                j < j-1, swap
                            i
                            |
                            v
                5   3   7  10   8   4   2   9   6
                ^   ^
                |   |
               j-1  j
               j < j-1, swap
                            i
                            |
                            v
                3   5   7  10   8   4   2   9   6
                ^   
                |   
                j
         

                        i
                        |
                        v
        3   5   7  10   8   4   2   9   6
                    ^   ^
                    |   |
                   j-1  j
                j < j-1, swap           
                                i
                                |
                                v
                3   5   7   8   10   4   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                 j > j -1, break   
                 
                            i
                            |
                            v
        3   5   7  10   8   4   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap               
                                i
                                |
                                v
                3   5   7  10   4   8   2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap               
                                i
                                |
                                v
                3   5   7   4  10   8   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap               
                               i
                               |
                               v
                3   5   4   7  10   8   2   9   6
                    ^   ^
                    |   |
                   j-1  j
                j<j-1, swap               
                               i
                               |
                               v
                3   4   5   7  10   8   2   9   6
                ^   ^
                |   |
               j-1  j                       
                               i
                               |
                               v
                3   4   5   7  10   8   2   9   6
                ^   
                |   
                j
                       
                            i
                            |
                            v
        3   4   5   7  10   8   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap           
                                    i
                                    |
                                    v
                3   4   5   7   8   10   2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap           
                                    i
                                    |
                                    v
                3   4   5   7   8   10   2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j>j-1, break
                
                                i
                                |   
                                v
        3   4   5   7   8   10  2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap
                                        i
                                        |   
                                        v
                3   4   5   7   8   2   10   9   6
                                ^   ^
                                |   |
                               j-1  j
                j<j-1, swap
                                        i
                                        |   
                                        v
                3   4   5   7   2   8   10   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap
                                        i
                                        |   
                                        v
                3   4   5   2   7   8   10   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap
                                        i
                                        |   
                                        v
                3   4   2   5   7   8   10   9   6
                    ^   ^
                    |   |
                   j-1  j
                j<j-1, swap
                                        i
                                        |   
                                        v
                2   3   4   5   7   8   10   9   6
                ^   ^
                |   |
               j-1  j
               j > 0, false, break 
                                        i
                                        |   
                                        v
                2   3   4   5   7   8   10   9   6
                ^   
                |   
                j
        
                                    i
                                    |   
                                    v
        2   3   4   5   7   8   10  9   6
                                ^   ^
                                |   |
                               j-1  j
                j<j-1, swap      
                                            i
                                            |   
                                            v
                2   3   4   5   7   8   9   10   6
                                    ^   ^
                                    |   |
                                   j-1  j
                j > j-1, break                     
                                   
                                         i
                                         |   
                                         v
        2   3   4   5   7   8   9   10   6
                                     ^   ^
                                     |   |
                                    j-1  j
                j<j-1, swap      
                                                i
                                                |   
                                                v
                2   3   4   5   7   8   9   6   10
                                        ^   ^
                                        |   |
                                       j-1  j
                j<j-1, swap      
                                                i
                                                |   
                                                v
                2   3   4   5   7   8   6   9   10
                                    ^   ^
                                    |   |
                                   j-1  j
                j<j-1, swap      
                                                i
                                                |   
                                                v
                2   3   4   5   7   6   8   9   10
                                ^   ^
                                |   |
                               j-1  j
                     
                j<j-1, swap      
                                                i
                                                |   
                                                v
                2   3   4   5   6   7   8   9   10
                            ^   ^
                            |   |
                           j-1  j
                j > j-1, break           
                                                i
                                                |   
                                                v
                2   3   4   5   6   7   8   9   10
                            ^   ^
                            |   |
                           j-1  j

##### **Shell Sort :**
    Shell sort has the same underlying sorting technique as insertion sort,
    the only difference being that we do that in different passes

    Example :
        S   O   R   T   E   X   A   M   P   L   E

        elements length (l) = 11
        h = (l - 1) / 3
        h = (11 - 1) / 3
        h = 3

        3 sort
        S   O   R   T   E   X   A   M   P   L   E
                    ^
                    |
                  h,i,j

            S   O   R   T   E   X   A   M   P   L   E
            ^           ^
            |           |
           j-h        h,i,j
           j-h < j, break

        S   O   R   T   E   X   A   M   P   L   E
            ^           ^
            |           |
           j-h        h,i,j
       j-h > j, exchange

            S   E   R   T   O   X   A   M   P   L   E
                ^           ^
                |           |
               j-h        h,i,j

        j = j - h
        now j-h < 0 < h
        so we move forward

        S   E   R   T   O   X   A   M   P   L   E
                ^           ^
                |           |
               j-h        h,i,j
        now j-h < j
        we move forward

        S   E   R   T   O   X   A   M   P   L   E
                    ^           ^
                    |           |
                   j-h        h,i,j
        j-h > j, exchange
            S   E   R   A   O   X   T   M   P   L   E
                        ^           ^
                        |           |
                       j-h        h,i,j
            now j = j - h
            S   E   R   A   O   X   T   M   P   L   E
            ^           ^           ^
            |           |           |
           j-h          j          h,i
           j-h > j, exchange
            A   E   R   S   O   X   T   M   P   L   E
            ^           ^           ^
            |           |           |
           j-h          j          h,i
       now we move forward
       A   E   R   S   O   X   T   M   P   L   E
                       ^           ^
                       |           |
                      j-h        h,i,j
        j-h > j, exchange
            j =j-h
           A   E   R   S   M   X   T   O   P   L   E
               ^           ^           ^
               |           |           |
              j-h          j          h,i
        now j-h < j, move  forward
        A   E   R   S   M   X   T   O   P   L   E
                            ^           ^
                            |           |
                           j-h        h,i,j
        now j-h > j, exchange
            A   E   R   S   M   P   T   O   X   L   E
                    ^           ^           ^
                    |           |           |
                   j-h          j          h,i
            j-h > j, exchange
            A   E   P   S   M   R   T   O   X   L   E
                    ^           ^           ^
                    |           |           |
                   j-h          j          h,i

        A   E   P   S   M   R   T   O   X   L   E
                                ^           ^
                                |           |
                               j-h        h,i,j
        j-h > j, exchange
            A   E   P   S   M   R   L   O   X   T   E
                        ^           ^           ^
                        |           |           |
                       j-h          j          h,i
            j-h > j, exchange
            A   E   P   L   M   R   S   O   X   T   E
                        ^           ^           ^
                        |           |           |
                       j-h          j          h,i
            A   E   P   L   M   R   S   O   X   T   E
            ^           ^                       ^
            |           |                       |
           j-h          j                      h,i

           j-h < j, move forward
        A   E   P   L   M   R   S   O   X   T   E
                                    ^           ^
                                    |           |
                                   j-h        h,i,j
        j-h > j, exchange
            A   E   P   L   M   R   S   E   X   T   O
                            ^           ^           ^
                            |           |           |
                           j-h          j          h,i
        j-h > j, exchange
            A   E   P   L   E   R   S   M   X   T   O
                ^           ^                       ^
                |           |                       |
               j-h          j                      h,i
        j-h < j, move forward

        h=h/3
        h=3/3
        h=1

        1 sort
        A   E   P   L   E   R   S   M   X   T   O
        ^   ^
        |   |
       j-h h,i,j
       j-h < j, move forward

        A   E   P   L   E   R   S   M   X   T   O
            ^   ^
            |   |
           j-h h,i,j
       j-h < j, move forward
        A   E   P   L   E   R   S   M   X   T   O
                ^   ^
                |   |
               j-h h,i,j
            j-h > j, exchange
            A   E   L   P   E   R   S   M   X   T   O
                ^   ^   ^
                |   |   |
               j-h  j h,i,j
         j-h < j, move forward
        A   E   L   P   E   R   S   M   X   T   O
                    ^   ^
                    |   |
                   j-h h,i,j
            j-h > j, exchange
            A   E   L   E   P   R   S   M   X   T   O
                    ^   ^   ^
                    |   |   |
                   j-h  j h,i,j
            j-h > j, exchange
            A   E   E   L   P   R   S   M   X   T   O
                ^   ^       ^
                |   |       |
               j-h  j     h,i,j
        A   E   E   L   P   R   S   M   X   T   O
                        ^   ^
                        |   |
                       j-h h,i,j
         j-h<j, move forward

        A   E   E   L   P   R   S   M   X   T   O
                            ^   ^
                            |   |
                          j-h h,i,j
        j-h<j, move forward

        A   E   E   L   P   R   S   M   X   T   O
                                ^   ^
                                |   |
                              j-h h,i,j
       j-h>j, exchange
            A   E   E   L   P   R   M   S   X   T   O
                                ^   ^   ^
                                |   |   |
                              j-h   j  h,i
       j-h>j, exchange
            A   E   E   L   P   M   R   S   X   T   O
                            ^   ^       ^
                            |   |       |
                          j-h   j      h,i
       j-h>j, exchange
            A   E   E   L   M   P   R   S   X   T   O
                        ^   ^           ^
                        |   |           |
                       j-h   j         h,i
         j-h < j, move forward

        A   E   E   L   M   P   R   S   X   T   O
                                    ^   ^
                                    |   |
                                   j-h h,i,j
         j-h < j, move forward

        A   E   E   L   M   P   R   S   X   T   O
                                        ^   ^
                                        |   |
                                       j-h h,i,j
        j-h >j, exchange

            A   E   E   L   M   P   R   S   T   X   O
                                        ^   ^   ^
                                        |   |   |
                                       j-h  j  h,i

       j-h<j, move forward
       A   E   E   L   M   P   R   S   T   X   O
                                           ^   ^
                                           |   |
                                          j-h  h,i,j

           A   E   E   L   M   P   R   S   T   O   X
                                           ^   ^   ^
                                           |   |   |
                                          j-h  j  h,i
       j-h>j, exchange
           A   E   E   L   M   P   R   S   O   T   X
                                       ^   ^       ^
                                       |   |       |
                                      j-h  j      h,i

       j-h>j, exchange
           A   E   E   L   M   P   R   O   S   T   X
                                   ^   ^           ^
                                   |   |           |
                                  j-h  j          h,i
       j-h>j, exchange
           A   E   E   L   M   P   O   R   S   T   X
                               ^   ^               ^
                               |   |               |
                              j-h  j              h,i
       j-h>j, exchange
           A   E   E   L   M   O   P   R   S   T   X
                           ^   ^                   ^
                           |   |                   |
                          j-h  j                  h,i

##### **MergeSort :**

    MergeSort involves splitting the array into half,
    sort the individual halves and merge them in sorted order

    M   E   R   G   E   S   O   R   T

    sort(MERG)
    sort(ESORT)

    E   G   M   R       E   O   R   S   T

    merge()

    E   G   M   R       E   O   R   S   T
    ^                   ^
    |                   |
    i                   j

    arr -> E

    E   G   M   R       E   O   R   S   T
        ^               ^
        |               |
        i               j

    arr -> E E
    E   G   M   R       E   O   R   S   T
    ^                   ^
    |                   |
    i                   j
    
    arr -> E E G
    E   G   M   R       E   O   R   S   T
    ^               ^
    |               |
    i               j
    
    arr -> E E G M
    E   G   M   R       E   O   R   S   T
    ^           ^
    |           |
    i           j
    
    arr -> E E G M O
    E   G   M   R       E   O   R   S   T
    ^               ^
    |               |
    i               j
    
    arr -> E E G M O R
    E   G   M   R       E   O   R   S   T
    ^             ^
    |             |
    i             j
    since first half array is exhausted
    
        copy all elements from second half of array to the output array
    
    arr -> E E G M O R R S T

##### **Quick Sort :**
    Quicksort is implemented by first partitioning the array in such a way that
    all elements to the left of it is smaller than the pivot element,
    and all elements to the right of it is greater than the pivot element

    Example:
        S   O   R   T   E   X   A   M   P   L   E
        ^   ^                                   ^
        |   |                                   |
       low  i                                   j

        S   O   R   T   E   X   A   M   P   L   E
        ^           ^                           ^
        |           |                           |
       low          i                           j

       At this point element at i is greater than element at low
       and element at j is lower than element at low so we swap elements
       at i and j

        S   O   R   E   E   X   A   M   P   L   T
        ^           ^                           ^
        |           |                           |
       low          i                           j

        S   O   R   E   E   X   A   M   P   L   T
        ^                   ^               ^
        |                   |               |
       low                  i               j
       At this point element at i is greater than element at low
       and element at j is lower than element at low so we swap elements
       at i and j

        S   O   R   E   E   L   A   M   P   X   T
        ^                   ^               ^
        |                   |               |
       low                  i               j
        S   O   R   E   E   L   A   M   P   X   T
        ^                               ^   ^
        |                               |   |
       low                              j   i

      At this point i crossed j so we swap j and low
        P   O   R   E   E   L   A   M   S   X   T
        ^                               ^   ^
        |                               |   |
       low                              j   i

       Now elements before S are smaller than S
       and elements after S are greater than S

       Now we sort the individual halves and the array is sorted



