/**
* PURPOSE OF THE PROGRAM:
*
* Create a simple program with the following features:
*  - Simple Menu
*  - Simple Equation
*  - Bubble Sort
*  - Accuracy
*
* @author Praise Mathew Johnson
* @version 2.2
*
*/

// Import all necessary libraries and modules
import java.io.*;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

// Main class
public class Main extends Application {

    // Declare and initialise all constants / class variables
    public static int ACCURACY = 1;
    public static boolean UISWITCH = false;

    // Load GUI into memory
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setTitle("Assignment Two Application");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setMaxWidth(600);
        primaryStage.setMaxHeight(500);
        primaryStage.show();
    }

    // Default method for Main class, to be executed automatically
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException{

        // Create a new instance of Functions class
        Functions functions = new Functions();

        // Get Operating System name from getOperatingSystem method in Functions class
        String OS = functions.getOperatingSystem();

        // Check if OS contains 'Windows', bypasses need to check all Windows versions
        if (OS.contains("Windows")) {

            OS = "Windows";
        }

        // Get current working directory
        String filename = String.valueOf(System.getProperty("user.dir"));

        // Create a new console
        Console console = System.console();

        // Code for autorunning .jar file
        if (console == null && !GraphicsEnvironment.isHeadless()) {

            // Check OS and launch new console
            switch (OS) {

                // If Windows run the following command
                case "Windows":
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "cmd", "/k", "java -jar \"" + filename + "\\" + "Assignment_Two.jar"});
                    System.exit(0);
                    break;

                // If macOS create a bash file and execute file to autorun .jar file
                case "Mac OS X":
                    String scriptContent = "#!/bin/bash \n cd " + filename + "\n clear" + "\n java -jar Assignment_Two.jar" + "\n killall Terminal";
                    Writer output = new BufferedWriter(new FileWriter(filename + "/RUN.sh"));
                    output.write(scriptContent);
                    output.close();
                    Runtime.getRuntime().exec("chmod u+x " + filename + "/RUN.sh");
                    Runtime.getRuntime().exec("/usr/bin/open -a Terminal RUN.sh");
                    System.exit(0);
                    break;

                // If unsupported OS detected
                default:
                    System.out.print("Auto-execution is currently only supported on Windows and macOS");
                    MenuType(null);
                    break;

            }


        } else {
            MenuType(new String[0]);
        }


    }

    // Private class MenuType to allow user to select preferred interface
    private static void MenuType(String[] args) throws InterruptedException, IOException, URISyntaxException {

        // Create a new Functions class instance
        Functions functions = new Functions();
        String menuOption; // Declare a new variable of type String for menu option


        // Display console menu graphics
        System.out.println(" __________________________ ");
        System.out.println("|       |[MENU TYPE]|      |");
        System.out.println("|                          |");
        System.out.println("| OPTIONS:                 |");
        System.out.println("|         [A] GUI Menu     |");
        System.out.println("|         [B] Console Menu |");
        System.out.println("|__________________________|");
        System.out.print("Continue to: ");
        // Get menuOption input using getRawInputString method from Functions class
        menuOption = functions.getRawInputString();
        // Automatically set menuOption to upper case format
        menuOption = menuOption.toUpperCase();

        // Check menuOption using switch case statement
        switch (menuOption) {

            // Option A: GUI menu
            case "A":
                UISWITCH = true; // Set UISWITCH to true
                launch(args); // Launch GUI
                break;

            // Option B: Console menu
            case "B":
                UISWITCH = false; // Set UISWITCH to false
                MainMenu(); // Launch console
                break;

            // Invalid option
            default:
                System.out.println("Invalid Selection");
                MenuType(null); // Loop back to start
                break;
        }

    }

    // Main menu method
    public static void MainMenu() {

        // Create a new instance of the Functions, Accuracy, Equation, Calculator & Sort classes
        Functions functions = new Functions();
        Accuracy accuracy = new Accuracy();
        Equation equation = new Equation();
        Calculator calculator = new Calculator();
        Sort sort = new Sort();

        // Declare a variable of type String for user menu input
        String menuUserInput;

        // Display menu graphics
        System.out.println(" __________________________ ");
        System.out.println("|       |[MAIN MENU]|      |");
        System.out.println("|                          |");
        System.out.println("| OPTIONS:                 |");
        System.out.println("|         [A] Set Accuracy |");
        System.out.println("|             (Default: 1) |");
        System.out.println("|             (Current: " + ACCURACY + ")" + " |");
        System.out.println("|         [B] Equation     |");
        System.out.println("|         [C] Calculator   |");
        System.out.println("|         [D] Sort         |");
        System.out.println("|         [E] Exit         |");
        System.out.println("|__________________________|");
        System.out.print(">> ");
        // Get menuUserInput using getRawInputString method from Functions class
        menuUserInput = functions.getRawInputString();
        // Automatically set menuUserInput to upper case format
        menuUserInput = menuUserInput.toUpperCase();

        // Check menuUserInput using switch case statement
        switch (menuUserInput) {

            // Option A: Accuracy
            case "A":
                System.out.println("Option A Selected");
                accuracy.setAccuracy();
                MainMenu();
                break;

            // Option B: Equation
            case "B":
                System.out.println("Option B Selected");
                System.out.println("");
                System.out.println("Equation format: 4x + 6 = 8");
                System.out.println("Representation:  ax + b = c");

                System.out.println("Please provide the following values:");

                // Declare and initialise variables for validation
                boolean validA = false;
                boolean validB = false;
                boolean validC = false;

                // Declare and initialise a, b, c variables
                double a = 0,b = 0,c = 0;

                // Add a while statement to check if a is valid
                while (!validA) {

                    // Try catch block for validation
                    try {

                        System.out.print("a: ");
                        // Get value of a from getRawInputDouble method from Functions class
                        a = functions.getRawInputDouble();


                        // Check if a is equal to Infinity, NaN or 0
                        while (Double.isInfinite(a) || Double.isNaN(a) || a == 0){

                            // Try catch block for validation
                            try {

                                System.out.println("Invalid number");
                                System.out.print("a: ");
                                // Get value of a from getRawInputDouble method from Functions class
                                a = functions.getRawInputDouble();

                            } catch (InputMismatchException e) {

                                System.out.println("Invalid number");
                                continue;

                            }

                        }

                        // Set validA to true to exit loop
                        validA = true;

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid number");
                        continue;

                    }

                }

                // Add a while statement to check if a is valid
                while (!validB) {

                    // Try catch block for validation
                    try {

                        System.out.print("b: ");
                        // Get value of b from getRawInputDouble method from Functions class
                        b = functions.getRawInputDouble();
                        validB = true; // Set validB to true to exit loop

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid number");
                        continue;

                    }

                }

                // Add a while statement to check if a is valid
                while (!validC) {

                    // Try catch block for validation
                    try {

                        System.out.print("c: ");
                        // Get value of c from getRawInputDouble method from Functions class
                        c = functions.getRawInputDouble();
                        validC = true; // Set validC to true to exit loop

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid number");
                        continue;

                    }

                }

                equation.solveEquation(a, b, c); // Call the solveEquation method from Equations class
                functions.continueOrExit(); // Call the continueOrExit method from Functions class

            // Option C: Calculator
            case "C":
                System.out.println("Option C Selected");
                System.out.println("Please provide the following values:");

                // Declare and initialise variables for validation
                boolean validOne = false;
                boolean validTwo = false;
                boolean validOperator = false;

                // Declare and initialise numberOne, numberTwo & operator variables
                double numberOne = 0, numberTwo = 0;
                String operator = null;

                // Add a while statement to check if numberOne is valid
                while (!validOne) {

                    // Try catch block for validation
                    try {

                        System.out.print("Input number one: ");
                        // Get value of numberOne using getRawInputDouble method from Functions class
                        numberOne = functions.getRawInputDouble();
                        validOne = true; // Set validOne to true to exit loop

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid number");
                        continue;
                    }

                }

                // Add a while statement to check if numberTwo is valid
                while (!validTwo) {

                    // Try catch block for validation
                    try {

                        System.out.print("Input number two: ");
                        // Get value of numberTwo using getRawInputDouble method from Functions class
                        numberTwo = functions.getRawInputDouble();
                        validTwo = true; //Set validTwo to true to exit loop

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid number");
                        continue;
                    }

                }

                // Add a while statement to check if operator is valid
                while (!validOperator) {

                    // Try catch block for validation
                    try {

                        System.out.print("Choose an operator: ");
                        operator = functions.getRawInputString();

                        // While loop to prevent invalid operators
                        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") ) {

                            // Try catch block for validation
                            try {

                                System.out.print("Choose an operator: ");
                                operator = functions.getRawInputString();

                            } catch (InputMismatchException e) {

                                System.out.println("Invalid operator");
                                continue;

                            }

                        }

                        // Set validOperator to true to exit loop
                        validOperator = true;

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid operator1");
                        continue;
                    }

                }

                // Calculate using calculate method from Calculator class
                calculator.calculate(numberOne, numberTwo, operator);
                functions.continueOrExit(); // Call continueOrExit method from Functions class
                break;

            // Option D: Sort
            case "D":
                System.out.println("Option D Selected");
                sort.selectSortType(); // Call selectSortType method from Sort class instance
                functions.continueOrExit(); // Call continueOrExit method from Functions class
                break;

            // Option E: Exit
            case "E":
                System.out.println("Exit Selected");
                System.exit(0); // Call exit command
                break;

            // Invalid option
            default:
                System.out.println("Invalid Selection");
                MainMenu(); // Loops back to start
                break;
        }

    }

}

