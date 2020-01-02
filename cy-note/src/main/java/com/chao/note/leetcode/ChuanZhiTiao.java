package com.chao.note.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 15313 on 2019/12/31.
 */
public class ChuanZhiTiao {

     /**
      * @Author Chao
      * @Description  题目描述
        小渊和小轩是好朋友也是同班同学，他们在一起总有谈不完的话题。一次素质拓展活动中，
        班上同学安排做成一个mm行nn列的矩阵，而小渊和小轩被安排在矩阵对角线的两端，
        因此，他们就无法直接交谈了。幸运的是，他们可以通过传纸条来进行交流。纸条要经由许多同学传到对方手里，
        小渊坐在矩阵的左上角，坐标(1,1(1,1)，小轩坐在矩阵的右下角，坐标(m,n)(m,n)。

        从小渊传到小轩的纸条只可以向下或者向右传递，从小轩传给小渊的纸条只可以向上或者向左传递。在活动进行中，
        小渊希望给小轩传递一张纸条，同时希望小轩给他回复。班里每个同学都可以帮他们传递，但只会帮他们一次，
        也就是说如果此人在小渊递给小轩纸条的时候帮忙，那么在小轩递给小渊的时候就不会再帮忙。反之亦然。

        还有一件事情需要注意，全班每个同学愿意帮忙的好感度有高有低（注意：小渊和小轩的好心程度没有定义，
        输入时用00表示），可以用一个0-1000−100的自然数来表示，数越大表示越好心。小渊和小轩希望尽可能找好心
        程度高的同学来帮忙传纸条，即找到来回两条传递路径，使得这22条路径上同学的好心程度之和最大。
        现在，请你帮助小渊和小轩找到这样的22条路径。

      * @Date  2019/12/31
      */

    public static void main(String[] args) {
        int n = 5 , m = 5;
        int[][] arr = new int[n][m];

        init(arr);
        int sum = 0;
        sum = getBeginToEndXY(sum , arr,0, 0) + getEndToBeginXY(sum , arr,arr.length-1, arr[0].length-1);
//        getEndToBeginXY(arr,arr.length-1, arr[0].length-1);

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("sum = " + sum);

    }


    private static void init(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j] = new Random().nextInt(100);
            }
        }

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }


    private static int getBeginToEndXY(int sum , int[][] arr, int x , int y){
        if (y==arr[0].length-1){
            sum += arr[x+1][y];
            arr[x+1][y] = -1;
            x++;
        }else if (x==arr.length-1 || arr[x][y+1] >= arr[x+1][y]){
            sum += arr[x][y+1];
            arr[x][y+1] = -1;
            y++;
        }else {
            sum += arr[x+1][y];
            arr[x+1][y] = -1;
            x++;
        }

        if (!((x==arr.length-1 && y==arr[0].length-2) || (x==arr.length-2 && y==arr[0].length-1))){
            sum = getBeginToEndXY(sum,arr,x, y);
        }
        return sum;
    }


    private static int getEndToBeginXY(int sum , int[][] arr,int x , int y) {
        if (y<=0){
            if (arr[x-1][y] != -1){
                sum += arr[x-1][y];
                arr[x-1][y] = -2;
                x--;
            }else {
                x = -3;
                y = -3;
                System.out.println("信传递不回去");
            }
        }else if (arr[x][y-1] != -1 && ( x<=0 || arr[x][y-1] >= arr[x-1][y]) ){
            sum += arr[x][y-1];
            arr[x][y-1] = -2;
            y--;
        }else if (x>0 &&  arr[x-1][y] != -1 && arr[x][y-1] < arr[x-1][y]){
            sum += arr[x-1][y];
            arr[x-1][y] = -2;
            x--;
        }else {
            x = -3;
            y = -3;
            System.out.println("信传递不回去");
        }

        if ((x>=0&&y>=0) && !((x==0&&y==1) || (x==1&&y==0)) ){
           sum = getEndToBeginXY(sum,arr,x, y);
        }
        return sum;
    }

}
