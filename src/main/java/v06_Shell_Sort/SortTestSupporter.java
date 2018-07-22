package v06_Shell_Sort;

import java.lang.reflect.Method;

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

    // @isSorted  Judgement an array is sorted or not
    public static boolean isSorted(Comparable[] arr){
        for(int i=0;i<arr.length - 1;i++)
            if(arr[i].compareTo(arr[i+1])>0)
                return false;
        return true;
    }

    // @testPerformance:  Test class performance by measure the running time
    public static void testPerformance(String className, Comparable[] arr){

        // Exceptions like (ClassNotFind)
        try{
            // Using reflection to initialize the sort class by parameter className
            Class sortClass = Class.forName(className);

            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);

            Object[] params = new Object[]{arr};

            long startMilestone = System.currentTimeMillis();
            //invoke sort method
            sortMethod.invoke(null,params);
            long endMilestone = System.currentTimeMillis();

            assert isSorted(arr);
            // Print performance data
            System.out.println(sortClass.getSimpleName()+" sorted in: "+(endMilestone-startMilestone)+"ms");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
