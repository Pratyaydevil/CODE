import java.util.*;

class celebrity {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Read number of people
        int N = sc.nextInt();

        // Read relationship matrix
        int[][] relationshipMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                relationshipMatrix[i][j] = sc.nextInt();
            }
        }

        // Find celebrity
        int celebrityId = new Solution().findCelebrity(relationshipMatrix, N);

        if (celebrityId != -1) {
            System.out.println("Celebrity id: " + celebrityId);
        } else {
            System.out.println("No Celebrity");
        }
    }
}
class solution{

    int findCelebrity(int M[][],int n){


        int candidate=0;

        for(int i=1;i<n;i++){

            if(M[candidate][i]==1){
                candidate=i;

            }
        }
          for (int i = 0; i < n; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1; // Not a celebrity
            }
        }

        return candidate; // 

    }
}
