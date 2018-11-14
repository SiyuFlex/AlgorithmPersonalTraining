package v07_Q_Merge_Sort_Advance;

import v07_Merge_Sort.InsertionSort;
import v07_Merge_Sort.SortTestSupporter;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    private static void sort(Comparable[] arr,int l,int r){
        if(r-l<=30){
            InsertionSort.sort(arr);
            return;
        }

        int mid = (l+r)/2;

        sort(arr,l,mid);
        sort(arr,mid+1,r);
        if(arr[mid+1].compareTo(arr[mid])<0)
            _merge(arr,l,mid,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void _merge(Comparable[] arr,int l ,int mid,int r){

        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        int i = l; int j = mid+1;
        for(int k=l;k<r;k++){
            if(i>mid) {
                arr[k] = aux[j-l];
                j++;
            }
            else if(j>r) {
                arr[k] = aux[i-l];
                i++;
            }
            else if(aux[j-l].compareTo(aux[i-l])<0) {
                arr[k] = aux[j-l];
                j++;
            }
            else{
                arr[k] = aux[i-l];
                i++;
            }
        }
    }

    public static void main(String args[]){
        int N = 1000000;
        Comparable[] testArr = SortTestSupporter.generateRandomArr(N,0,10000);
        SortTestSupporter.testPerformance("v07_Merge_Sort.MergeSort",testArr);
        return;
    }
}
