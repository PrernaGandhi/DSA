package com.dsa.coursera_algo_part_1.bst;

import com.dsa.coursera_algo_part_1.symbol_tables.SymbolTable;

public class Runner {

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(4, "four");
        bst.put(1, "one");
        bst.put(3, "three");
        bst.put(5, "five");
        bst.put(2, "two");
        bst.print();

        System.out.println("key 3 :" + bst.get(3));
        System.out.println("key 5 :" + bst.get(5));
        System.out.println("key 6 :" + bst.get(6));


    }

}
