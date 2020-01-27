import java.util.Scanner;

/**
 * This class is responsible for passing the userentry to the according method
 */
public class ArithmeticController {

    /**
     * Scanner object that can read entries from the user from the console(System.in)
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * This is the ArithmeticUtiliser class, that contains the additional methods needed to process the data correctly
     */
    ArithmeticUtiliser arithmeticUtiliser = new ArithmeticUtiliser();

    /**
     * This class shows the menu with all possible methods to the user and gets his response
     * @return the entered value from the user in the console
     */
    public String showMenu(){
        System.out.println("\n".repeat(20));
        System.out.println(arithmeticUtiliser.selectedExpression + "\n" +
                "What do you want to do:\n" +
                "[1] to see the calculation for the selected expression\n" +
                "[2] to create a new Arithmetic Expression\n" +
                "[3] to select another expression\n" +
                "[x] to leave the application");
        String entry = scanner.nextLine();
        return entry;
    }

    /**
     * This switch case class passes the userentry to the according method in ArithmeticUtiliser
     * @param entry is the userentry
     */
    public void switchCase(String entry){
        switch (entry){
            case "1":
                arithmeticUtiliser.makeCalculation();
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case "2":
                arithmeticUtiliser.createExpression();
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case "3":
                arithmeticUtiliser.changeExpression();
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case "x": case "X":
                break;
            default:
                System.out.println("Please enter a valid value");
                System.out.println("Press enter to continue");
                scanner.nextLine();
        }
    }
}
