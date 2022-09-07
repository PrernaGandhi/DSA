package com.dsa.coursera_algo_part_1.stacks.linked_list;

import com.dsa.coursera_algo_part_1.stacks.Stack;

/*
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
 */
public class LinkedListBasedStack<T> implements Stack<T> {

    private Node<T> root;

    @Override
    public void push(T data) {
        Node<T> newRootNode = new Node<>(data);
        newRootNode.next = root;
        root = newRootNode;
    }

    @Override
    public T pop() {
        Node<T> removedNode = root.next;
        root = root.next;
        return removedNode != null ? removedNode.data : null;
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

    @Override
    public T top() {
        return root != null ? root.data : null;
    }


}
