public class TrainerController
{

    private Userinterface userinterface;
    private boolean loop = true;

    public TrainerController(Userinterface userinterface)
    {
        this.userinterface = userinterface;
    }

    public void trainerMenu(){
        userinterface.trainerMenu();
        int input = userinterface.returnsUserInputInt();
        while (loop){
            userinterface.trainerMenu();

            switch (input){
                case 3: {
                    //todo Return to previous menu
                    break;
                }
                case 4: {

                }
                case 5: {

                }
                case 6: {

                }
                case 7: {
                    addSwimmingTimes();
                    loop=false;
                    break;
                }
            }
        }
    }
    public void addSwimmingTimes(){}
}
