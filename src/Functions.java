import java.io.IOException;
import java.util.Scanner;

public class Functions extends Main {

public String getRawInputString() {

    Scanner rawInput = new Scanner(System.in);

    String data = rawInput.nextLine();

    return data;
}

public int getRawInputInteger() {
    Scanner rawInput = new Scanner(System.in);
    int data = rawInput.nextInt();
    return data;

}

public int[] convertToIntegerArray(String arrayInput) {

    String[] stringArray = arrayInput.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

    int[] arrayList = new int[stringArray.length];

    for (int i = 0; i < stringArray.length; i++) {
        try {
            arrayList[i] = Integer.parseInt(stringArray[i]);
        } catch (NumberFormatException nfe) {

        }
    }

    return arrayList;

}

public Double getRawInputDouble() {
    Scanner rawInput = new Scanner(System.in);
    Double data = rawInput.nextDouble();
    return data;
}

public String getOperatingSystem() {

    String OS = System.getProperty("os.name");
    return OS;

}

public void clearConsole() {

    String OS = getOperatingSystem();

    if (OS.contains("Windows")) {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public void continueOrExit() {

    System.out.println("Do you wish to continue? (Y/N)");
    String userPreference = getRawInputString();
    userPreference = userPreference.toUpperCase();

    switch (userPreference) {

        case "Y":
            Main.MainMenu();
            break;

        case "N":
            System.exit(0);
            break;

        default:
            System.out.println("Please enter a valid option");
            continueOrExit();
            break;

    }

}

}
