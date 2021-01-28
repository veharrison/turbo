package com.turbo;

import java.io.*;
import java.util.*;

public class Main {

   static Integer D = 39;
   static Integer T = 39;
   static Integer N = 40;
   static long[][][] DP = new long[N][N][2];

    /**
     *
     * @param c    previous character
     * @param count counter for same string added
     * @param depth length of string traversed
     * @return
     */
    public static Long solver(char c, int count, int depth){
        if(depth == N){
            return 1l;
        }
        if(DP[count][depth][c-'0'] != -1){
            return DP[count][depth][c-'0'];
        }

        long left = 0;
        long right = 0;

        if(c=='0'){
            left = D>count+1 ? solver(c, count+1, depth+1) : 0;
            right = solver('1', 1, depth+1);
        }

        if(c == '1') {
            left = solver('0', 1, depth+1);
            right = T>count+1 ? solver(c, count+1, depth+1) : 0;
        }

        DP[count][depth][c-'0'] = left + right;

        return DP[count][depth][c-'0'];
    }

    public static void init(){
        for (int i = 0 ; i<DP.length ; i++){
            for (int j = 0 ; j<DP[i].length ; j++) {
                for (int k = 0 ; k<DP[i][j].length ; k++) {
                    DP[i][j][k] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        init();

        long left = 0 ;
        long right = 0 ;

        left = solver('0', 1, 1 );
        right = solver('1', 1, 1);

        System.out.println(left+right);
    }

}
