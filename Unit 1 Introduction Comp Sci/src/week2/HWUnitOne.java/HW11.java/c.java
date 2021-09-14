package week2.HW11.java;

/**
 * System.out.println ((x-y) - (y-x) - (x-y) - (y-x));
 */
public class c {
    public static void main(String[] args) {
        double x = 5.5, y = 3.0, z = -2.0;
        int i = 5, j = 4, k = 3;

        System.out.println((x - y) - (y - x) - (x - y) - (y - x));

        double c = x - y;
        double a = y - x;

        System.out.println(c - a - c - a);

    }
}
