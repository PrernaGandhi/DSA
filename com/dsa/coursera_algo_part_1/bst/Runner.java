package com.dsa.coursera_algo_part_1.bst;

public class Runner {

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(4, "four");
        bst.put(1, "one");
        bst.put(3, "three");
        bst.put(5, "five");
        bst.put(2, "two");
        bst.print();

        System.out.println("key 3 : " + bst.get(3));
        System.out.println("key 5 : " + bst.get(5));
        System.out.println("key 6 : " + bst.get(6));
        bst.put(9, " nine");
        bst.put(7, " seven");
        bst.print();
        System.out.println("Min : " + bst.min());
        System.out.println("Max : " + bst.max());
        System.out.println("floor of 6 : " + bst.floor(6));
        System.out.println("floor of 5 : " + bst.floor(5));
        System.out.println("size of BST : " + bst.size());
        System.out.print("delete 4 ");
        bst.delete(4);
        System.out.println();
        bst.print();
        System.out.print("delete 7");
        bst.delete(7);
        System.out.println();
        bst.print();


    }

}
