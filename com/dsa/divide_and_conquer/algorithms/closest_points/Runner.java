package com.dsa.divide_and_conquer.algorithms.closest_points;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(2, 3),
                new Point(3, 3),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        );
        points = Arrays.asList(
                new Point(2.5, 3),
                new Point(3, 3),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        );

        ClosestPoints closestPoints = new ClosestPoints(points);
        System.out.println(closestPoints.solveProblem());
    }
}
