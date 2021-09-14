package week2;

/**
 * Create a program that obtains two integers, one for the amount of test is out
 * of and another indicating what a student received. Display what percentage
 * the student received on the test.
 */

public class HW2 {
    public static void main(String[] args) {
        int totalMarks = 20;
        int studentMarks = 15;

        double prcnt = (double) studentMarks / totalMarks;

        System.out.println("The student received " + (prcnt * 100) + "%");

    }
}
