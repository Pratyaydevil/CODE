import java.util.*;

class Main
{
    public static void Binary(int n)
    {
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for(int i = 1; i <= n; i++)
        {
            String current = q.poll();

            System.out.print(current);

            if(i != n)
                System.out.print(" ");

            q.add(current + "0");
            q.add(current + "1");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Binary(n);
    }
}