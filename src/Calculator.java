public class Calculator extends Main{

    public String calculate(double numberOne, double numberTwo, String operator) {

        Functions functions = new Functions();
        Accuracy accuracy = new Accuracy();
        double result = 0.0;

        switch (operator) {

            case "+":
                result = numberOne + numberTwo;
                break;

            case "-":
                result = numberOne - numberTwo;
                break;

            case "*":
                result = numberOne * numberTwo;
                break;

            case "/":
                while (Double.isInfinite(numberTwo) || Double.isNaN(numberTwo) || numberTwo == 0) {

                    System.out.println("Number invalid");
                    System.out.print("Input number two: ");
                    numberTwo = functions.getRawInputDouble();

                }
                result = numberOne / numberTwo;
                break;

            default:
                System.out.println("Wrong operator");

        }

        if (UISWITCH == false) {

            System.out.println("_______________________");

            System.out.println("| Solution: x = " + String.valueOf(accuracy.roundToDecimalPlace(result)));

        }

        return String.valueOf(accuracy.roundToDecimalPlace(result));

    }

}
