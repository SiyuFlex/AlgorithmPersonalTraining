package v05_InsertionSort;

import v03_SelectionSort_Using_RandomGenerate.SortTestSupporter;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] arr){

        int n = arr.length;
        // loop arrList
        for(int i=0;i<n;i++) {
            int minIndex = i;
            for(int j=i+1;j<n;j++)
                if(arr[minIndex].compareTo(arr[j])>0)
                    swap(arr,i,j);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String args[]){
        int N = 20000;

        // Test the usability of the support function
        Integer[] testArr = SortTestSupporter.generateRandomArr(N,1,100);
        sort(testArr);
        v05_InsertionSort.SortTestSupporter
                .testPerformance("v04_SelectionSort_Detect_Performance.SelectionSort",testArr);
    }
}
