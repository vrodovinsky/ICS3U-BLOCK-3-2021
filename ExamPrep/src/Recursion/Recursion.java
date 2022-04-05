package Recursion;

public class Recursion {
    public static void main(String[] args) {
        // System.out.println(factorial(7));
        System.out.println(fibonacci(6));
    }

    // in solving a problem we will solve a smaller version of the same problem
    // obtain the solution to n factorial
    public static int factorial(int n) {
        // 7! = 7 x 6 5 x 4 x 3 x 2 x 1 = 7 x 6!
        if (n == 1 || n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);

    }
}
