package com.turbo;
//https://www.geeksforgeeks.org/atlassian-interview-experience/
//https://www.geeksforgeeks.org/level-ancestor-problem/
import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Main {
    private static int[] tree = {1,2,3,4,5,6,7,8,9,10};

    private static int[][] DP = new int[tree.length][10];

    public static void main(String[] args) {


        List<Integer> ancestors = new ArrayList<>();

        System.out.println("Enter your array elements");

        List<Pair<Integer, Integer>> Query = new ArrayList<>() ;
        Query.add(new Pair<>(6,0));


        solver(ancestors, 0);
        Query.forEach(query -> {
            System.out.println(DP[query.getKey()][query.getValue()]);
        });

    }

    public static void solver(List<Integer> ancestors, int currentIndex) {
        int pos = 0;

        for(int j = 0; j < ancestors.size(); j++) {
            int e = ancestors.get(j);
            DP[currentIndex][pos] = DP[e][pos] + tree[currentIndex];
            pos++;
        }

        while(pos<tree.length) {

            DP[currentIndex][pos] = tree[currentIndex];
            pos++;
        }
        if(ancestors.size() == 10) {
            ancestors.remove(9);
        }

        int leftChild = 2*currentIndex + 1;
        int rightChild = 2*currentIndex + 2;
        if(leftChild < tree.length) {
            ancestors.add(0, currentIndex);
            solver(ancestors, leftChild);
            ancestors.remove(0);
        }
        if(rightChild < tree.length) {
            ancestors.add(0, currentIndex);
            solver(ancestors, rightChild);
            ancestors.remove(0);
        }
    }
}
