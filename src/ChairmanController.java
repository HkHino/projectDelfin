import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChairmanController
{

    //attributes
    private boolean loop = true;

    //members
    private ArrayList<Members> allMembers = new ArrayList<>();
    private ArrayList<Members> activeMembers = new ArrayList<>();
    private ArrayList<Members> passiveMembers = new ArrayList<>();
    private ArrayList<Members> competetiveSwimmers = new ArrayList<>();
    private ArrayList<Members> exercicsers = new ArrayList<>();
    private ArrayList<Members> seniors = new ArrayList<>();
    private ArrayList<Members> juniors = new ArrayList<>();
    private ArrayList<Members> pentionist = new ArrayList<>();

    private Userinterface userinterface;

    //constructor
//
    public ChairmanController(Userinterface userinterface){
        this.userinterface=userinterface;
    }

    public void chairmanMenu() throws FileNotFoundException {

        while (loop) {
            userinterface.chairmanMenu();
            int input = userinterface.returnsUserInputInt();

            switch (input) {
                case 1: {
                    signUpNewMember();
                    break;
                }
                case 2: {
                    cancelSubscription();
                    break;
                }
                case 3: {
                    //return to previous menu
                    loop = false;
                    //todo implement previous menu page
                }

                case 4:
                    userinterface.viewListOfMembers(allMembers);

            }
            //saveListOfMembers();

        }

    }

    public void signUpNewMember() {

        userinterface.askName();
        String inputName = userinterface.returnsUserInputString();

        userinterface.askAddress();
        String inputAddress = userinterface.returnsUserInputString();

        userinterface.askAge();
        int inputAge = userinterface.returnsUserInputInt();
        //kassér.memberStatus(inputAge);

        userinterface.askGender();
        String inputGenderIsFemale = userinterface.returnsUserInputString();
        boolean genderIsFemale;
        if (inputGenderIsFemale.equalsIgnoreCase("F")) {
            //System.out.println("you're a girl");
            genderIsFemale = true;
        } else { //todo fejlhåndtering
            //System.out.println("you're a boy");
            genderIsFemale = false;
        }

        userinterface.askMemberacctivity();
        String inputActivity = userinterface.returnsUserInputString();
        boolean isActive;
        if (inputActivity.equalsIgnoreCase("a"))
            isActive = true;
        else
            isActive = false;

        userinterface.askIsCompetitive();
        String inputEliteSwimmer = userinterface.returnsUserInputString();
        boolean isCompetitiveSwimmer;
        if (inputEliteSwimmer.equalsIgnoreCase("yes"))
            isCompetitiveSwimmer = true;
        else
            isCompetitiveSwimmer = false;

        createNewMember(inputName, inputAge, inputAddress, genderIsFemale, isActive, isCompetitiveSwimmer);


    }
    public void createNewMember(String name, int age, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer) {
        Members member = new Members(name, age, address, genderIsFemale, isActive, isCompetitiveSwimmer);

        addMemberToMemberList(member);

        addJuniorOrSenior(age,member);
        addActiveOrPassive(isActive,member);
        addCompetitiveOrExerciser(isCompetitiveSwimmer, member);


        System.out.println("you have successfully added a new member!: " + member.getName());


    }
    public void addMemberToMemberList(Members member) {
        allMembers.add(member);
    }

    public void addJuniorOrSenior(int age, Members member){
        if (age<18)
            juniors.add(member);
        else if(age >= 18 && age < 60) //todo why does this not of workings?
        {
            seniors.add(member);
        }
        else
        {
            pentionist.add(member);
        }
    }

    public void addActiveOrPassive(boolean isActive, Members member){
        if (isActive)
            activeMembers.add(member);
        else
            passiveMembers.add(member);
    }

    public void addCompetitiveOrExerciser(boolean isCompetitiveSwimmer, Members member){
        if (isCompetitiveSwimmer)
            competetiveSwimmers.add(member);
        else
            exercicsers.add(member);
    }


    public void cancelSubscription(){
        userinterface.cancelSub();
        userinterface.askName();
        String name = userinterface.returnsUserInputString();

        for (int i = 0; i < allMembers.size(); i++) {
            if (name.equals(allMembers.get(i).getName()))
                removeMemberFromMemberList(allMembers.get(i));
        }

    }


   /* public void saveListOfMembers() throws FileNotFoundException { //skriver til en fil
        PrintStream out = new PrintStream("members.txt");
        for(Members member : allMembers) {
            out.println(member.getName()+ ";" + member.getAge() + ";"+ member.getAddress()+ ";"+ member.isGenderIsFemale()+ ";"+
                    member.isActive() + ";" + member.isCompetitiveSwimmer());
        }
    }

    public void loadListOfMembers() throws FileNotFoundException { //Læser fra en fil
        Scanner sc = new Scanner(new File("members.txt")).useDelimiter(";");
        while(sc.hasNextLine()) {
            String name = sc.next();
            int age = sc.nextInt();
            String address = sc.next();
            boolean isGenderIsFemale = sc.nextBoolean();
            boolean  isActive =sc.nextBoolean();
            boolean isCompetitiveSwimmer = sc.nextBoolean();

            Members member = new Members(name,age,address,isGenderIsFemale,isActive,isCompetitiveSwimmer);

            allMembers.add(member);
        }
    }*/


    public void removeMemberFromMemberList(Members member) {
        allMembers.remove(member);
    }

    public ArrayList<Members> getAllMembers() {
        return allMembers;
    }

    public ArrayList<Members> getJuniors() {
        return juniors;

    }

    public ArrayList<Members> getSeniors() {
        return seniors;
    }

    public ArrayList<Members> getPassiveMembers() {
        return passiveMembers;
    }
    public ArrayList<Members> getPentionist()
    {
        return pentionist;
    }



}

