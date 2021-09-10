package week1;

/**
 * More fot eh same
 * Integer vs. Double math
 * Modulus Operator - remainder
 */
public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87;     // declared and initialized on the same line.

        double average = (markOne + markTwo + markThree) / 3;   // integer division 242/3 = 80 no decimal.

        // double average = (markOne + markTwo + markThree) / 3.0;     // integer division 242/3.0 = 80.66666666666667
        System.out.println("The average is: " + average);


        System.out.println(4/3);    //1
        System.out.println(4/3.0);  // 1.333
        System.out.println(3/4);    // 0
        System.out.println(3.0/4);  // 0.75
    }
}
