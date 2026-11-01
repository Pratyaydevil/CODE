import java.util.*;





public class lcsclass {
    static int lcs(String x,String y){
          int m=x.length();
          int n=y.length();

          int[][]dp=new int[m+1][n+1];

          for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                     if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // match → extend subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // skip one
                }


                
            }
          }
            return dp[m][n];
    }

    static String getLCS(String x,String y){

     int m=x.length();
          int n=y.length();

          int[][]dp=new int[m+1][n+1];

          for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                     if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // match → extend subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // skip one
                }

            }
          }


          StringBuilder sb=new StringBuilder();
          int i=m,j=n;

          while(i>0&&j>0){


            if(x.charAt(i-1)==y.charAt(j-1)){

                sb.append(x.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
          }
          return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        System.out.println("Length of LCS: " + lcs(X, Y));
        System.out.println("LCS string: " + getLCS(X, Y));
    }
}
