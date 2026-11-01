import java.io.*;
import java.util.*;

public class file {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 20) {
            System.out.println("Exceeding limit!");
            return;
        }

        PrintWriter pw = new PrintWriter("percentages.txt");

        for (int i = 0; i < n; i++) {
            double percentage = sc.nextDouble();
            int totalValue = sc.nextInt();

            pw.println(percentage + " " + totalValue);
        }

        pw.close();

        Scanner fileScanner = new Scanner(new File("percentages.txt"));

        while (fileScanner.hasNext()) {
            double percentage = fileScanner.nextDouble();
            int totalValue = fileScanner.nextInt();

            double calculatedValue = (percentage * totalValue) / 100.0;

            System.out.printf("%.2f%n", calculatedValue);
        }

        fileScanner.close();
    }
}