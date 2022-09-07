package com.dsa.coursera_algo_part_1.queues.linked_list;

import com.dsa.coursera_algo_part_1.queues.Queue;

/*
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

 */
public class LinkedListBasedQueue<T> implements Queue<T> {

    private Node<T> root;
    private Node<T> lastNode;

    @Override
    public void enqueue(T data) {
        Node<T> temp = lastNode;
        lastNode = new Node<>(data);
        if (isEmpty()) {
            root = lastNode;

        } else {
            temp.next = lastNode;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = root;
        root = root.next;
        return temp.data;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void print() {
        Node<T> temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
