package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        quick_sort sol = new quick_sort();

        int[] a = {9,8,4,5,6,3,1,2,7,8,0};
        int[] answer = sol.quickSort(a);
        util.println(Arrays.toString(answer));
    }
    int[] quickSort(int[] a){
        int[] answer = Arrays.copyOf(a,a.length);
        int n = answer.length;
        quickSortHelper(answer,0,n-1);
        return answer;
    }
    void quickSortHelper(int[] a,int l, int r){
        if(l>=r)
            return;
        int mid = pivot(a,l,r);
        quickSortHelper(a,l,mid-1);
        quickSortHelper(a,mid+1,r);
    }
    int pivot(int[] a, int l, int r){
        int pivot = a[l];
        while(l<r){
            while(l<r && pivot<a[r]) r--;
            a[l] = a[r];
            while(l<r && a[l]<=pivot) l++;
            a[r] = a[l];
        }
        a[l] = pivot;
        return l;
    }
}
