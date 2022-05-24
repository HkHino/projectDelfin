import java.util.ArrayList;
import java.util.Collections;

public class TrainerController
{

    private UserInterface userinterface;
    private ChairmanController chairmanController;
    private CompetitiveMember competitiveMember;

    private ArrayList<CompetitiveMember> allCompetitiveSwimmers; //liste af members af typen CompetitiveMember (klassen)

    //Arraylister modtaget fra chairmanController
    private ArrayList<Member> juniorSwimmers;
    private ArrayList<Member> seniorSwimmers;
    private ArrayList<Member> pensionerSwimmers;

    private ArrayList<CompetitiveMember> juniorCompetitors = new ArrayList<>();
    private ArrayList<CompetitiveMember> seniorCompetitors = new ArrayList<>();
    private ArrayList<CompetitiveMember> pensionerCompetitors = new ArrayList<>();
    private ArrayList<CompetitiveMember> butterfly = new ArrayList<>();
    private ArrayList<CompetitiveMember> crawl = new ArrayList<>();
    private ArrayList<CompetitiveMember> backCrawl = new ArrayList<>();
    private ArrayList<CompetitiveMember> breaststroke = new ArrayList<>();

    private ArrayList<CompetitiveMember> top5Crawl= new ArrayList<>();
    //private ArrayList<Double>


    public TrainerController(UserInterface userinterface, CompetitiveMember competitiveMember)
    {
        this.userinterface = userinterface;
        this.competitiveMember = competitiveMember;

    }
    public void trainerMenu(){
        divideCompetitorsByAge();
        addMemberToDisciplineFromFile();

        boolean loop = true;
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
                    addOrChangeCompetitorTime();

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
        userinterface.whichAgeGroup();
        int input = userinterface.returnsUserInputInt();

        switch (input){
            case 1:
                userinterface.printGroupTitle("Junior");
                findCompetitorsAndAddToDiscipline(juniorCompetitors);
                break;
            case 2:
                userinterface.printGroupTitle("Senior");
                findCompetitorsAndAddToDiscipline(seniorCompetitors);
                break;
            case 3:
                userinterface.printGroupTitle("Pensioner");
                findCompetitorsAndAddToDiscipline(pensionerCompetitors);
                break;
            case 4:
                break;

        }

    }

    public void addOrChangeCompetitorTime(){
        userinterface.whichAgeGroup();
        int input = userinterface.returnsUserInputInt();

        switch (input){
            case 1:
                userinterface.printGroupTitle("Junior");
                addOrChangeSwimmingTimes(juniorCompetitors);
                break;
            case 2:
                userinterface.printGroupTitle("Senior");
                addOrChangeSwimmingTimes(seniorCompetitors);
                break;
            case 3:
                userinterface.printGroupTitle("Pensioner");
                addOrChangeSwimmingTimes(pensionerCompetitors);
                break;
            case 4:
                break;

        }

    }

    public void divideCompetitorsByAge(){
        allCompetitiveSwimmers = chairmanController.getCompetitiveSwimmers();
        juniorSwimmers = chairmanController.getJuniors();
        seniorSwimmers =  chairmanController.getSeniors();
        pensionerSwimmers = chairmanController.getPensioner();

        //Kategoriserer medlemmer ved alder

        //JUNIOR
        for (int i = 0; i < allCompetitiveSwimmers.size(); i++) {
            for (int j = 0; j < juniorSwimmers.size(); j++) {
                if(allCompetitiveSwimmers.get(i)== juniorSwimmers.get(j))
                    juniorCompetitors.add(allCompetitiveSwimmers.get(i));
            }
        }

        //SENIOR
        for (int i = 0; i < allCompetitiveSwimmers.size(); i++) {
            for (int j = 0; j < seniorSwimmers.size(); j++) {
                if(allCompetitiveSwimmers.get(i)== seniorSwimmers.get(j))
                    seniorCompetitors.add(allCompetitiveSwimmers.get(i));
            }
        }

        //PENSIONER
        for (int i = 0; i < allCompetitiveSwimmers.size(); i++) {
            for (int j = 0; j < pensionerSwimmers.size(); j++) {
                if(allCompetitiveSwimmers.get(i)== pensionerSwimmers.get(j))
                    pensionerCompetitors.add(allCompetitiveSwimmers.get(i));
            }
        }
    }

    public void findCompetitorsAndAddToDiscipline(ArrayList<CompetitiveMember> members){
        userinterface.printCompetitiveMemberNamesAndID(members);

        boolean loop = true;
        while(loop) {
            userinterface.memberIDorName();
            String nameOrID = userinterface.returnsUserInputString();

            boolean found = false;

            try {
                int memberId = (Integer.parseInt(nameOrID));
                for (int i = 0; i < members.size(); i++) {
                    if (memberId == members.get(i).getMemberId()) {
                        addMemberToDiscipline(members.get(i)); //metoden der tilføjer til disciplin
                        members.get(i).setTime(0);
                        found = true;
                        loop = false;
                    }
                }
            } catch (Exception e) {
                for (int i = 0; i < members.size(); i++) {
                    if (nameOrID.equals(members.get(i).getName().toLowerCase())) {
                        addMemberToDiscipline(members.get(i));
                        members.get(i).setTime(0);
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

    public void addMemberToDisciplineFromFile(){
        for (int i = 0; i < allCompetitiveSwimmers.size(); i++) {
            if(allCompetitiveSwimmers.get(i).getSwimmingDiscipline()==SwimmingDisciplines.CRAWL)
                crawl.add(allCompetitiveSwimmers.get(i));
            else if(allCompetitiveSwimmers.get(i).getSwimmingDiscipline()==SwimmingDisciplines.BUTTERFLY)
                butterfly.add(allCompetitiveSwimmers.get(i));
            else if(allCompetitiveSwimmers.get(i).getSwimmingDiscipline()==SwimmingDisciplines.BACKCRAWL)
                backCrawl.add(allCompetitiveSwimmers.get(i));
            else if(allCompetitiveSwimmers.get(i).getSwimmingDiscipline()==SwimmingDisciplines.BREASTSTROKE)
                breaststroke.add(allCompetitiveSwimmers.get(i));
        }

    }


    public void addMemberToDiscipline(CompetitiveMember member){
        userinterface.trainerDisciplines();
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
                backCrawl.add(member);
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
                Collections.sort(allCompetitiveSwimmers);
                printMembers(allCompetitiveSwimmers);

            case 2: {
                Collections.sort(juniorCompetitors);
                printMembers(juniorCompetitors);
                break;
            }
            case 3: {
                Collections.sort(seniorCompetitors);
                printMembers(seniorCompetitors);
                break;
            }
            case 4: {
                Collections.sort(pensionerCompetitors);
                printMembers(pensionerCompetitors);
                break;
            }
            case 5: { //return
                break;
            }
        }
    }
    public void addOrChangeSwimmingTimes(ArrayList<CompetitiveMember> members) {

            userinterface.printCompetitiveMemberNamesAndID(members);

            boolean loop = true;
            while(loop) {
                userinterface.memberIDorName();
                String nameOrID = userinterface.returnsUserInputString();

                boolean found = false;

                try {
                    int memberId = (Integer.parseInt(nameOrID));
                    for (int i = 0; i < members.size(); i++) {
                        if (memberId == members.get(i).getMemberId()) {
                            userinterface.askSwimmingTime();
                            members.get(i).setTime(userinterface.returnsUserInputDouble());
                            userinterface.addTimeConfirm();

                            found = true;
                            loop = false;

                        }
                    }
                } catch (Exception e) {
                    for (int i = 0; i < members.size(); i++) {
                        if (nameOrID.equals(members.get(i).getName().toLowerCase())) {
                            userinterface.askSwimmingTime();
                            competitiveMember.setTime(userinterface.returnsUserInputDouble());
                            userinterface.addTimeConfirm();
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
                topFiveSwimmers(juniorCompetitors);
                break;
            }
            case 2: {
                topFiveSwimmers(seniorCompetitors);
                break;
            }
            case 3: {
                topFiveSwimmers(pensionerCompetitors);
                break;
            }
            case 4: {
                topFiveSwimmers(allCompetitiveSwimmers);
                break;
            }
            case 5: {
                break;
            }
        }
    }

    public void topFiveSwimmers(ArrayList<CompetitiveMember> competitiveMembers) {
        userinterface.trainerDisciplines();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: { //butterfly
                Collections.sort(butterfly);
                userinterface.displayTop5(butterfly,competitiveMembers);
                break;
            }
            case 2: {  //crawl
                Collections.sort(crawl);
                userinterface.displayTop5(crawl, competitiveMembers);
            }
                break;
            case 3: { //back crawl
                Collections.sort(backCrawl);
                userinterface.displayTop5(backCrawl,competitiveMembers);
                break;
            }
            case 4: { //breaststroke
                Collections.sort(breaststroke);
                userinterface.displayTop5(breaststroke,competitiveMembers);
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

