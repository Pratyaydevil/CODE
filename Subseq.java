import java.util.*;

class Subseq
{
    static HashSet<String> set1 = new HashSet<>();
    static HashSet<String> set2 = new HashSet<>();

    // Generate subsequences
    static void generate(String s, int index, String curr, HashSet<String> set)
    {
        if(index == s.length())
        {
            if(curr.length() > 0)
            {
                set.add(curr);
            }
            return;
        }

        // Include character
        generate(s, index + 1, curr + s.charAt(index), set);

        // Exclude character
        generate(s, index + 1, curr, set);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        generate(s1, 0, "", set1);
        generate(s2, 0, "", set2);

        int count = 0;

        for(String str : set1)
        {
            if(set2.contains(str))
            {
                count++;
            }
        }

        System.out.print(count);
    }
}
