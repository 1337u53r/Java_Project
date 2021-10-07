public class Equation extends Main {
    

    public String solveEquation(double a, double b, double c) {

        Accuracy accuracy = new Accuracy();

        String x = accuracy.roundToDecimalPlace((c - b) / a);

        if (UISWITCH == false) {

            System.out.println(" _______________________");
            System.out.println("| Solution: x = " + x);

        }

        return x;
    }

}
