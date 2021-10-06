package week6;

public class ComparingObjects {
    public static void main(String[] args) {
        // to compare Strings(ANY Object) we should use the equals method (.equals)

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "hello";
        String str4 = str1;

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));

        // equals methods deines how a class comapres two instance of an object for
        // quality

        String s1 = "ABCD";
        String s2 = "BCD";
        String s3 = "AACD";

        System.out.println("a".compareTo("g"));

    }
}
