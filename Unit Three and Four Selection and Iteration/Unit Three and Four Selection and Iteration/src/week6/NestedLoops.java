package week6;

public class NestedLoops {
    public static void main(String[] args) {
        exampleOne();
        framingSquares(1, 2, 3, 4);
        wordFrame("CANADA");
        diamonds("CANADA");
    }

    private static void diamonds(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            System.out.println(" ");
        }
        System.out.println(str.substring(0, 1));

        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < str.length() - 1; i++) {
                System.out.println(" ");
            }
            System.out.println(str.substring(i, i + 1));
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.println(" ");
            }
            System.out.println(str.substring(i, i + 1));
        }

        for (int i = str.length() - 2; i > 0; i--) {
            for (int j = 0; j < str.length() - 1; i++) {
                System.out.println(" ");
            }
            System.out.println(str.substring(i, i + 1));
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.println(" ");
            }
            System.out.println(str.substring(i, i + 1));

        }

        for (int i = 0; i < str.length() - 1; i++) {
            System.out.println(" ");
        }
        System.out.println(str.substring(0, 1));
    }

    private static void wordFrame(String str) {
        System.out.println("*" + str + "*");

        for (int i = 0; i < str.length(); i++) {
            String start = str.substring(i, i + 1);
            String end = str.substring(str.length() - i - 1, str.length() - i);

            System.out.println(end);
            for (int j = 0; j < str.length(); j++) {
                System.out.println("*");
            }
        }
        System.out.println("*");
        for (int i = str.length(); i >= 0; i--) {
            String letter = str.substring(i, i - 1);
            System.out.println("letter");
        }
        System.out.println("*");
    }

    private static void framingSquares(int M, int N, int P, int Q) {
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < 2 * P + 2 * Q + N; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < P; i++) {
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }

            for (int j = 0; j < 2 * P + N; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }

            for (int j = 0; j < P; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < N; j++) {
                System.out.print(".");
            }

            for (int j = 0; j < P; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < P; i++) {
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }

            for (int j = 0; j < 2 * P + N; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < 2 * P + 2 * Q + N; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void exampleOne() {

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%5d", (i * j));
            }
            System.out.println();
        }
    }
}
