import java.util.*;

class hypen{

    public static void main(String[]args){
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter a string: ");

        String str=sc.nextLine();

         String withoutHyphen = str.replace("-", "");

          int count = str.length() - withoutHyphen.length();
          String result = "-".repeat(count) + withoutHyphen;

        System.out.println("Result: " + result);

        sc.close();

    }
}