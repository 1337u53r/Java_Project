import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class Accuracy extends Main {

    public void setAccuracy() {

        Functions functions = new Functions();

        boolean valid = false;

        while (!valid) {

            try {

                System.out.println("Choose a range between 1 to 5");
                System.out.print(">> ");
                ACCURACY = functions.getRawInputInteger();

                while (ACCURACY < 1 || ACCURACY > 5) {

                    try {

                        System.out.println("Choose a range between 1 to 5");
                        System.out.print(">> ");
                        ACCURACY = functions.getRawInputInteger();

                    } catch (InputMismatchException e) {

                        System.out.println("Value not in scope");
                        continue;

                    }

                }

                valid = true;

            } catch (InputMismatchException e) {

                System.out.println("Invalid number");
                continue;

            }

        }

    }

    public String roundToDecimalPlace(double result) {

        String accuracy = new String(new char[ACCURACY]).replace("\0", "0");
        DecimalFormat df = new DecimalFormat("0." + accuracy);

        switch (ACCURACY) {

            case 1:
                result = Math.round(result * 10) / 10.0;
                break;

            case 2:
                result = Math.round(result * 100) / 100.0;
                break;

            case 3:
                result = Math.round(result * 1000) / 1000.0;
                break;

            case 4:
                result = Math.round(result * 10000) / 10000.0;
                break;

            case 5:
                result = Math.round(result * 100000) / 100000.0;
                break;

            default:
                System.out.println("Error: Accuracy level is out of scope");
                break;


        }

        String returnValue = df.format(result);

        return returnValue;

    }


}
