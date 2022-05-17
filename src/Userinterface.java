import java.util.ArrayList;
import java.util.Scanner;

//todo give ui a overhaul to corrent numbers in menus and other minor inconsistencies
public class Userinterface {

    Scanner scanner = new Scanner(System.in);

    //metoder til scanneren
    public int returnsUserInputInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Error, enter number: ");
            scanner.next();
        }
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }

    public String returnsUserInputString() {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public void StartMenu() {
        System.out.print("""
                
                Log in:
                1) Chairman
                2) Trainer
                3) Cashier
                4) Close program
                """);
    }

    public void trainerMenu() {
        System.out.println("""
                You are logged in as Trainer
                What would you like to do?
                               
                3) Return to previous menu
                4) View list of members
                6) View top 5 (10?) list maybe make to lists?
                7) Add time to competitive swimmer
                """);
    }

    public void chairmanMenu() {
        System.out.println("""                                
                Logged in as Chairman
                             
                 1) Sign up new member
                 2) Unregister member
                 3) Members
                 4) Economy management
                 5) Return to previous menu
                 """);
    }

    public void adjustMembersMenu() {
        System.out.println("""
                1) View member list
                2) Change member data/status
                3) Top 5 competitive swimmers
                """);
    }

    public void cashierMenu() {
        System.out.println("""    
                You are logged in as Cashier
                What would you like to do?
                
                1) View expected income
                2) View expected expenses
                3) View payments pending/outstanding
                4) View list of members
                5) Return to previous menu
                """);
    }



    public void askName() {
        System.out.print("Name: ");
    }

    public void askAddress() {
        System.out.print("Address: ");
    }

    public void askDateOfBirth() {
        System.out.print("Date of birth (xx-xx-xxxx): ");
    }

    public void askGender() {
        System.out.print("Gender (F/M): ");
    }

    public void askMemberacctivity() {
        System.out.print("Member activity (A/P): ");
    }

    public void askIsCompetitive() {
        System.out.print("Competitive Swimmer (Yes/No):");
    }

    public void cancelSub() {
        System.out.println("Cancel Subscription");
    }

    public void viewListOfMembers(ArrayList<Members> members) {
        System.out.println("List of all members");
        String gender;
        String activity;
        String memberStatus;
        for (int i = 0; i < members.size(); i++) {

            if(members.get(i).isGenderIsFemale())
                gender = "Female";
            else
                gender = "Male";

            if(members.get(i).isActive())
                activity = "Active";
            else
                activity = "Passiv";

            if(members.get(i).isCompetitiveSwimmer())
                memberStatus = "Competitive Swimmer";
            else
                memberStatus = "Exerciser";

            System.out.println(members.get(i).getName() + ", "+ members.get(i).getAge() + ", "+
                    activity + ", " + memberStatus+", "+gender+", "+ members.get(i).getAddress());
        }
    }

    public void printMember(Members member){
        System.out.println("\n"+member.getName() + ", Age:" + member.getAge() + ", Address: "+member.getAddress()+", Is active member: " +
                member.isActive() + ", Is Competitive Swimmer: " + member.isCompetitiveSwimmer()+", Female: " + member.isGenderIsFemale());

    }

    public void askFindMemberToAdjust() {
        System.out.print("Enter member name: ");

    }

    public void askWhatInfoToAdjust() {
        System.out.println("""
                
                Adjust information
                1) Name
                2) Date of birth
                3) Address
                4) Activity
                5) Competitive/exerciser
                6) Gender
                """);
    }

    public void newMemberSuccesful(String name){
        System.out.println("You have successfully added a new member!: " + name);
    }
}
