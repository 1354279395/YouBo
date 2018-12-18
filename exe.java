package com.src11yue.Test1120;

import java.util.Arrays;

public class exe {
    public static void main(String[] args) {
        int[] array={2,4,78,20,55,
                     92,83,5,40,10,
                     72,25,10,0,1};
        sheellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shell(int[] array,int gap){
        for (int i = gap; i <array.length ; i++) {
            int j=0;
            int data=array[i];
            for (j = i-gap; j >=0 ; j-=gap) {
                if(array[j]>data){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=data;
        }
    }
    public static void sheellSort(int[] array){
        int[] drr={5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
            System.out.println(Arrays.toString(array));
        }
    }
}
