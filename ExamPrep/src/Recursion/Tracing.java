package Recursion;

import javax.lang.model.util.ElementScanner6;

public class Tracing {

    public int mystery1(int x, int y) {
        if (x < y)
            return x;
        else
            return mystery1(x - y, y);
    }

    public void mystery2(int n) {
        if (n <= 1)
            System.out.println(n);
        else
            mystery2(n / 2);
        System.out.println(", " + n);

    }

    public int mystery3(int n) {
        if (n < 0)
            return -mystery3(-n);
        else if (n < 10)
            return n;
        else
            return mystery3(n / 10 + n % 10);
    }

    public int mystery4(int n) {
        if (n < 0)
            return mystery4(-n);
        else if (n < 10)
            return n;
        else
            return n % 10 + mystery4(n / 10);
    }

    public int mystery5(int x, int y) {
        if (x < 0)
            return -mystery5(-x, y);
        else if (y < 0)
            return -mystery5(x, -y);
        return 100 * mystery5(x / 10, y / 10) + 10 * (x % 10) + (y % 10);
    }

    public void mystery6(int x, int y) {
        if (y == 1)
            System.out.print(x);
        else {
            System.out.print(x * y + ", ");
            mystery6(x, y - 1);
            System.out.print(", " + x * y);
        }

    }

    public void mystery7(int n) {
        if (n <= 0)
            System.out.print("*");
        else if (n % 2 == 0) {
            System.out.print("(");
            mystery7(n - 1);
            System.out.print(")");
        } else {
            System.out.print("[");
            mystery7(n - 1);
            System.out.println("]");
        }

    }

    public void mystery8(int n) {
        if (n > 100)
            System.out.print(n);
        else {
            mystery8(2 * n);
        }
    }
}


