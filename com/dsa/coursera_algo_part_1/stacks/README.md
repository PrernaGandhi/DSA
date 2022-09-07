We are trying to implement stacks using stacks and resizing arrays.
We will implement the basic stack operations :

     1. push : push an element to the top of stack
     2. pop  : pop the top element of stack
     3. top  : top element of stack

##### **Linked List Based Stack Implementation :**
    We are implementing stack using linked list

    Example : 
        push(12) : 
                 ______ ________
     root --->  |  12  |  null  |  ---> null
                 ------ --------
        push(10)
                 ______ ____       ------ --------
     root --->  |  10  |  --|---> |  12  |  null  |  ---> null
                 ------ ----       ------ --------

        push(14)
                ______ ____         ------ ----       ------ --------
     root ---> |  14  |  --|--->   |  10  |  --|---> |  12  |  null  |  ---> null
                ------ ----         ------ ----       ------ --------
        
        pop()
                 ______ ____       ------ --------
     root --->  |  10  |  --|---> |  12  |  null  |  ---> null
                 ------ ----       ------ --------

        push(20)
                ______ ____         ------ ----       ------ --------
     root ---> |  20  |  --|--->   |  10  |  --|---> |  12  |  null  |  ---> null
                ------ ----         ------ ----       ------ --------
        
        push(30)
                ______ ____         ------ ----         ------ ----       ------ --------
     root ---> |  30  |  --|--->   |  20  |  --|--->   |  10  |  --|---> |  12  |  null  |  ---> null
                ------ ----         ------ ----         ------ ----       ------ --------
        
        pop()
                ______ ____         ------ ----       ------ --------
     root ---> |  20  |  --|--->   |  10  |  --|---> |  12  |  null  |  ---> null
                ------ ----         ------ ----       ------ --------        
        
        
    Time complexity :
    push    :   O(1)
    pop     :   O(1)
    top     :   O(1)

##### **Resizing Arrays :**
    We are implementing stacks using resizing arrays :

    Conditions to resize the array :
        1.  When the stack is full and now we need to add a new element
        2.  When the stack is quarter full and rest is empty

    Example : 
              ___
    array -> |   |
              ---
    push(12)     
              ____
    array -> | 12 |
              ----
    push(10) 

    resize array to size 2
              ____ ____
    array -> | 12 | 10 |
              ---- ----
    push(14)      
    
    resize array to size 4    
              ____ ____ ____ ____
    array -> | 12 | 10 | 14 |    |
              ---- ---- ---- ----
    pop()
              ____ ____ ____ ____
    array -> | 12 | 10 |    |    |
              ---- ---- ---- ----
    push(20)    
              ____ ____ ____ ____
    array -> | 12 | 10 | 20 |    |
              ---- ---- ---- ----
    push(30)
              ____ ____ ____ ____
    array -> | 12 | 10 | 20 | 30 |
              ---- ---- ---- ----
    pop()
              ____ ____ ____ ____
    array -> | 12 | 10 | 20 |    |
              ---- ---- ---- ----    
    

    Complexity of resizing the array is O(N)

    Time complexity :
            Worst case      amortized
    push :      O(N)            O(1)
    pop  :      O(N)            O(1)
    top  :      O(1)            O(1)


