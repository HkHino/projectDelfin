public class TrainerController
{
    private Userinterface userinterface;

    private boolean loop = true;
    int input = userinterface.returnsUserInputInt();
    public void trainerMenu(){

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
                    break;
                }
                case 5: {

                    loop = false;
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
