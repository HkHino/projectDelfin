import java.io.FileNotFoundException;

public class Controller
{
    private ChairmanController chairmanController;
    private TrainerController trainerController;
    private Cashier cashier;
    private UserInterface userinterface;
    private CompetitiveMember competitiveMember;
    private Member member;

    public Controller() throws FileNotFoundException
    {
        userinterface = new UserInterface();
        cashier = new Cashier(userinterface);
        chairmanController = new ChairmanController(userinterface, cashier);

        cashier.setChairmanController(chairmanController);
        trainerController = new TrainerController(userinterface, competitiveMember);
        trainerController.setChairmanController(chairmanController);
        chairmanController.setTrainerController(trainerController);



    }
    public void run() throws FileNotFoundException {
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
            else if (input == 4)
            {
                userinterface.malakaSoftwareInc();
                loop = false;
            }

        }
        chairmanController.saveListOfMembers();
    }
}