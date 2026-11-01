import java.util.*;

public class parenthesis {
    public void backtrack(List<String>ans,String current,int open,int close,int n){

        if(current.length()==2*n){
            ans.add(current);
        }
        if(open<n){
            backtrack(ans,current+"(",open+1,close,n);

        }
        if (close < open) {
            backtrack(ans, current + ")", open, close + 1, n);
        }
    }
    public static void main(String[] args) {
        parenthesis solver = new parenthesis();
        
        int n = 3; // Number of pairs of parentheses
        List<String> result = new ArrayList<>();
        
        // Initialize the backtracking process
        solver.backtrack(result, "", 0, 0, n);
        
        // Print the output
        System.out.println("All valid combinations for n = " + n + ":");
        System.out.println(result);
    }
}
