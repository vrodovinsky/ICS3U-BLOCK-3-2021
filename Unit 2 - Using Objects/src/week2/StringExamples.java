package week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1 = "This is a String literal";
        String s2 = "This is a String literal";
        String s3 = new String("This is a String literal"); // it is not a String literal but a String object

        System.out.println(s1.length());

        System.out.println(s1.equals(s2));
        System.out.println(s1.indexOf("in"));

        String s4 = "0123456789";
        String s5 = "ABCDEFGHIJ";
        System.out.println(s4.substring(3));
        System.out.println(s5.substring(3, 7));

    }
}
