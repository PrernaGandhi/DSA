package com.dsa.divide_and_conquer.algorithms.closest_points;

import java.util.Comparator;

public class YSorter implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.getY(), o2.getY());
    }
}
