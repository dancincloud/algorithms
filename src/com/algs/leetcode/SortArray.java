package com.algs.leetcode;

public class SortArray {
    private static void merge(int[] arr, int start, int end){
        if(start >= end) return;

        int mid = start + (end - start) / 2;

        merge(arr, start, mid);
        merge(arr, mid + 1, end);

        int[] tmp = new int[end - start + 1];

        System.out.printf("start = %d, end = %d\n", start, end);


        int index = 0, l = start, r = mid + 1;
        while(index < tmp.length){
            while(l <= mid && (r > end || arr[l] <= arr[r])){
                System.out.printf("o = %d, tmp = %d\n", l, index);
                tmp[index] = arr[l];
                index++;
                l++;
            }

            while(r <= end && (l > mid || arr[r] <= arr[l])){
                System.out.printf("o = %d, tmp = %d\n", r, index);
                tmp[index] = arr[r];
                index++;
                r++;
            }
        }

        System.arraycopy(tmp, 0, arr, start, tmp.length);
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,4,5,1,9,1,3};
        merge(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
