package com.dsa.coursera_algo_part_1.queues.resizing_arrays;

import com.dsa.coursera_algo_part_1.queues.Queue;

/*
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


 */
public class ArrayBasedQueue<T> implements Queue<T> {

    private T[] array;
    private int start;
    private int end;

    public ArrayBasedQueue() {
        this.array = (T[]) new Object[1];
        this.start = 0;
        this.end = 0;
    }

    @Override
    public void enqueue(T data) {
        if (this.start == this.end - 1 || (this.end == this.array.length && this.start == 0)) {
            resizeArray();
        } else if (this.end == this.array.length) {
            this.end = 0;
        }
        array[end] = data;
        end++;
    }

    private void resizeArray() {
        System.out.println("S : " + size());
        T[] copy = (T[])new Object[size()*2];
        int k = 0;
        if (start > end) {
            for (int i = start; i < array.length; i++) {
                copy[k] = this.array[i];
                k++;
            }
            for (int i = 0; i < end; i++) {
                copy[k] = this.array[i];
                k++;
            }
        } else {
            for (int i = start; i < end; i++) {
                copy[k] = this.array[i];
                k++;
            }
        }
        this.array = copy;
        this.start = 0;
        this.end = k;
    }

    private int size() {
        if (start == 0) {
            return array.length;
        }
        return array.length - start + end;
    }
    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T temp = this.array[start];
            if (size() == array.length/4) {
                resizeArray();
            }
            this.array[start] = null;
            start++;
            return temp;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void print() {
        if (start >= end) {

            for (int i = start; i < array.length; i++) {
                System.out.print(this.array[i] + " ");
            }
            for (int i = 0; i < end; i++) {
                System.out.print(this.array[i] + " ");
            }
        } else {
            for (int i = start; i < end; i++) {
                System.out.print(this.array[i] + " ");
            }
        }
        System.out.println();
    }
}
