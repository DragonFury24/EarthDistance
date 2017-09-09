import java.util.Scanner;
import java.util.InputMismatchException;

public class DistanceCalcMain {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double[] lats = new double[2];
        double[] longis = new double [2];
        /* suppose to allow user to input lat and long in degrees,minutes,seconds format. currently not implemented.
        double[] DMS = new double[3];
        double lat0 = 0, longi0 = 0, lat1 = 0, longi1 = 0;
        */
        String notation = null;
        double eRadius = 6371.01;

        while(notation == null) {
            System.out.println();
            System.out.println("Please choose the format you would like to input latitude/longitude in.");
            System.out.println();
            System.out.println("1. Degrees");
            //System.out.println("2. Degrees, Minutes, Seconds");

            int inputFormat = intInput(keyboard);

            switch (inputFormat) {
                case 1:
                    System.out.println(); //receives input for 1st latitude, longitude values
                    System.out.println("Please input the latitude in degrees with bearing separated by a comma.");
                    System.out.println("Use negative degrees for southern latitude");
                    lats[0] = dInput(keyboard);
                    System.out.println();
                    System.out.println("Please input the longitude in degrees with bearing separated by a comma.");
                    System.out.println("Use negative degrees for western longitude");
                    longis[0] = dInput(keyboard);

                    System.out.println(); //receives input for 2nd latitude, longitude values
                    System.out.println("Please input the second latitude in degrees with bearing separated by a comma.");
                    System.out.println("Use negative degrees for southern latitude");
                    lats[1] = dInput(keyboard);
                    System.out.println();
                    System.out.println("Please input the second longitude in degrees with bearing separated by a comma.");
                    System.out.println("Use negative degrees for western longitude");
                    longis[1] = dInput(keyboard);
                    notation = "degree";

                    for (int i = 0; i < lats.length; i++) { //converts latitude and longitude to radians
                        lats[i] = Math.toRadians(lats[i]);
                    }

                    for (int i = 0 ; i < longis.length; i++) {
                        longis[i] = Math.toRadians(longis[i]);
                    }
                    break;

                case 2: //suppose to allow user to input lat and long in degrees,minutes,seconds format. currently not implemented.

                default:
                    System.out.println("You didn't choose a valid format. Please try again.");
            }
        }

        switch (notation) {
            case "degree":
                System.out.println();
                System.out.println("Distance: " + eRadius * Math.acos(Math.sin(lats[0]) * Math.sin(lats[1]) + Math.cos(longis[0]) * Math.cos(longis[1]) * Math.cos(longis[1] - longis[0])));
                break;

            case "DMS": //suppose to allow user to input lat and long in degrees, minutes, seconds format. currently not implemented
                break;
        }
    }

    private static double dInput(Scanner keyboard) { //checks if input is a double. If not, then will give error and force user to retry
        double dOutput = 0;
        boolean noInput = true;
        while (noInput) {
            try {
                dOutput = keyboard.nextDouble();
                noInput = false;
            } catch (InputMismatchException I) {
                System.out.println("You did not input a number. Please try again.");
                keyboard.next();
            }
        }

        return dOutput;
    }

    private static int intInput(Scanner keyboard) { //checks if input is a int. If not, then will give error and force user to retry
        int iOutput = 0;
        boolean noInput = true;
        while (noInput) {
            try {
                iOutput = keyboard.nextInt();
                noInput = false;
            } catch (InputMismatchException I) {
                System.out.println("You did not input a number. Please try again.");
                keyboard.next();
            }
        }

        return iOutput;
    }
}