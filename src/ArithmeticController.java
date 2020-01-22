import java.util.Scanner;

public class ArithmeticController {

    Scanner scanner = new Scanner(System.in);
    ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

    public String showMenu(String entry){
        System.out.println("\n".repeat(20));
        System.out.println("What do you want to do:\n" +
                "[1] to create a new Arithmetic Expression\n" +
                "[2] to see the calculation for the selected expression\n" +
                "[3] to see the selected expression\n" +
                "[4] to select another expression\n" +
                "[x] to leave the application");
        entry = scanner.nextLine();
        return entry;
    }

    public void switchCase(String entry){
        switch (entry){
            case "1":
                arithmeticCalculator.createExpression();
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case "2":
                arithmeticCalculator.makeCalculation();
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case "3":
                arithmeticCalculator.showStacks();
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case "4":
                arithmeticCalculator.changeExpression();
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
