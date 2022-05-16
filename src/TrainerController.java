public class TrainerController
{
    private Userinterface userinterface;

    private boolean loop = true;

    public void trainerMenu(){

        while (loop){
            userinterface.trainerMenu();
            int input = userinterface.returnsUserInputInt();
            switch (input){
                case 3: {
                    //Return to previous menu
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
                    break;
                }
            }
        }
    }

    public void addSwimmingTimes(){

    }

    public TrainerController(Userinterface userinterface){
        this.userinterface = userinterface;
    }
}
