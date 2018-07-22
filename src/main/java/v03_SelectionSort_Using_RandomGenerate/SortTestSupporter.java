package v03_SelectionSort_Using_RandomGenerate;

public class SortTestSupporter {

    // Generate a int array with length n;
    public static Integer[] generateRandomArr(int n, int rangeL , int rangeR){

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for(int i=0;i<n;i++)
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1)+rangeL));

        return arr;
    }

    // Print all element in this array
    public static void printArray(Object arr[]){

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
