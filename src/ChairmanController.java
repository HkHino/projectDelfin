import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ChairmanController {

    //members
    private ArrayList<Members> allMembers = new ArrayList<>();
    private ArrayList<Members> activeMembers = new ArrayList<>();
    private ArrayList<Members> passiveMembers = new ArrayList<>();
    private ArrayList<Members> competitiveSwimmers = new ArrayList<>();
    private ArrayList<Members> exercises = new ArrayList<>();
    private ArrayList<Members> seniors = new ArrayList<>();
    private ArrayList<Members> juniors = new ArrayList<>();
    private ArrayList<Members> pensioner = new ArrayList<>();

    private Userinterface userinterface;
    private Cashier cashier;

    //constructor

    public ChairmanController(Userinterface userinterface, Cashier cashier) {
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
                    adjustMembers();
                    break;
                }

                case 4: {
                    cashier.cashierMenu();
                    //todo add access to economics part
                    //todo could be done as a work around by passing just the int we wish to display
                    break;
                }

                case 5: {
                    loop = false;
                    break;
                }
            }

            saveListOfMembers();

        }

    }

    public void adjustMembers() {
        userinterface.adjustMembersMenu();
        int input = userinterface.returnsUserInputInt();

        switch (input) {
            case 1: {
                userinterface.viewListOfMembers(allMembers);
                break;
            }
            case 2: {
                findMemberToAdjust();
                break;

            }
            case 3:
                //todo top 5

        }

    }

    public void findMemberToAdjust() {
        userinterface.askFindMemberToAdjust();
        String input = userinterface.returnsUserInputString();

        for (Members member : allMembers) {
            if (input.equals(member.getName())) {
                adjustMemberInfo(member);
            }
        }
    }

    public void adjustMemberInfo(Members member) {
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

    public void signUpNewMember() {

        userinterface.askName();
        String inputName = userinterface.returnsUserInputString();

        userinterface.askAddress();
        String inputAddress = userinterface.returnsUserInputString();

        String inputDateOfBirth = "";
        while (inputDateOfBirth.length() != 10) {
            userinterface.askDateOfBirth();
            inputDateOfBirth = userinterface.returnsUserInputString();
        }


        boolean askGenderLoop = true;
        boolean genderIsFemale = true;
        while (askGenderLoop) {
            userinterface.askGender();
            String inputGenderIsFemale = userinterface.returnsUserInputString();

            switch (inputGenderIsFemale) {
                case "f": {
                    genderIsFemale = true;
                    askGenderLoop=false;
                    break;
                }
                case "m": {
                    genderIsFemale = false;
                    askGenderLoop=false;
                    break;
                }
            }
        }

            //TODO VIDERE MED FEJLHÅNDTERING
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


    public void createNewMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer) {
        Members member = new Members(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer);

        addMemberToMemberList(member);
        addMemberToArraylists(member, isActive, isCompetitiveSwimmer);

        userinterface.newMemberSuccesful(member.getName());
    }

    public void addMemberToArraylists(Members member, boolean isActive, boolean isCompetitiveSwimmer){
        addJuniorOrSenior(member.getAge(), member);
        addActiveOrPassive(isActive, member);
        addCompetitiveOrExerciser(isCompetitiveSwimmer, member);
    }

    public void addMemberToMemberList(Members member) {
        allMembers.add(member);
    }

    public void addJuniorOrSenior(int age, Members member) {
        if (age < 18)
            juniors.add(member);
        else if (age >= 18 && age <= 60) //this works as intented even though it says always true, this is simply just to make the code more readable
        {
            seniors.add(member);
        } else {
            pensioner.add(member);
        }
    }

    public void addActiveOrPassive(boolean isActive, Members member) {
        if (isActive)
            activeMembers.add(member);
        else
            passiveMembers.add(member);
    }

    public void addCompetitiveOrExerciser(boolean isCompetitiveSwimmer, Members member) {
        if (isCompetitiveSwimmer)
            competitiveSwimmers.add(member);
        else
            exercises.add(member);
    }

    public void cancelSubscription() {
        userinterface.cancelSub();
        userinterface.askName();
        String name = userinterface.returnsUserInputString();

        for (int i = 0; i < allMembers.size(); i++) {
            if (name.equals(allMembers.get(i).getName()))
                removeMemberFromMemberList(allMembers.get(i));
        }

    }

    public void removeMemberFromMemberList(Members member) {
        allMembers.remove(member);
    }

    public void saveListOfMembers() throws FileNotFoundException { //skriver til en fil
        PrintStream out = new PrintStream("members.csv");

        for (Members member : allMembers) {
            out.println(member.getName() + ";" + member.getDateOfBirth() + ";" + member.getAddress() + ";" + member.isGenderIsFemale() + ";" +
                    member.isActive() + ";" + member.isCompetitiveSwimmer());
        }
    }

    public void loadListOfMembers() throws FileNotFoundException { //Læser fra en fil
        Scanner sc = new Scanner(new File("members.csv"));
        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            //linje scanner
            Scanner lineScanner = new Scanner(line).useDelimiter(";");

            String name = lineScanner.next();
            String dateOfBirth = lineScanner.next();
            String address = lineScanner.next();
            boolean isGenderIsFemale = lineScanner.nextBoolean();
            boolean isActive = lineScanner.nextBoolean();
            boolean isCompetitiveSwimmer = lineScanner.nextBoolean();

            Members member = new Members(name, dateOfBirth, address, isGenderIsFemale, isActive, isCompetitiveSwimmer);

            allMembers.add(member);
            addMemberToArraylists(member,isActive,isCompetitiveSwimmer);
        }
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

    public ArrayList<Members> getPensioner() {
        return pensioner;
    }

}

