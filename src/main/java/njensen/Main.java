package njensen;

import njensen.controllers.MainController;

public class Main {

    public static void main(String[] args) {

        MainController mainController = new MainController();

        if (args.length > 0) {
            mainController.init(args[0]);
        } else {
            System.out.println("The search uses regex (Java) for the argument. \nSupply an argument string.");
        }

    }
}
