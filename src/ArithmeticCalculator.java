import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticCalculator {

    ArrayList<ArithmeticExpression> expressions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ArithmeticExpression selectedExpression;

    public ArithmeticCalculator() {
        createExpression();
        selectedExpression = expressions.get(0);
    }

    public void makeCalculation(){
        System.out.println(selectedExpression.makeCalculationToBracket(selectedExpression.getExpression()));
    }

    public void createExpression(){
        System.out.println("Please enter your arithmetic expression");
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(scanner.nextLine());
        expressions.add(arithmeticExpression);
    }

    public void showStacks(){
        System.out.println(selectedExpression.toString());
    }

    public void changeExpression(){
        System.out.println("Choose your expression:");
        showExpressions();
        selectedExpression = expressions.get(Integer.parseInt(scanner.nextLine()) - 1);
    }

    public void showExpressions(){
        for(int x = 0; x< expressions.size(); x++){
            System.out.println((x + 1) + ". " + expressions.get(x));
        }
    }
}
