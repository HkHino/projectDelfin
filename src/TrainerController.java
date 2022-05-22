import java.util.ArrayList;

public class TrainerController
{

    private Userinterface userinterface;
    private ChairmanController chairmanController;
    private CompetitiveMember competitiveMember;

    private ArrayList<CompetitiveMember> allCompetetiveSwimmers; //liste af members af typen CompetitiveMember (klassen)

    //Arraylister mmodtaget fra chairmanController
    private ArrayList<Member> juniorSwimmers;
    private ArrayList<Member> seniorSwimmers;
    private ArrayList<Member> pensionerSwimmers;

    private ArrayList<CompetitiveMember> juniorCompetitors = new ArrayList<>();
    private ArrayList<CompetitiveMember> seniorCompetitors = new ArrayList<>();
    private ArrayList<CompetitiveMember> pensionerCompetitors = new ArrayList<>();
    private ArrayList<CompetitiveMember> butterfly = new ArrayList<>();
    private ArrayList<CompetitiveMember> crawl = new ArrayList<>();
    private ArrayList<CompetitiveMember> backcrawl = new ArrayList<>();
    private ArrayList<CompetitiveMember> breaststroke = new ArrayList<>();

    public TrainerController(Userinterface userinterface, CompetitiveMember competitiveMember)
    {
        this.userinterface = userinterface;
        this.competitiveMember = competitiveMember;

    }
    public void trainerMenu(){
        boolean loop = true;
        divideCompetitorsByAge();

        while (loop){
            userinterface.trainerMenu();
            int input = userinterface.returnsUserInputInt();


            switch (input){
                case 1: {
                    swimmersMenu();
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
                    addOrChangeCompetitorDiscipline();
                    break;
                }
                case 5: {
                    loop=false;
                    break;
                }

            }
        }
    }

    public void addOrChangeCompetitorDiscipline(){
        userinterface.askWhichAgeGroup();
        int input = userinterface.returnsUserInputInt();

        switch (input){
            case 1:
                userinterface.printGroupTitle("Junior");
                findCompetitorsAndAddToDisciplines(juniorCompetitors);
                break;
            case 2:
                userinterface.printGroupTitle("Senior");
                findCompetitorsAndAddToDisciplines(seniorCompetitors);
                break;
            case 3:
                userinterface.printGroupTitle("Pensioner");
                findCompetitorsAndAddToDisciplines(pensionerCompetitors);
                break;
            case 4:
                break;

        }

    }

    public void divideCompetitorsByAge(){
        allCompetetiveSwimmers = chairmanController.getCompetitiveSwimmers();
        juniorSwimmers = chairmanController.getJuniors();
        seniorSwimmers =  chairmanController.getSeniors();
        pensionerSwimmers = chairmanController.getPensioner();

        //Kategoriserer medlemmer ved alder
        //JUNIOR
        for (int i = 0; i < allCompetetiveSwimmers.size(); i++) {
            for (int j = 0; j < juniorSwimmers.size(); j++) {
                if(allCompetetiveSwimmers.get(i)== juniorSwimmers.get(j))
                    juniorCompetitors.add(allCompetetiveSwimmers.get(i));
            }
        }
        //SENIOR
        for (int i = 0; i < allCompetetiveSwimmers.size(); i++) {
            for (int j = 0; j < seniorSwimmers.size(); j++) {
                if(allCompetetiveSwimmers.get(i)== seniorSwimmers.get(j))
                    seniorCompetitors.add(allCompetetiveSwimmers.get(i));
            }
        }
        //PENSIONER
        for (int i = 0; i < allCompetetiveSwimmers.size(); i++) {
            for (int j = 0; j < pensionerSwimmers.size(); j++) {
                if(allCompetetiveSwimmers.get(i)== pensionerSwimmers.get(j))
                    pensionerCompetitors.add(allCompetetiveSwimmers.get(i));
            }
        }
    }

    public void findCompetitorsAndAddToDisciplines(ArrayList<CompetitiveMember> members){
        userinterface.printCompetitiveMemberNamesAndID(members);

        boolean loop = true;
        while(loop) {
            userinterface.askMemberIDorName();
            String nameOrID = userinterface.returnsUserInputString();

            boolean found = false;

            try {
                int memberId = (Integer.parseInt(nameOrID));
                for (int i = 0; i < members.size(); i++) {
                    if (memberId == members.get(i).getMemberId()) {
                        addMemberToDisciplin(members.get(i)); //metoden der tilføjer til disciplin
                        found = true;
                        loop = false;

                    }
                }
            } catch (Exception e) {
                for (int i = 0; i < members.size(); i++) {
                    if (nameOrID.equals(members.get(i).getName().toLowerCase())) {
                        addMemberToDisciplin(members.get(i));
                        found = true;
                        loop = false;
                    }

                }
            }
            if (!found) {
                userinterface.memberNotFound();
            }
        }
    }



    public void addMemberToDisciplin(CompetitiveMember member){
        userinterface.trainerDisciplins();
        int input = userinterface.returnsUserInputInt();

        switch (input){
            case 1:
                member.setSwimmingDisciplin(SwimmingDisciplines.BUTTERFLY);
                butterfly.add(member);
                break;
            case 2:
                member.setSwimmingDisciplin(SwimmingDisciplines.CRAWL);
                crawl.add(member);
                break;
            case 3:
                member.setSwimmingDisciplin(SwimmingDisciplines.BACKCRAWL);
                backcrawl.add(member);
                break;
            case 4:
                member.setSwimmingDisciplin(SwimmingDisciplines.BREASTSTROKE);
                breaststroke.add(member);
                break;
            case 5:
                break;
        }

    }

    public void swimmersMenu() {

        userinterface.competitiveSwimmersMenu();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1:
                userinterface.listOfCompetitiveMembers();
                printMembers(allCompetetiveSwimmers);

            case 2: {
                printMembers(juniorCompetitors);
                break;
            }
            case 3: {
                printMembers(seniorCompetitors);
                break;
            }
            case 4: {
                printMembers(pensionerCompetitors);
                break;
            }
            case 5: { //return
                break;
            }
        }
    }
    public void addSwimmingTimes(ArrayList<CompetitiveMember> members) {

            userinterface.printCompetitiveMemberNamesAndID(members);

            boolean loop = true;
            while(loop) {
                userinterface.askMemberIDorName();
                String nameOrID = userinterface.returnsUserInputString();

                boolean found = false;

                try {
                    int memberId = (Integer.parseInt(nameOrID));
                    for (int i = 0; i < members.size(); i++) {
                        if (memberId == members.get(i).getMemberId()) {
                            competitiveMember.setTime(userinterface.returnsUserInputDouble());
                          //todo add.time to member
                            found = true;
                            loop = false;

                        }
                    }
                } catch (Exception e) {
                    for (int i = 0; i < members.size(); i++) {
                        if (nameOrID.equals(members.get(i).getName().toLowerCase())) {
                            competitiveMember.setTime(userinterface.returnsUserInputDouble());
                            //todo add.time to member
                            found = true;
                            loop = false;
                        }

                    }
                }
                if (!found) {
                    userinterface.memberNotFound();
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


    public void setChairmanController(ChairmanController chairmanController) {
        this.chairmanController=chairmanController;
    }

    public void printMembers(ArrayList<CompetitiveMember> members){
        userinterface.viewListOfCompetitiveMembers(members);

    }
}

