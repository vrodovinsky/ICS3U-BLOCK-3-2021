package week2;

/**
 * Write a program that uses a five digit number and calculates the product of
 * the 2nd and 4th digit. Use the modulus and division operators.
 */
public class HW3 {
    public static void main(String[] args) {
        int num = 12345;

        int num2 = num / 1000 % 10;
        int num4 = num / 10 % 10;

    }
}
