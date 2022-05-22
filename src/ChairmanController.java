import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ChairmanController {

    //members
    private ArrayList<Member> allMembers = new ArrayList<>();
    private ArrayList<Member> activeMembers = new ArrayList<>();
    private ArrayList<Member> passiveMembers = new ArrayList<>();
    private ArrayList<CompetitiveMember> competitiveSwimmers = new ArrayList<>();
    private ArrayList<Member> exercises = new ArrayList<>();
    private ArrayList<Member> seniors = new ArrayList<>();
    private ArrayList<Member> juniors = new ArrayList<>();
    private ArrayList<Member> pensioner = new ArrayList<>();

    private Userinterface userinterface;
    private Cashier cashier;
    private int lastIDnumber;
    private int memberNumberGen = 0;

    //constructor
    public ChairmanController(Userinterface userinterface, Cashier cashier) throws FileNotFoundException {
        this.userinterface = userinterface;
        this.cashier = cashier;
    }

    public void chairmanMenu() throws FileNotFoundException {
        boolean loop = true;
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
                    adjustMembersMenu();
                    break;
                }
                case 4: {
                    cashier.cashierMenu();
                    break;
                }
                case 5: {
                    loop = false;
                    break;
                }
            }
        }

    }

    public void adjustMembersMenu() {
        userinterface.adjustMembersMenu();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: {
                userinterface.listOfAllMembers();
                userinterface.viewListOfMembers(allMembers);
                break;
            }
            case 2: {
                findMemberToAdjust();
                break;

            }
            case 3:
                //todo top 5
            case 4:
                break;
        }

    }

    public void findMemberToAdjust() {
        userinterface.askFindMemberToAdjust();
        String input = userinterface.returnsUserInputString();

        for (Member member : allMembers) {
            if (input.equals(member.getName().toLowerCase())) {
                adjustMemberInfo(member);
            }
        }
    }

    public void adjustMemberInfo(Member member) {
        userinterface.printMember(member);
        userinterface.askWhatInfoToAdjust();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: {
                userinterface.askName();
                String name = userinterface.returnsUserInputString();
                member.setName(name);
                break;
            }
            case 2: {
                userinterface.askDateOfBirth();
                String date = userinterface.returnsUserInputString();
                member.setDateOfBirth(date);
                break;
            }
            case 3: {
                userinterface.askAddress();
                String address = userinterface.returnsUserInputString();
                member.setAddress(address);
                break;
            }
            case 4: {
                member.setActive(!member.isActive());
                break;
            }
            case 5: {
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

    public void signUpNewMember() throws FileNotFoundException {


        userinterface.askName();
        String inputName = userinterface.returnsUserInputString();

        userinterface.askAddress();
        String inputAddress = userinterface.returnsUserInputString();

        //input der er fejlhåndteret har sin egen metode
        String inputDateOfBirth = dateOfBirth();
        boolean genderIsFemale = genderIsFemale();
        boolean isActive = isActive();
        boolean isCompetitiveSwimmer = isCompetitiveSwimmer();
        double time = 0;


        createNewMember(inputName, inputDateOfBirth, inputAddress, genderIsFemale, isActive, isCompetitiveSwimmer, time);

    }

    public String dateOfBirth() {
        String inputDateOfBirth = "";
        while (inputDateOfBirth.length() != 10) {
            userinterface.askDateOfBirth();
            inputDateOfBirth = userinterface.returnsUserInputString();
        }
        return inputDateOfBirth;
    }

    public boolean genderIsFemale() {
        boolean askGenderLoop = true;
        while (askGenderLoop) {
            userinterface.askGender();
            String inputGenderIsFemale = userinterface.returnsUserInputString().toLowerCase();

            switch (inputGenderIsFemale) {
                case "f": {
                    return true;
                }
                case "m": {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isActive() {
        boolean askActivityLoop = true;
        while (askActivityLoop) {
            userinterface.askMemberactivity();
            String inputActivity = userinterface.returnsUserInputString().toLowerCase();

            switch (inputActivity) {
                case "a": {
                    return true;
                }
                case "p": {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isCompetitiveSwimmer() {
        boolean askIsCompetitiveLoop = true;
        while (askIsCompetitiveLoop) {
            userinterface.askIsCompetitive();
            String inputEliteSwimmer = userinterface.returnsUserInputString().toLowerCase();

            switch (inputEliteSwimmer) {
                case "yes", "y": {
                    return true;
                }
                case "no", "n": {
                    return false;
                }
            }
        }
        return false;
    }


    public void createNewMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, double time) throws FileNotFoundException {
        memberNumberGen = loadLastIDnumber();
        System.out.println(memberNumberGen);

        if (isCompetitiveSwimmer)
        {
            System.out.println("your best swim time is: "+ time);
        }
        else
        {
            System.out.println("swimming time N/A");
        }

        if (isCompetitiveSwimmer) {
            CompetitiveMember competitiveMember = new CompetitiveMember(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer, memberNumberGen);
            memberNumberGen++;
            saveLastIDnumber(memberNumberGen); //saver til fil
            competitiveMember.setTime(0.0);
            addMemberToMemberList(competitiveMember); //All Members
            addMemberToArraylists(competitiveMember, isActive, isCompetitiveSwimmer); //Andre member arrays

            userinterface.newMemberSuccessful(competitiveMember.getName()); //printer ny member
        } else {

            Member member = new Member(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer, memberNumberGen);
            memberNumberGen++;
            saveLastIDnumber(memberNumberGen); //saver til fil
            addMemberToMemberList(member);
            addMemberToArraylists(member, isActive, isCompetitiveSwimmer);

            userinterface.newMemberSuccessful(member.getName());
        }
    }

    public void addMemberToArraylists(Member member, boolean isActive, boolean isCompetitiveSwimmer) {
        addJuniorOrSenior(member.getAge(), member);
        addActiveOrPassive(isActive, member);
        addCompetitiveOrExerciser(isCompetitiveSwimmer, member);
    }

    public void addMemberToMemberList(Member member) {
        allMembers.add(member);
    }

    public void addJuniorOrSenior(int age, Member member) {
        if (age < 18)
            juniors.add(member);
        else if (age >= 18 && age <= 60) //this works as intented even though it says always true, this is simply just to make the code more readable
        {
            seniors.add(member);
        } else {
            pensioner.add(member);
        }
    }

    public void addActiveOrPassive(boolean isActive, Member member) {
        if (isActive)
            activeMembers.add(member);
        else
            passiveMembers.add(member);
    }

    public void addCompetitiveOrExerciser(boolean isCompetitiveSwimmer, Member member) {
        if (member instanceof CompetitiveMember)
            competitiveSwimmers.add((CompetitiveMember) member);
        else
            exercises.add(member);
    }

    public void cancelSubscription() {

        userinterface.cancelSub();
        userinterface.currentMembersNames();
        userinterface.printMemberNamesAndID(allMembers);

        System.out.println();
        userinterface.askMemberIDorName();
        String nameOrID = userinterface.returnsUserInputString();

        findMemberIDorName(nameOrID);
    }

    public void findMemberIDorName(String nameOrID) {
        try {
            int memberId = (Integer.parseInt(nameOrID));
            for (int i = 0; i < allMembers.size(); i++) {
                if (memberId == allMembers.get(i).getMemberId())
                    removeMemberFromMemberList(allMembers.get(i));
            }
        } catch (Exception e) {
            for (int i = 0; i < allMembers.size(); i++) {
                if (nameOrID.equals(allMembers.get(i).getName().toLowerCase()))
                    removeMemberFromMemberList(allMembers.get(i));
            }
        }

    }

    public void removeMemberFromMemberList(Member member) {
        allMembers.remove(member);
    }

    public void saveListOfMembers() throws FileNotFoundException { //skriver til en fil
        PrintStream out = new PrintStream("members.csv");

        for (Member member : allMembers) {
            if (member instanceof CompetitiveMember) {
                out.println(member.getName() + ";" + member.getDateOfBirth() + ";" + member.getAddress() + ";" + member.isGenderIsFemale() + ";" +
                        member.isActive() + ";" + member.isCompetitiveSwimmer() + ";" + member.getMemberId() + ";" + ((CompetitiveMember) member).getSwimmingDisciplin() + ";" + ((CompetitiveMember) member).getTime());
            } else {
                out.println(member.getName() + ";" + member.getDateOfBirth() + ";" + member.getAddress() + ";" + member.isGenderIsFemale() + ";" +
                        member.isActive() + ";" + member.isCompetitiveSwimmer() + ";" + member.getMemberId()) ;
            }
        }
    }

    public void loadListOfMembers() throws FileNotFoundException { //Læser fra en fil
        Scanner sc = new Scanner(new File("members.csv"));
        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            //linje scanner
            Scanner lineScanner = new Scanner(line).useDelimiter(";");
            if (lineScanner.hasNext()) {
                String name = lineScanner.next();
                String dateOfBirth = lineScanner.next();
                String address = lineScanner.next();
                boolean isGenderIsFemale = lineScanner.nextBoolean();
                boolean isActive = lineScanner.nextBoolean();
                boolean isCompetitiveSwimmer = lineScanner.nextBoolean();
                int memberId = lineScanner.nextInt();

                if (isCompetitiveSwimmer) {
                    CompetitiveMember competitiveMember = new CompetitiveMember(name, dateOfBirth, address, isGenderIsFemale, isActive, isCompetitiveSwimmer, memberId);

                    if (lineScanner.hasNext()) {
                        SwimmingDisciplines swimmingDiscipline = null;
                        switch (lineScanner.next()) {
                            case "BUTTERFLY":
                                swimmingDiscipline = SwimmingDisciplines.BUTTERFLY;
                                break;
                            case "CRAWL":
                                swimmingDiscipline = SwimmingDisciplines.CRAWL;
                                break;
                            case "BACKCRAWL":
                                swimmingDiscipline = SwimmingDisciplines.BACKCRAWL;
                                break;
                            case "BREASTSTROKE":
                                swimmingDiscipline = SwimmingDisciplines.BREASTSTROKE;
                                break;
                        }
                        competitiveMember.setSwimmingDisciplin(swimmingDiscipline);

                       // double time = lineScanner.nextDouble(); //TODO fejl i læsning af double. Den læser punktummer istedet for komma.
                       // System.out.println(time);
                       // competitiveMember.setTime(time);

                    }

                    allMembers.add(competitiveMember);
                    addMemberToArraylists(competitiveMember, isActive, isCompetitiveSwimmer);
                } else {
                    Member member = new Member(name, dateOfBirth, address, isGenderIsFemale, isActive, isCompetitiveSwimmer, memberId);
                    allMembers.add(member);
                    addMemberToArraylists(member, isActive, isCompetitiveSwimmer);
                }
            }
        }
    }

    public void saveLastIDnumber(int MemberNumberGen) throws FileNotFoundException {
        PrintStream out = new PrintStream("memberID.txt");
        out.print(MemberNumberGen);
    }

    public int loadLastIDnumber() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("memberID.txt"));
        while (sc.hasNextLine()) {
            lastIDnumber = sc.nextInt();
        }
        return lastIDnumber;
    }

    public ArrayList<Member> getAllMembers() {
        return allMembers;
    }

    public ArrayList<Member> getJuniors() {
        return juniors;

    }

    public ArrayList<Member> getSeniors() {
        return seniors;
    }

    public ArrayList<Member> getPassiveMembers() {
        return passiveMembers;
    }

    public ArrayList<Member> getPensioner() {
        return pensioner;
    }

    public ArrayList<CompetitiveMember> getCompetitiveSwimmers() {
        return competitiveSwimmers;
    }
}

