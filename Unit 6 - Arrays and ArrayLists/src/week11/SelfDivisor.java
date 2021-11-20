package week11;

public class SelfDivisor {

    public static boolean isSelfDivisor(int num) {
        String temp = "" + num;
        for (int i = 0; i < temp.length(); i++) {
            int digit = Integer.parseInt(temp.substring(i, i + 1));
            if (num / digit != 0)
                return false;

            return true;
        }
    }

    public static int[] firstNumSelfDivisors(int start, int num) {
        int[] temp = new int[num];
        int i = 0;
        int count = 0;
        while (count < temp.length) {
            if (isSelfDivisor(start)) {
                temp[i] = start;
                count++;
            }
            i++;
            start++;

        }
        return temp;
    }
}
