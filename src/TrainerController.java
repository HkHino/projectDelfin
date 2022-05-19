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
                    System.out.println("Fej");
                    break;
                }
                case 4: {
                    System.out.println("hej");
                    break;
                }
                case 5: {
                    System.out.println("nej");
                    break;
                }
                case 6: {
                    addSwimmingTimes();
                    loop=false;
                    break;
                }
                case 7: {

                    loop = false;
                    break;
                }
            }
        }
    }
    public void addSwimmingTimes(){
        int memberID = userinterface.askMemberId();


    }
  }

