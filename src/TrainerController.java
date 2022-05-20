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
                    SwimmersMenu();
                    break;
                }
                case 2: {
                    top5Menu();
                    break;
                }
                case 3: {
                    addSwimmingTimes();
                    break;
                }
                case 4: {
                    addDisciplinToSwimmer();
                    break;
                }
                case 5: {
                    loop=false;
                    break;
                }

            }
        }
    }

    public void SwimmersMenu() {

        userinterface.trainerSwimmers();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: { //TODO show all junior swimmers
                break;
            }
            case 2: { //TODO show all senior swimmers
                break;
            }
            case 3: { //TODO show all pensioner swimmers
                break;
            }
            case 4: { //return
                break;
            }
        }
    }

    public void top5Menu() {

        userinterface.trainerTop5Menu();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: {
                JuniorTopSwimmers();
                break;
            }
            case 2: {
                SeniorTopSwimmers();
                break;
            }
            case 3: {
                PensionerTopSwimmers();
                break;
            }
            case 4: {
                topSwimmers();
                break;
            }
            case 5: {
                break;
            }
        }
    }



    public void addSwimmingTimes(){
        //int memberID = userinterface.memberId(); //todo fix this at some point
    }

    public void addDisciplinToSwimmer() { //TODO add disciplin to swimmer

    }

    public void JuniorTopSwimmers() { //TODO show top 5 junior swimmers
        userinterface.trainerDisciplins();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: { //butterfly

                break;
            }
            case 2: {  //crawl

                break;
            }
            case 3: { //back crawl

                break;
            }
            case 4: { //breaststroke

                break;
            }
            case 5: { //return
                break;
            }
        }
    }

    public void SeniorTopSwimmers(){ //TODO show top 5 senior swimmers
        userinterface.trainerDisciplins();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: { //butterfly

                break;
            }
            case 2: {  //crawl

                break;
            }
            case 3: { //bacl crawl

                break;
            }
            case 4: { //breaststroke

                break;
            }
            case 5: { //return
                break;
            }
        }
    }

    public void PensionerTopSwimmers(){ //TODO show top 5 Pensioner swimmers
        userinterface.trainerDisciplins();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: { //butterfly

                break;
            }
            case 2: {  //crawl

                break;
            }
            case 3: { //back crawl

                break;
            }
            case 4: { //breaststroke

                break;
            }
            case 5: { //return
                break;
            }
        }
    }

    public void topSwimmers(){ //TODO show top 5 swimmers overall
        userinterface.trainerDisciplins();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: { //butterfly

                break;
            }
            case 2: {  //crawl

                break;
            }
            case 3: { //back crawl

                break;
            }
            case 4: { //breaststroke

                break;
            }
            case 5: { //return
                break;
            }
        }
    }


  }

