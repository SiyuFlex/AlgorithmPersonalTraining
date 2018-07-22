package v01_SelectionSortKickOff;

public class SelectionSort {

    // #Constroctor
    private SelectionSort(){}

    private static void sort(int[] arr){
        int n = arr.length;

        // #Loop from min index
        for(int i=0;i<n;i++) {
            int minIndex = i;
            // Loop duration (i+1,n): target to find the min index
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }
            // Exchange element in arr[i] and the minIndex
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String args[]){
        int[] caseArr = {1,2,3,5,5,3,2,3,5,6,9,10};
        SelectionSort.sort(caseArr);
        for(int item: caseArr){
            System.out.println(item);
        }
    }
}
