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
                    showJuniorSwimmers();
                    break;
                }
                case 2: {
                    showSeniorSwimmers();
                    break;
                }
                case 3: {
                    topSwimmers();
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
    public void addSwimmingTimes(){
        //int memberID = userinterface.memberId(); //todo fix this at some point
    }

    public void showJuniorSwimmers(){ //TODO show junior swimmers

    }

    public void showSeniorSwimmers(){ //TODO show senior swimmers

    }

    public void topSwimmers(){ //TODO show top 5 swimmers

    }
  }

