public class TrainerController
{

    private Userinterface userinterface;


    public TrainerController(Userinterface userinterface)
    {
        this.userinterface = userinterface;
    }

    public void trainerMenu(){
        boolean loop = true;

        while (loop){
            userinterface.trainerMenu();
            int input = userinterface.returnsUserInputInt();


            switch (input){
                case 1: {
                    trainerSwimmersMenu();
                    break;
                }
                case 2: {
                    topSwimmers();
                    break;
                }
                case 3: {
                    addSwimmingTimes();
                    break;
                }
                case 4: {
                    loop=false;
                    break;
                }

            }
        }
    }

    public void trainerSwimmersMenu() {

        userinterface.trainerSwimmers();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: {
                showJuniorSwimmers();
                break;
            }
            case 2: {
                showSeniorSwimmers();
                break;
            }
            case 3: {
                showPensionerSwimmers();
                break;
            }
            case 4: {

                break;
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

    public void showPensionerSwimmers(){ //TODO show Pensioner swimmers

    }

    public void topSwimmers(){ //TODO show top 5 swimmers

    }
  }

