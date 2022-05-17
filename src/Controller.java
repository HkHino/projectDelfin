import java.io.FileNotFoundException;

public class Controller
{
    private ChairmanController chairmanController;
    private TrainerController trainerController;
    private Cashier cashier;
    private Userinterface userinterface;
    private Trainer trainer;

    public Controller() throws FileNotFoundException {

        userinterface = new Userinterface();
        chairmanController = new ChairmanController(userinterface);
        trainerController = new TrainerController(userinterface);
        cashier = new Cashier(userinterface, chairmanController);
        trainer = new Trainer("Bob", 1);

    }

    public void run() throws FileNotFoundException
    {
        //chairmanController.loadListOfMembers(); //todo move this to the correct place Basma knows where
        //System.out.println(formand.getAllMembers());
        showMainMenu();
    }

    public void showMainMenu() throws FileNotFoundException
    {

        userinterface.StartMenu();

        int input = userinterface.returnsUserInputInt();

        if (input == 1)
        {
            chairmanController.chairmanMenu();
        }
        else if (input == 2)
        {
            trainerController.trainerMenu();
        }
        else if (input == 3)
            userinterface.kasserMenu();

    }
}
