package main.java.v07_Q_Merge_Sort_Advance;

import java.util.Arrays;

public class MergeSortBottomUp {

    private MergeSortBottomUp(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int size = 1; size < n ; size*=2){
            for(int i = 0;i < n - size;i += size+size){
                if(arr[i+size].compareTo(arr[i+size-1])<0)
                    merge(arr,i,i+size-1,Math.min((i+2*size-1),(n-1)));
            }
        }
    }
}
