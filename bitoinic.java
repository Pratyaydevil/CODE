import java.util.*;



public class bitoinic {

    static int[]LIS(int[]arr){

        int n=arr.length;
        int[]lis=new int[n];
        for(int i=0;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){

                if(arr[i]>arr[j]&&lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
          
                }
            }
        }
        return lis;
    }
    

    static int[]LDS(int[]arr){

        int n=arr.length;
        int[]lds=new int[n];
        for(int i=n-1;i>=0;i--){
            lds[i]=1;
            for(int j=n-1;j>i;j--){

                if(arr[i]>arr[j]&&lds[i]<lds[j]+1){
                    lds[i]=lds[j]+1;

                }
            }
        }
        return lds;
    }


    static int longestBitonic(int[]arr){
        int n=arr.length;
        int[]lis=LIS(arr);
        int[]lds=LDS(arr);

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, lis[i]+lds[i]-1);
        }
        return max;
    }

     
}
