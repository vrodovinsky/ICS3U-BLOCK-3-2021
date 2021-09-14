package week2;

/**
 * Given an equation in the format from question 7, Obtain the two roots.
 */
public class HW10 {
    public static void main(String[] args) {
        double xp;
        double xn;
        double a = 4;
        double b = 6;
        double c = 8;

        xp = -b + Math.sqrt((b * b) - (4 * a * c)) / (2 * a);
        xn = -b - Math.sqrt((b * b) - (4 * a * c)) / (2 * a);

    }
}
