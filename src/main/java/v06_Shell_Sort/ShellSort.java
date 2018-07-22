package v06_Shell_Sort;

public class ShellSort {

    public static void sort(Comparable[] arr){

        int n = arr.length;

        int h = n/2;

        while(h>1){
            for(int i=h;i<n;i++){
                Comparable e = arr[i];
                int j = i;
                for(;j>h && arr[j].compareTo(arr[h])>0;j-=h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }
            h/=2;
        }
    }
}
