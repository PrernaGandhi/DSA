We are implementing queues using linked list and resizeable arrays.
There are three operations we focus on:

    1. Enqueue : to add element to the end of the queue
    2. Dequeue : to remove element from the front of the queue
    3. IsEmpty : to check if queue is empty or not

##### **Linked List Based Queue :**
    We are implementing queue using linked list

    Example :
        enqueue(12) :
                    lastNode
                       |     
                       v
                 ______ ________
     root --->  |  12  |  null  |  ---> null
                 ------ --------
        enqueue(10)
                                    lastNode
                                        |     
                                        v       
                 ______ ____       ------ --------
     root --->  |  12  |  --|---> |  10  |  null  |  ---> null
                 ------ ----       ------ --------

        enqueue(14)
                                                        lastNode
                                                            |     
                                                            v       

                ______ ____         ------ ----       ------ --------
     root ---> |  12  |  --|--->   |  10  |  --|---> |  14  |  null  |  ---> null
                ------ ----         ------ ----       ------ --------

        dequeue()
                                      lastNode
                                         |     
                                         v       

                 ______ ____       ------ --------
     root --->  |  12  |  --|---> |  10  |  null  |  ---> null
                 ------ ----       ------ --------

        enqueue(20)
                                                        lastNode
                                                            |     
                                                            v       

                ______ ____         ------ ----       ------ --------
     root ---> |  12  |  --|--->   |  10  |  --|---> |  20  |  null  |  ---> null
                ------ ----         ------ ----       ------ --------

        enqueue(30)
                                                                            lastNode
                                                                                |     
                                                                                v       

                ______ ____         ------ ----         ------ ----       ------ --------
     root ---> |  12  |  --|--->   |  10  |  --|--->   |  20  |  --|---> |  30  |  null  |  ---> null
                ------ ----         ------ ----         ------ ----       ------ --------

        dequeue()
                                                        lastNode
                                                            |     
                                                            v       

                ______ ____         ------ ----       ------ --------
     root ---> |  12  |  --|--->   |  10  |  --|---> |  20  |  null  |  ---> null
                ------ ----         ------ ----       ------ --------


    Time complexity :
    enqueue    :   O(1)
    dequeue    :   O(1)
    isEmpty    :   O(1)

##### **Resizeable Array Based Queue :**
    We are implementing queue using resizing arrays :

    Conditions to resize the array :
        1.  When the queue is full and now we need to add a new element
        2.  When the queue is quarter full and rest is empty

    Example :
              ___
    array -> |   |
              ---
    enqueue(12)
              ____
    array -> | 12 |
              ----
                ^ ^
                | |
                s e
    enqueue(10)

    resize array to size 2
              ____ ____
    array -> | 10 | 12 |
              ---- ----
                ^    ^
                |    |
                s    e
    enqueue(14)

    resize array to size 4
              ____ ____ ____ ____
    array -> | 10 | 12 | 14 |    |
              ---- ---- ---- ----
                ^        ^
                |        |
                s        e
    dequeue()
              ____ ____ ____ ____
    array -> |    | 12 | 14 |    |
              ---- ---- ---- ----
                     ^    ^
                     |    |
                     s    e
    enqueue(20)
              ____ ____ ____ ____
    array -> |    | 12 | 14 | 20 |
              ---- ---- ---- ----
                    ^         ^
                    |         |
                    s         e
    enqueue(30)
              ____ ____ ____ ____
    array -> | 30 | 12 | 14 | 20 |
              ---- ---- ---- ----
                ^   ^
                |   |
                e   s
    dequeue()
              ____ ____ ____ ____
    array -> | 30 |    | 14 | 20  |
              ---- ---- ---- ----
                ^         ^
                |         |
                e         s

    Complexity of resizing the array is O(N)

    Time complexity :
            Worst case      amortized
    push :      O(N)            O(1)
    pop  :      O(N)            O(1)
    top  :      O(1)            O(1)
