package com.turbo;

import java.io.*;
import java.util.*;

public class Main {

    static char[] str = {'b', 'c', 'a'};

    public static void swap(int index ){
        int swapWith = index+1;

        for (int i = str.length-1; i>index; i--){
           if(str[index]<str[i] && str[swapWith]>str[i] ){
               swapWith = i;
           }
        }

        char temp = str[index];
        str[index] = str[swapWith];
        str[swapWith] = temp;
    }

    public static void main(String[] args) {
        for (int i = str.length-1; i>0; i--){
            if(str[i-1]< str[i]){
               swap(i-1 );
               Arrays.sort(str,i, str.length);
               break;
            }
        }

        System.out.println(str);
    }
}
