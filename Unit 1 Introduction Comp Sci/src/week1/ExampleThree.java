package week1;


/**
 * Escape Sequences
 */
public class ExampleThree {
    public static void main(String[] args) {
        System.out.println("This is \"very\" important!"); // compile error beause double quote encapsulate a String Literal and we added extra quotes
        
        System.out.println("This is \\very important!"); // escape the quote by creating an esxape sequence using \ 

        // AP cares about \" \n \l

        System.out.println("This\nis\nvery\nimportant!"); // \n is newline
    }
}
