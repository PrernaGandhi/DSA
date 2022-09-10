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

