package com.dsa.divide_and_conquer.algorithms.closest_points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPoints {

    private List<Point> points;

    public ClosestPoints(List<Point> points) {
        this.points = points;
    }

    public double solveProblem() {
        List<Point> sortedXPoints = new ArrayList<>();
        List<Point> sortedYPoints = new ArrayList<>();

        for (Point point : this.points) {
            sortedXPoints.add(point);
            sortedYPoints.add(point);
        }

        Collections.sort(sortedXPoints, new XSorter());
        Collections.sort(sortedYPoints, new YSorter());

        return findClosestPoint(sortedXPoints, sortedYPoints, this.points.size());
    }

    private double findClosestPoint(List<Point> sortedXPoints, List<Point> sortedYPoints, int noOfPoints) {

        // base case
        if( noOfPoints <= 3)
            return bruteforceApproach(sortedXPoints);
        int middleIndex = noOfPoints / 2;
        Point middlePoint = sortedXPoints.get(middleIndex);

        // DIVIDE PHASE
        // we keep on dividing the dataset into left and right sub-arrays
        List<Point> leftSubArrayX = new ArrayList<>();
        List<Point> rightSubArrayX = new ArrayList<>();

        // put values in valid list
        for(int index = 0; index < this.points.size(); index++) {
            Point point = sortedXPoints.get(index);
            if(point.getX() <= middlePoint.getX()) {
                leftSubArrayX.add(point);
            } else {
                rightSubArrayX.add(point);
            }
        }


        double deltaLeft = findClosestPoint(leftSubArrayX, sortedYPoints, middleIndex);
        double deltaRight = findClosestPoint(rightSubArrayX, sortedYPoints, noOfPoints - middleIndex);

        double delta = Math.min(deltaLeft, deltaRight);

        List<Point> pointsInStrip = new ArrayList<>();

        // linear search to find elements that fall in the strip
        for(int index = 0; index < points.size(); index++) {
            if(Math.abs(sortedYPoints.get(index).getX() - middlePoint.getX()) < delta) {
                pointsInStrip.add(sortedYPoints.get(index));
            }
        }

        double minDistanceInStrip = findMinimumDistanceInStrip(pointsInStrip, delta);


        return Math.min(minDistanceInStrip, delta);
    }

    private double findMinimumDistanceInStrip(List<Point> pointsInStrip, double delta) {

        double minDistance = delta;
        // consider all points in the strip
        // this is O(N)running time complexity
        for (int i = 0; i < pointsInStrip.size(); i++) {
            // it will run in O(1) constant running time (at most 16 iterations)
            for (int j = i + 1; j < pointsInStrip.size() &&
                    (pointsInStrip.get(j).getY() - pointsInStrip.get(i).getY() < minDistance); j++) {
                minDistance = distance(pointsInStrip.get(i), points.get(j));
            }
        }
        return minDistance;
    }

    private double bruteforceApproach(List<Point> points) {
        // this approach has O(N*N) running time complexity
        double minDistance = Double.MAX_VALUE;

        for(int i = 0; i < points.size() - 1; i ++) {
            for(int j = i + 1; j< points.size() ; j++) {
                double actualDistance = distance(points.get(i), points.get(j));

                if(actualDistance < minDistance) {
                    minDistance = actualDistance;
                }
            }
        }
        return minDistance;
    }

    private double distance(Point point1, Point point2) {
        double xDistance = point1.getX() - point2.getX();
        double yDistance = point1.getY() - point2.getY();
        return Math.sqrt(xDistance*xDistance + yDistance*yDistance);
    }
}
