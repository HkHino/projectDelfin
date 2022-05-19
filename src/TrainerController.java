public class TrainerController
{
    private Userinterface userinterface;

    private boolean loop = true;
    int input = userinterface.returnsUserInputInt();
    public void trainerMenu(){

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
                    break;
                }
            }
        }
    }

    public void addSwimmingTimes(){
    if(input == 7){
    
    }

    }
/*
    public TrainerController(Userinterface userinterface){
        this.userinterface = userinterface;
    }


    public TrainerController()
    {}

 */
}
