package com.dsa.coursera_algo_part_1.queues.iterators;

import com.dsa.coursera_algo_part_1.queues.linked_list.Node;
import java.util.Iterator;

public class LinkedListQueueIterator<T> implements Iterator<T> {

    private Node<T> current;

    public LinkedListQueueIterator(Node<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T node = current.data;
        current = current.next;
        return node;
    }
}
