package com.dsa.coursera_algo_part_1.convex_hull;

import java.util.Stack;

public class Runner {

    public static void main(String[] args) {
        Point2D[] points = {
            new Point2D(0, 3),
            new Point2D(1, 1),
            new Point2D(2, 2),
            new Point2D(4, 4),
            new Point2D(0, 0),
            new Point2D(1, 2),
            new Point2D(3, 1),
            new Point2D(3, 3)
        };

        ConvexHull convexHull = new ConvexHull();
        Stack<Point2D> point2DStack = convexHull.solve(points);
        convexHull.print(point2DStack);

    }

}
