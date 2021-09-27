package week3;

public class ExtraPractice {
    public static void main(String[] args) {
        questionOne();
        questionTwo();
        questionThree();
        questionFour(1, 10);
        System.out.println(questionFive("This is a Sentence"));
        System.out.println(questionSix("This is a Sentence", "ent"));
        questionSeven("Hello", "World");
        double slope = questionEight(2, 1, 4, 5);
        questionNine(3.5, 2.2);
        System.out.println(questionTen("This is a sentence."));
    }

    /**
     * Obtains and displays an interger between 1 and 100
     */
    {
    }

    public static void questionOne() {
        int num = (int) (Math.random() * 100) + 1;
        // (int)(Math.random()*numPossibilities) + start

        System.out.println(num);

    }

    /**
     * Obtain and display an integer between -50 and 50
     */
    public static void questionTwo() {
        int num = (int) (Math.random() * 101) - 50;

        System.out.println(num);
    }

    /**
     * Simulate the roll of a die by obtaining and returning an integer from 1 to 6
     */
    public static void questionThree() {
        int num = (int) (Math.random() * 6) + 1;

        System.out.println(num);
    }

    /**
     * Create a function that accepts 2 ints (smaller and bigger) and return a
     * random integer between those two numbers inclusive.
     */
    public static void questionFour(int one, int two) {

        int num = (int) (Math.random() * two) + one;

        System.out.println(num);
    }

    /**
     * Create a function that accepts a String and returns a substring with the
     * first "e" removed.
     */
    public static String questionFive(String str) {
        int index = str.indexOf("e");
        String word = str.substring(0, index) + str.substring(index + 1);

        return word;

    }

    /**
     * Create a function that accepts a String and a substring and then returns a
     * String with the second string removed from the first String.
     */
    public static String questionSix(String str, String substr) {
        int index = str.indexOf(substr);
        String first = str.substring(0, index);
        String last = str.substring(index + substr.length());

        return first + last;

    }

    /**
     * Create a function that accepts two Strings and returns the length of the two
     * strings added together.
     */
    public static void questionSeven(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();

        int length = s1 + s2;
        System.out.println(length);

    }

    /**
     * Create a function that takes 4 integers (x1,y1, x2,y2) and returns the slope
     * of the line connecting those two points.
     */
    public static double questionEight(int x1, int y1, int x2, int y2) {
        int deltaY = y2 - y1;
        int deltaX = x2 - x1;

        double slope = (double) deltaY / deltaX;
        return slope;

    }

    /**
     * Create a function that can be used to calculate the volume of a cylinder.
     * Radius and Height are the parameters for the function.
     */
    public static void questionNine(double radius, double height) {
        double volume = Math.PI * Math.pow(radius, 2) * height;

        System.out.println(volume);
    }

    /**
     * Create a function that removes a random characters from a String and returns
     * the new string.
     */
    public static String questionTen(String str) {
        int index = (int) (Math.random() * str.length());
        String first = str.substring(0, index);
        String last = str.substring(index + 1);

        return first + last;

    }

}