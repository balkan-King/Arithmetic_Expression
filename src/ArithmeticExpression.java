import java.util.Stack;

/**
 * This class is an entity representing a single arithmetic expression.
 * It can calculate itself and print out the solution.
 */
public class ArithmeticExpression {

  /**
   * This is a Stack object containing all operands from the expression variable.
   */
  private Stack<Double> operandStack = new Stack<>();
  /**
   * This is a Stack object containing all operators from the expression variable.
   */
  private Stack<Character> operatorStack = new Stack<>();

  /**
   * This variable contains the arithmetic expression
   */
  private String expression;

  /**
   * This constructor takes a String that represents a valid arithmetic expression and assigns it to the class' variable named expression.
   * Additionally it removes all whitespaces, that the calculation can work.
   * @param expression
   */
  public ArithmeticExpression(String expression) {
    this.expression = expression.replaceAll(" ", "");
  }

  /**
   * This is the main method of programm it contains the logic on how to calculate the expressin
   * @return the solution of the expression
   */
  public double calculate(){
    operatorStack = new Stack<>();                                                                        //operatorStack is emptied
    operandStack = new Stack<>();                                                                         //operandStack is emptied
    for (int x = 0; x < expression.length(); x++) {                                                       //for loop for every char in the expression
      if (Character.isDigit(expression.charAt(x))) {                                                        //gets executed if the current char is a digit
        StringBuffer stringBuffer = new StringBuffer();                                                       //StringBuffer object is created
        while (x < expression.length() && Character.isDigit(expression.charAt(x)))                            //while the number contains more then one digit
          stringBuffer.append(expression.charAt(x++));                                                          //add the following digit to the stringBuffer
        x--;                                                                                                  //adjust to current digit in expression
        operandStack.push(Double.parseDouble(stringBuffer.toString()));                                       //add the number to the operand stack
      } else if (isOpertor(expression.charAt(x))) {                                                         //gets executed if the current char is an operator
        while (!operatorStack.empty() && pointBeforeLine(expression.charAt(x), operatorStack.peek()))         //while the previous two operands can be calculated
          operandStack.push(computeTwoDigits(operatorStack.pop(), operandStack.pop(), operandStack.pop()));     //calculate the previous two operands
        operatorStack.push(expression.charAt(x));                                                             //add the operator to the stack
      }else if (expression.charAt(x) == '(')                                                                //gets executed if the current char is '('
        operatorStack.push(expression.charAt(x));                                                             //add the operator to the stack
      else if (expression.charAt(x) == ')') {                                                               //gets executed if the current char is ')'
        while (operatorStack.peek() != '(')                                                                   //while the last operator on the stack isn't '('
          operandStack.push(computeTwoDigits(operatorStack.pop(), operandStack.pop(), operandStack.pop()));     //calculate the previous two operands
        operatorStack.pop();                                                                                  //remove '('
      }
    }
    while (!operatorStack.empty())                                                                        //while the operator stack isn't empty
      operandStack.push(computeTwoDigits(operatorStack.pop(), operandStack.pop(), operandStack.pop()));     //calculate the previous two operands

    return operandStack.pop();                                                                            //return the solution
  }

  /**
   * checks if value is an operator
   * @param value is the char that gets checked
   * @return true if it is an operator
   */
  public boolean isOpertor(char value){
    char[] operators = {'+', '-', '*', '/'};
    for(char operator : operators){
      if(value == operator)
        return true;
    }
    return false;
  }

  /**
   * This method checks that there are no alphabetic values in the expression, the expression doesn't start with a close bracket
   * and that there are at no point more closed brackets then opened.
   * @return true if expression has no invalid charachter or invalid brackets
   */
  public boolean isValid(){
    boolean returnValue = true;
    int brackets = 0;

    for(char c : expression.toCharArray()){
      if(Character.isAlphabetic(c)){
        returnValue = false;
        break;
      }
    }

    for(char c : expression.toCharArray()){
      if(c == '(')
        brackets++;
      else if(c == ')')
        brackets--;
      if(brackets < 0) {
        returnValue = false;
        break;
      }
    }
    if(brackets != 0)
      returnValue = false;

    return returnValue;
  }

  /**
   * This method checks if the previous two operands can be added together, or if there are rules that prohibit that.
   * @param operator1 current char in loop from calculate method
   * @param operator2 the last char on operatorstack
   * @return true if the previous two operands from stack can be calculated, false if there are any brackets or the point before line rule applies
   */
  public boolean pointBeforeLine(char operator1, char operator2)
  {
    if (operator2 == '(' || operator2 == ')')
      return false;
    if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
      return false;
    else
      return true;
  }

  /**
   * This method calculates num1 and num2 together, depending on the operator char
   * @param operator that decides which case gets executed
   * @param num1 newest number from stack
   * @param num2 number behind num1 in stack
   * @return result and overwrites num1 and num2
   */
  public double computeTwoDigits(char operator, double num1, double num2){
    switch (operator)
    {
      case '+':
        return num2 + num1;
      case '-':
        return num2 - num1;
      case '*':
        return num2 * num1;
      case '/':
        if (num1 == 0)
          System.out.println("Can not devide through zero");
        else
          return num2 / num1;
    }
    return 0;
  }

  /**
   * This method returns the value of the class as a string
   * @return expression
   */
  public String toString(){
    return expression;
  }

  /**
   * Getters and Setters
   */
  public Stack<Double> getOperandStack() {
    return operandStack;
  }

  public void setOperandStack(Stack<Double> operandStack) {
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
