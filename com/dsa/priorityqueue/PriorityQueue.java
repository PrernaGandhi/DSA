package com.dsa.priorityqueue;

import java.util.ArrayList;
import java.util.List;

/*
        Min priority queue - minimum element at the top


        i
       / \
    2i+1 2i+2

        Example :
                    10
                  /    \
                20      30
              /   \    /
            40    50  60


            Insert(25)

                    10
                  /    \
                20      30
              /   \    /  \
            40    50  60   25

        compare if parent of 25,i.e, 30 is < 25, no
        so swap 30 and 25
                    10
                  /    \
                20      25
              /   \    /  \
            40    50  60   30

        compare if parent of 25,i.e, 10 is < 25, yes
        do nothing
                    10
                  /    \
                20      25
              /   \    /  \
            40    50  60   30



            Delete Min -> 10
        Swap last and first element
                    30
                  /    \
                20      25
              /   \    /  \
            40    50  60   10

        Remove 10
                    30
                  /    \
                20      25
              /   \    /
            40    50  60

        Now check if 30 is less than it's children, 20 and 25, no
        swap 20 and 30

                    20
                  /    \
                30      25
              /   \    /
            40    50  60

        Now check if 30 is less than it's children, 40 and 50, yes
        do nothing

                    20
                  /    \
                30      25
              /   \    /
            40    50  60

 */
public class PriorityQueue {
    List<Integer> items;

    public PriorityQueue() {
        this.items = new ArrayList<>();
    }

    boolean isEmpty() {
        return items.isEmpty();
    }

    int getSize() {
        return items.size();
    }

    int getMin() {
        if (isEmpty()) {
            return -1;
        }
        return items.get(0);
    }

    void insert(int data) {
        items.add(data);
        int childIndex = getSize() - 1;

        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (items.get(childIndex) < items.get(parentIndex)) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public void removeMin() {
        if (isEmpty()){
            return;
        }
        swap(0, items.size() - 1);
        items.remove(items.size() - 1);
        int parentIndex = 0;

        while (parentIndex < getSize()) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            if (leftChildIndex >= getSize() || rightChildIndex >= getSize() ||
                    items.get(parentIndex) < items.get(leftChildIndex) && items.get(parentIndex) < items.get(rightChildIndex)) {
                break;
            } else {
                int val = Math.min(items.get(leftChildIndex), items.get(rightChildIndex));
                if (val == items.get(leftChildIndex)) {
                    swap(leftChildIndex, parentIndex);
                    parentIndex = leftChildIndex;
                } else {
                    swap(rightChildIndex, parentIndex);
                    parentIndex = rightChildIndex;
                }
            }
        }

    }

    private void swap(int childIndex, int parentIndex) {
        int temp = items.get(childIndex);
        Integer element = items.get(parentIndex);
        items.remove(childIndex);
        items.add(childIndex, element);
        items.remove(parentIndex);
        items.add(parentIndex, temp);
    }

}
