package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // exampleOne(in);
        exampleTwo(in);
        in.close();
    }

    private static void exampleTwo(Scanner in) {

        System.out.print("Please enter a number: ");
        // double num = in.nextDouble();

        // use nextLine ALWAYS and parse into th required type
        double num = Double.parseDouble((in.nextLine()));
        double result = Math.pow(num, 2);

        System.out.println(result);
    }

    private static void exampleOne(Scanner in) {

        System.out.print("Please enter your name: ");
        String name = in.nextLine();

        System.out.println("Hello " + name);

    }
}
