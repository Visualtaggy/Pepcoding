import java.util.*;

// 1. You are given a number x.
// 2. You are given another number n.
// 3. You are required to calculate x raised to the power n. Don't change the signature of power function.

// Note1 -> The previous version expects the call stack to be of n height. This function expects call function to be only log(n) high.

// Note2 -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

public record PowerLog() {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Number: ");
        int number = scn.nextInt();
        System.out.print("Power: ");
        int power = scn.nextInt();

        System.out.println(power(number, power));
        scn.close();
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int a = power(x, n / 2);
        int b = a * a;

        if (n % 2 == 1) {
            b *= x;
        }
        return (b);

    }
}