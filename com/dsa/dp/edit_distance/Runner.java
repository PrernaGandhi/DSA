package com.dsa.dp.edit_distance;

public class Runner {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(editDistance.noOfSteps(s1, s2));
        s1 = "intention";
        s2 = "execution";
        System.out.println(editDistance.noOfSteps(s1, s2));
        s1 = "horse";
        s2 = "";
        System.out.println(editDistance.noOfSteps(s1, s2));
        s1 = "";
        s2 = "horse";
        System.out.println(editDistance.noOfSteps(s1, s2));
    }
}
