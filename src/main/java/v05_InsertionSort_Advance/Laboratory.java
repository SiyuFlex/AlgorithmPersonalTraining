package v05_InsertionSort_Advance;

public class Laboratory {

    public static void main(String args[]) {
        int N = 20000;
        Integer[] arr = SortTestSupporter.generateRandomArr(N, 0, N);
        Integer[] arr2 = new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
            arr2[i] = arr[i];

        SortTestSupporter.testPerformance("v05_InsertionSort.SelectionSort", arr);
        SortTestSupporter.testPerformance("v05_InsertionSort.InsertionSort", arr2);
        return;
    }
}
