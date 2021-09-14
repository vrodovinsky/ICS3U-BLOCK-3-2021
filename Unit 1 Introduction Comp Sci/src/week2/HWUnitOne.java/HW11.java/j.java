package week2.HW11.java;

/**
 * System.out.println((double) i / j- (double) (i / j));
 */

public class j {
    public static void main(String[] args) {
        double x = 5.5, y = 3.0, z = -2.0;
        int i = 5, j = 4, k = 3;

        System.out.println((double) i / j - (double) (i / j));

        double c = i / j;
        System.out.println((double) i / j - c);
    }
}
