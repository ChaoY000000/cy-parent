package com.chao.note.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by 15313 on 2019/12/13.
 */
public class SortUtils {


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(23);
        linkedList.add(46);
        linkedList.add(0);
        linkedList.add(8);
        linkedList.add(11);
        linkedList.add(18);

        quickSort(linkedList , 0 , 5);
        for (Object o : linkedList) {
            System.out.println(o);
        }
    }
    
     /**
      * @Author Chao
      * @Description  
      * @Date  2019/12/16
      * @Param 
      * @return 
      */
    public static void quickSort(LinkedList<Integer> list , int low , int high){
        int start = low;
        int end = high;
        int key = list.get(low);
        while (end > start){
            while (end>start && list.get(end)>=key){
                end--;
            }
            if (list.get(end)<=key){
                int temp = list.get(end);
                list.add(end,list.get(start));
                list.remove(end+1);
                list.add(start,temp);
                list.remove(start+1);
            }
            while (end>start && list.get(start) <= key){
                start++;
            }
            if (list.get(start)>=key){
                int temp = list.get(start);
                list.add(start,list.get(end));
                list.remove(start+1);
                list.add(end,temp);
                list.remove(end+1);
            }
        }

        if (start>low){
            quickSort(list,low,start-1);
        }
        if (end<high){
            quickSort(list,end+1,high);
        }
    }







}
