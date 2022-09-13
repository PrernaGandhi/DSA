package com.dsa.coursera_algo_part_1.convex_hull;

import java.util.Comparator;

public class Point2D {

    public static final Comparator<Point2D> BY_Y_COORDINATE = new ByYCoordinate();
    public final Comparator<Point2D> BY_POLAR_ANGLE = new ByPolarAngle();
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
                            B(x2,y2)
                                o
                             /    \
                           /       \
                         /          \
                        o ---------- o
                      C(x3,y3)      A(x1,y1)
        To find area of between 3 points

                    +   -   +
            1   |   x1  y1  1   |
           ---  |   x2  y2  1   |
            2   |   x3  y3  1   |

        solving this
         x1 * | y2 1 |  - y1 * | x2 1 |  + 1 * | x2 y2 |
              | y3 1 |         | x3 1 |        | x3 y3 |

         x1 * ((y2*1) - (y3*1))  - y1 * ((x2*1) - (x3*1)) + 1 * ((x2*y3) - (x3*y2))
         x1*y2 - x1*y3 - y1*x2 + y1*x3 + x2*y3 - x3*y2
         x1*y2 - x1*y3 - y1*x2 + y1*x3 + x2*y3 - x3*y2 - (x1*y1 + x1*y1 )
         x2*y3 - x2*y1 - x1*y3 - x1*y1 - (y2*x3 - y2*x1 - y1*x3 + y1*x1)
         (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)
     */
    public static int isCounterClockwise(Point2D a, Point2D b, Point2D c) {
        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area < 0) {
            return -1; // clockwise
        }
        if (area > 0) {
            return +1; // counter - clockwise
        }
        return 0; //collinear
    }

    @Override
    public String toString() {
        return "{" + x + "," + y + '}';
    }

    private static class ByYCoordinate implements Comparator<Point2D> {

        @Override
        public int compare(Point2D o1, Point2D o2) {
            return (int) (o1.y - o2.y);
        }
    }

    private class ByPolarAngle implements Comparator<Point2D> {

        @Override
        public int compare(Point2D o1, Point2D o2) {
            double dy1 = o1.y - y;
            double dy2 = o2.y - y;
            if (dy1 == 0 && dy2 == 0) {
                return 0;
            } else if (dy1 >= 0 && dy2 < 0) {
                return -1;
            } else if (dy2 >= 0 && dy1 < 0) {
                return +1;
            } else {
                return -isCounterClockwise(Point2D.this, o1, o2);
            }
        }
    }
}
