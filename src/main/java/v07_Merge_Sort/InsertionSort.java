package v07_Merge_Sort;

public class InsertionSort {

    //No instance
    private InsertionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
// Grammar 1
//        for(int i=0;i<n;i++){
//            for(int j=i;j>0;j--)
//                if(arr[j].compareTo(arr[j-1])<0)
//                    swap(arr,i,j);
//        }

        // Grammar2:
        for(int i=0;i<n;i++){
            for(int j=i;j > 0 && arr[j].compareTo(arr[j-1]) < 0;j--)
                swap(arr , j ,j-1);
        }
    }

    // @method swap:  Exchange two elements
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
