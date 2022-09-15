package com.dsa.coursera_algo_part_1.symbol_tables;

public class Runner {

    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        symbolTable.put(4, "four");
        symbolTable.put(1, "one");
        symbolTable.put(3, "three");
        symbolTable.put(5, "five");
        symbolTable.put(2, "two");
        symbolTable.print();

        System.out.println("key 3 :" + symbolTable.get(3));
        System.out.println("key 5 :" + symbolTable.get(5));
        System.out.println("key 6 :" + symbolTable.get(6));

    }

}
