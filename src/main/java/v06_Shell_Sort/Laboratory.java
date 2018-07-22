package v06_Shell_Sort;

public class Laboratory {

    public static void main(String args[]) {
        int N = 20000;
        Integer[] arr = SortTestSupporter.generateRandomArr(N, 0, N);
        Integer[] arr2 = new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
            arr2[i] = arr[i];
        Integer[] arr3 = new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
            arr3[i] = arr[i];

        SortTestSupporter.testPerformance("v06_Shell_Sort.SelectionSort", arr);
        SortTestSupporter.testPerformance("v06_Shell_Sort.InsertionSort", arr2);
        SortTestSupporter.testPerformance("v06_Shell_Sort.ShellSort", arr3);
        return;
    }
}
