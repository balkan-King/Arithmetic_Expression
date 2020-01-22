import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String entry = "";

        ArithmeticController arithmeticController = new ArithmeticController();

        do{
            entry = arithmeticController.showMenu(entry);
            arithmeticController.switchCase(entry);
        }while(!"x".toLowerCase().equals(entry));
    }
}
