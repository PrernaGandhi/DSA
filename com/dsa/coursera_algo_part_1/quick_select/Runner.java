package com.dsa.coursera_algo_part_1.quick_select;

public class Runner {

    public static void main(String[] args) {
        QuickSelect<Integer> select = new QuickSelect<>();
        Integer[] elements = {7, 10, 5, 3, 8, 4, 2, 9, 6};

        // 2    3   4	5	6	7	8	9	10
        Integer element = select.select(elements, 4);
        assert element == 5;

        QuickSelect<String> stringQuickSelect = new QuickSelect<>();
        String[] strings = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

        // A	E	E	L	M	O	P	R	S	T	X
        String string = stringQuickSelect.select(strings, 5);
        assert "M".equals(string);

    }
}
