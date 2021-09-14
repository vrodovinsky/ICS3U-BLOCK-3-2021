package week2;

/**
 * write a program that given the number of pennies, nickles, dimes, quarters,
 * loonies and toonies calculates how much money a user has
 */
public class HW9 {
    public static void main(String[] args) {
        double p = 0.01;
        double n = 0.05;
        double d = 0.10;
        double q = 0.25;
        double l = 1;
        double t = 2;
        double m;

        m = (3 * p) + (2 * n) + (5 * d) + (1 * q) + (7 * l) + (4 * t);
        System.out.println(m);
    }
}
