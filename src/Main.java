/**
 * This is the Main class containing the whole application
 */
public class Main {

    public static void main(String[] args) {
        /**
         * This varibale contains the entry of the user from the console
         */
        String entry = "";

        /**
         * This is the ArithmeticController class that passes the process to the according method based on the user entry
         */
        ArithmeticController arithmeticController = new ArithmeticController();

        /**
         * This loop contains the whole application and is repeated until the user decides to press x and finish the application
         */
        do{
            entry = arithmeticController.showMenu();
            arithmeticController.switchCase(entry);
        }while(!"x".equals(entry.toLowerCase()));
    }
}
