import java.util.Stack;

public class ArithmeticExpression {

    private Stack<Integer> operandStack = new Stack<>();
    private Stack<Character> operatorStack = new Stack<>();

    private String expression;

    public ArithmeticExpression(String expression) {
        this.expression = expression;
    }


    public int makeCalculationToBracket(){
        operatorStack = new Stack<>();
        operandStack = new Stack<>();
        for (int x = 0; x < expression.length(); x++) {
            if (Character.isDigit(expression.charAt(x))) {
                StringBuffer sbuf = new StringBuffer();
                while (x < expression.length() && expression.charAt(x) >= '0' && expression.charAt(x) <= '9')
                    sbuf.append(expression.charAt(x++));
                x--;
                operandStack.push(Integer.parseInt(sbuf.toString()));
            }
            else if (expression.charAt(x) == '(')
                operatorStack.push(expression.charAt(x));
            else if (expression.charAt(x) == ')') {
                while (operatorStack.peek() != '(')
                    operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                operatorStack.pop();
            }
            else if (expression.charAt(x) == '+' || expression.charAt(x) == '-' || expression.charAt(x) == '*' || expression.charAt(x) == '/') {
                while (!operatorStack.empty() && hasPrecedence(expression.charAt(x), operatorStack.peek()))
                    operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                operatorStack.push(expression.charAt(x));
            }
        }
        while (!operatorStack.empty())
            operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));

        return operandStack.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public int calculate(char op, int b, int a){
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            }
            return 0;
    }


    public boolean charIsValid(int position){
        char[] validChars = {'(', ')', '+', '-', '*', '/'};

        for(int x = 0; x < validChars.length; x++){
            if(expression.charAt(position) == validChars[x])
                return true;
        }
        if(Character.isDigit(expression.charAt(position)))
            return true;

        return false;
    }

    public String toString(){
        return expression;
    }

    public Stack<Integer> getOperandStack() {
        return operandStack;
    }

    public void setOperandStack(Stack<Integer> operandStack) {
        this.operandStack = operandStack;
    }

    public Stack<Character> getOperatorStack() {
        return operatorStack;
    }

    public void setOperatorStack(Stack<Character> operatorStack) {
        this.operatorStack = operatorStack;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
