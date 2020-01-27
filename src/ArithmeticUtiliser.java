import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the class that contains all additional methods of the programm besides the logic for the calculation and the user interface methods
 */
public class ArithmeticUtiliser {

    /**
     * This is an ArrayList object containing multiple expression object in itself, that the user is able to save mutiple epressions during the runtime.
     */
    ArrayList<ArithmeticExpression> expressions = new ArrayList<>();
    /**
     * Scanner object that can read entries from the user from the console(System.in)
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * This is  an ArithmetichExpression Object that was selected from the upper Arraylist
     * The default expression is the one created at the beginning
     */
    ArithmeticExpression selectedExpression;

    /**
     * This constructor creates the first expression, which also gets selected as default value at the beginning
     */
    public ArithmeticUtiliser() {
        while(!createExpression()){}
        selectedExpression = expressions.get(0);
    }

    /**
     * This method executes the calculate method from the selected expression
     */
    public void makeCalculation(){
        System.out.println(selectedExpression.calculate());
    }

    /**
     * This method lets the user create a new ArithmeticUtiliser object
     * @return true if the creation was succesfull, false if not
     */
    public boolean createExpression(){
        System.out.println("Please enter your arithmetic expression");
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(scanner.nextLine());
        if(arithmeticExpression.isValid()) {
            expressions.add(arithmeticExpression);
            System.out.println("Your expression was successfully created");
            return true;
        }
        System.out.println("\n" .repeat(20)+ "Your expression was invalid, pay attention to the syntax");
        return false;
    }

    /**
     * This method lets you select another expression from the ArrayList
     * It has corresponding Exception handling
     */
    public void changeExpression(){
        System.out.println("Choose your expression:");
        showExpressions();
        try {
            selectedExpression = expressions.get(Integer.parseInt(scanner.nextLine()) - 1);
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Please enter a valid number");
        }
    }

    /**
     * This method show all expressions from the expressions array
     * If the array only contains the first one it doesn't print anything
     */
    public void showExpressions(){
        if(expressions.size() == 1)
            System.out.println("Your array is empty yet");
        else {
            for (int x = 0; x < expressions.size(); x++) {
                System.out.println((x + 1) + ". " + expressions.get(x));
            }
        }
    }
}
