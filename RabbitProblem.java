import java.util.Scanner;

public class RabbitProblem {

    public static long rabbitCount(int month) {
        if (month == 0) return 0;
        if (month == 1) return 1;

        long a = 0;
        long b = 1;
        long c;

        for (int i = 2; i <= month; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of months: ");
        int month = sc.nextInt();
        System.out.println("Number of rabbits: " + rabbitCount(month));
    }
}
