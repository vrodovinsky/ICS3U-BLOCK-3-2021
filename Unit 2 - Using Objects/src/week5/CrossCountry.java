package week5;

import java.util.Scanner;

/**
 * Calculates results for the team of 3 runners.
 */
public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    }

    /**
     * Gets the name and time from the runner. Finds the splits and prints out the
     * summary of the runner
     * 
     * @param in
     */
    private static void processRunner(Scanner in) {

        System.out.print("First name: ");
        String firstName = in.nextLine();
        System.out.print("Last name: ");
        String lastName = in.nextLine();
        System.out.print("Time to the first mile: ");
        String mileOne = in.nextLine();
        System.out.print("Time to the end of the second mile: ");
        String mileTwo = in.nextLine();
        System.out.print("Time to complete the 5 kms: ");
        String mileThree = in.nextLine();
        System.out.println("");

        String splitTwo = subtractTimes(mileTwo, mileOne);
        String splitThree = subtractTimes(mileThree, mileTwo);

        System.out.println("Summary for " + firstName + " " + lastName + ": ");
        System.out.println("Mile One:  " + mileOne);
        System.out.println("Mile Two: " + splitTwo);
        System.out.println("Mile Three: " + splitThree);
        System.out.println("");
    }

    /**
     * Takes two times as string in the format of mm:ss.sss and returns the
     * difference as a time string.
     * 
     * @param endTime
     * @param startTime
     * @return
     */
    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertToSeconds(endTime);
        double startInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endInSeconds - startInSeconds;

        return convertToTime(diffInSeconds);
    }

    /**
     * Takes diffInSeconds and converts to the format of mm:ss.sss
     * 
     * @param diffInSeconds
     * @return
     */
    private static String convertToTime(double diffInSeconds) {

        int min = getMinutes(diffInSeconds);
        double sec = getSeconds(diffInSeconds);

        return String.format("%d:%06.3f", min, sec);
    }

    /**
     * Takes seconds and returns the seconds
     * 
     * @param seconds
     * @return
     */
    private static double getSeconds(double seconds) {
        double sec = seconds % 60;
        sec = (sec * 1000d) / 1000d;

        return sec;
    }

    /**
     * Takes seconds and returns the minutes
     * 
     * @param seconds
     * @return
     */
    private static int getMinutes(double seconds) {
        return (int) (seconds / 60);

    }

    /**
     * Takes time and converts it to seconds, returning the total time
     * 
     * @param time
     * @return
     */
    private static double convertToSeconds(String time) {
        int colon = time.indexOf(":");

        String min = time.substring(0, colon);
        String sec = time.substring(colon + 1);

        int minToSeconds = Integer.parseInt(min);
        double seconds = Double.parseDouble(sec);

        return (double) minToSeconds * 60 + seconds;
    }
}
