package com.algs.leetcode;

import java.util.*;

class MedianFinder {
    LinkedList<Integer> list;
    Boolean isEven;
    int count;

    /** initialize your data structure here. */
    public MedianFinder() {
        isEven = true;
        count = -1;
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        isEven = !isEven;

        list.addLast(num);

        count++;

        if(count == 2){
            list.removeFirst();
            count = 0;
        }
    }

    public double findMedian() {
        if(isEven){
            if(list.isEmpty()) return 0;
            else return (list.get(0) + list.get(1)) / 2.0;
        }else{
            return list.get(0);
        }
    }

    public static void main(String[] args){
        MedianFinder finder = new MedianFinder();
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(10);
        System.out.println(finder.findMedian());
        finder.addNum(2);

        System.out.println(finder.findMedian());
    }
}
