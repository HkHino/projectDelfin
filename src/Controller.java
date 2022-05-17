import java.io.FileNotFoundException;

public class Controller
{
    private ChairmanController chairmanController;
    private TrainerController trainerController;
    private Cashier cashier;
    private Userinterface userinterface;
    private Trainer trainer;



    public Controller() throws FileNotFoundException
    {
        //todo spørg en voksen!!! dette giver en nullpoint exception når programmet køres, hvordan kan det løses?
        userinterface = new Userinterface();
        chairmanController = new ChairmanController(userinterface, cashier);
        trainerController = new TrainerController(userinterface);
        cashier = new Cashier(userinterface, chairmanController);
        trainer = new Trainer("Bob", 1);

    }

    public void run() throws FileNotFoundException
    {
        chairmanController.loadListOfMembers();
        showMainMenu();
    }

    public void showMainMenu() throws FileNotFoundException
    {
        boolean loop = true;
        while (loop)
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
            {

                cashier.cashierMenu();
            }
            else
            {
                System.out.println("Thanks for using malaka software inc");
                loop = false;
            }

        }
    }
}