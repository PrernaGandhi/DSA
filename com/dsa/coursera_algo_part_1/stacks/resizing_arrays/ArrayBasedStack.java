package com.dsa.coursera_algo_part_1.stacks.resizing_arrays;

import com.dsa.coursera_algo_part_1.stacks.Stack;

/*
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


 */
public class ArrayBasedStack<T> implements Stack<T> {

    private T[] array;
    private int size;

    public ArrayBasedStack() {
        this.array = (T[]) new Object[1];
        this.size = 0;
    }

    @Override
    public void push(T data) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = data;
        size++;

    }

    private void resizeArray() {
            T[] copy = (T[]) new Object[2 * size];
            for (int i = 0; i < size; i++)
                copy[i] = this.array[i];
            this.array = copy;
    }

    @Override
    public T pop() {
        if (size == array.length/4) {
            resizeArray();
        }
        T data = array[size - 1];
        array[size - 1] = null;
        size--;
        return data;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T top() {
        return array[size - 1];
    }
}
