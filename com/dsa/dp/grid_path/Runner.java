package com.dsa.dp.grid_path;

public class Runner {
    public static void main(String[] args) {
        GridPath gridPath = new GridPath();
        System.out.println(gridPath.countPaths(2, 4));
        System.out.println(gridPath.countPaths(2, 3));
        System.out.println(gridPath.countPaths(3, 3));
    }
}
