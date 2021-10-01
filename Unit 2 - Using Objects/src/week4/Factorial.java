package week4;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(7));
        System.out.println(fib(6));
    }

    // 7! = 7 x 6 x 5 x 4 x 3 x 2 x 1
    // 7! = 7 x 6!

    // factorial(7) = 7 x factorial(6)

    public static int factorial(int i) {
        int n = 7;
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);

        }
    }

    /**
     * 
     * @param n
     * @return returns the nth number in the sequence
     */

    // 1, 1, 2, 3, 5, 8
    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }
}
