import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ChairmanController
{

    //attributes


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
    private Cashier cashier;

    //constructor
//
    public ChairmanController(Userinterface userinterface, Cashier cashier)
    {
        this.userinterface = userinterface;
        this.cashier=cashier;
    }

    public void chairmanMenu() throws FileNotFoundException
    {
        boolean loop = true;
        while (loop)
        {
            userinterface.chairmanMenu();
            int input = userinterface.returnsUserInputInt();

            switch (input)
            {
                case 1:
                {
                    signUpNewMember();
                    break;
                }
                case 2:
                {
                    cancelSubscription();
                    break;
                }
                case 3:
                { //todo check if return to previous menu works
                   /* userinterface.StartMenu();
                    //return to previous menu*/
                    loop = false;
                    break;
                }

                case 4:{
                    adjustMembers();
                    break;
                }

                case 5:{
                    cashier.cashierMenu();
                    //todo add acces to economics part
                    break;
                }
            }

            saveListOfMembers();

        }

    }

    public void adjustMembers()
    {
        userinterface.adjustMembersMenu();
        int input = userinterface.returnsUserInputInt();

        switch (input)
        {
            case 1:
            {
                userinterface.viewListOfMembers(allMembers);
                break;
            }
            case 2:
            {
                findMemberToAdjust();

            }
            case 3:
                //todo top 5

        }

    }

    public void findMemberToAdjust(){
        userinterface.askFindMemberToAdjust();
        String input = userinterface.returnsUserInputString();

        for (Members member: allMembers) {
            if(input.equals(member.getName())){
                adjustMemberInfo(member);
            }
        }
    }

    public void adjustMemberInfo(Members member){
        userinterface.printMember(member);
        userinterface.askWhatInfoToAdjust();
       int input = userinterface.returnsUserInputInt();

       switch (input){
           case 1:{
               userinterface.askName();
               String name = userinterface.returnsUserInputString();
               member.setName(name);
               break;
           }
           case 2:{
               userinterface.askDateOfBirth();
               String date = userinterface.returnsUserInputString();
               member.setDateOfBirth(date);
               break;
           }
           case 3:{
               userinterface.askAddress();
               String address = userinterface.returnsUserInputString();
               member.setAddress(address);
               break;
           }
           case 4:{
               member.setActive(!member.isActive());
               break;
           }
           case 5:{
               member.setCompetitiveSwimmer(!member.isCompetitiveSwimmer());
               break;
           }

           case 6: {
               member.setGenderIsFemale(!member.isGenderIsFemale());
               break;
           }
       }

       userinterface.printMember(member);

    }

    public void signUpNewMember() {

        userinterface.askName();
        String inputName = userinterface.returnsUserInputString();

        userinterface.askAddress();
        String inputAddress = userinterface.returnsUserInputString();

        userinterface.askDateOfBirth();
        String inputDateOfBirth = userinterface.returnsUserInputString();

        userinterface.askGender();
        String inputGenderIsFemale = userinterface.returnsUserInputString();
        boolean genderIsFemale;
        if (inputGenderIsFemale.equalsIgnoreCase("F"))
        {
            //System.out.println("you're a girl");
            genderIsFemale = true;
        }
        else
        { //todo fejlhåndtering
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

        createNewMember(inputName, inputDateOfBirth, inputAddress, genderIsFemale, isActive, isCompetitiveSwimmer);

    }

    public void createNewMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer)
    {
        Members member = new Members(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer);

        addMemberToMemberList(member);

        addJuniorOrSenior(member.getAge(), member);
        addActiveOrPassive(isActive, member);
        addCompetitiveOrExerciser(isCompetitiveSwimmer, member);


        System.out.println("You have successfully added a new member!: " + member.getName());
    }

    public void addMemberToMemberList(Members member)
    {
        allMembers.add(member);
    }

    public void addJuniorOrSenior(int age, Members member)
    {
        if (age < 18)
            juniors.add(member);
        else if (age >= 18 && age <= 60) //this works as intented even though it says always true, this is simply just to make the code more readable
        {
            seniors.add(member);
        }
        else
        {
            pentionist.add(member);
        }
    }

    public void addActiveOrPassive(boolean isActive, Members member)
    {
        if (isActive)
            activeMembers.add(member);
        else
            passiveMembers.add(member);
    }

    public void addCompetitiveOrExerciser(boolean isCompetitiveSwimmer, Members member)
    {
        if (isCompetitiveSwimmer)
            competetiveSwimmers.add(member);
        else
            exercicsers.add(member);
    }

    public void cancelSubscription()
    {
        userinterface.cancelSub();
        userinterface.askName();
        String name = userinterface.returnsUserInputString();

        for (int i = 0; i < allMembers.size(); i++)
        {
            if (name.equals(allMembers.get(i).getName()))
                removeMemberFromMemberList(allMembers.get(i));
        }

    }

    public void removeMemberFromMemberList(Members member)
    {
        allMembers.remove(member);
    }

    public void saveListOfMembers() throws FileNotFoundException
    { //skriver til en fil
        PrintStream out = new PrintStream("members.txt");

        for (Members member : allMembers)
        {
            out.println(member.getName() + ";" + member.getDateOfBirth() + ";" + member.getAddress() + ";" + member.isGenderIsFemale() + ";" +
                    member.isActive() + ";" + member.isCompetitiveSwimmer());
        }
    }
    //todo find an adult to help figure out why this isnt working as intented?
    public void loadListOfMembers() throws FileNotFoundException
    { //Læser fra en fil
        Scanner sc = new Scanner(new File("members.txt")).useDelimiter(";");
        while (sc.hasNextLine())
        {
            String name = sc.next();
            String dateOfBirth = sc.next();
            String address = sc.next();
            boolean isGenderIsFemale = sc.nextBoolean();
            boolean isActive = sc.nextBoolean();
            boolean isCompetitiveSwimmer = sc.nextBoolean();

            Members member = new Members(name, dateOfBirth, address, isGenderIsFemale, isActive, isCompetitiveSwimmer);

            allMembers.add(member);
        }
    }

    public ArrayList<Members> getAllMembers()
    {
        return allMembers;
    }

    public ArrayList<Members> getJuniors()
    {
        return juniors;

    }

    public ArrayList<Members> getSeniors()
    {
        return seniors;
    }

    public ArrayList<Members> getPassiveMembers()
    {
        return passiveMembers;
    }

    public ArrayList<Members> getPentionist()
    {
        return pentionist;
    }

}

