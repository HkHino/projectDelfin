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
                case 1: {

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    addSwimmingTimes();
                    loop=false;
                    break;
                }
                case 5: {

                    loop = false;
                    break;
                }
            }
        }
    }
    public void addSwimmingTimes(){}
}
