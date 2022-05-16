import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller
{
    private Formand formand;
    private Kassér kassér;
    private Userinterface userinterface;
    private Trainer trainer;

    public Controller()
    {
        userinterface = new Userinterface();
        formand = new Formand(userinterface);
        kassér = new Kassér(userinterface, formand);
        trainer = new Trainer(userinterface, formand);
    }

    public void run() throws FileNotFoundException
    {
        //formand.loadListOfMembers(); //todo move this to the correct place Basma knows where
        //System.out.println(formand.getAllMembers());
        showMainMenu();
    }

    public void showMainMenu() throws FileNotFoundException
    {

        userinterface.StartMenu();

        int input = userinterface.returnsUserInputInt();

        if (input == 1)
        {
            formand.formandMenu();
        }
        else if (input == 2)
        {
            userinterface.trainerMenu();
        }
        else if (input == 3)
            userinterface.kasserMenu();

    }
}
