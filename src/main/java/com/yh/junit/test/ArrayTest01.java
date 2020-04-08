package com.yh.junit.test;

import org.junit.Test;

public class ArrayTest01 {
    public static void main(String[] args) {

    }

    public boolean Find(int target, int [][] arr) {
        //input check
        if(arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0){
            return false;
        }
        int i = 0, j = arr[0].length - 1;
        while(i != arr.length - 1 && j != 0){
            if(target > arr[i][j]){
                i++;
            }else if(target < arr[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return target == arr[i][j];
    }
}
