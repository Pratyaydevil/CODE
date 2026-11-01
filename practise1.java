import java.util.*;


class practise1{


    static void printArray(int[]A,int n){

        for(int i=0;i<n;i++){

            System.out.print(A[i]+" ");
        }
    }

    static int partition(int []A,int low,int high){

int pivot=A[low];
int i=low+1;
int j=high;
int temp;

do{
    while(i<=high&&A[i]<=pivot){
        i++;
    }
    while(j>=low&&A[j]>pivot){
        j--;
    }
    if(i<j){
        temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}while(i<j);

temp=A[low];
A[low]=A[j];
A[j]=temp;

return j;


    }


    static void quickSort(int []A,int low,int high){

        if(low<high){

            int partitionIndex=partition(A,low,high);
            quickSort(A,low,partitionIndex-1);
            quickSort(A,partitionIndex+1,high);
        }
    }

    public static void main(String[]args){
int[] A = {9, 4, 4, 8, 7, 5, 6};
        int n = A.length;

        System.out.println("Before sorting:");
        printArray(A, n);

        quickSort(A, 0, n - 1);

        System.out.println("After sorting:");
        printArray(A, n);

    }
}