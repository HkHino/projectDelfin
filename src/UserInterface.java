import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

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
        String userInput = scanner.nextLine().toLowerCase();
        return userInput;
    }

    public double returnsUserInputDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Error, enter number: ");
            scanner.next();
        }
        double userInput = scanner.nextDouble();
        scanner.nextLine();
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
                         
                1) View swimmers
                2) View top 5
                3) Add/change time to competitive swimmer
                4) Add/change competitive swimmer discipline
                5) Return to previous menu
                """);
    }

    public void competitiveSwimmersMenu() {
        System.out.println("""
                1) All competitive swimmers
                2) Junior swimmers
                3) Senior swimmers
                4) Pensioner swimmers
                5) Return to previous menu
                """);
    }

    public void trainerTop5Menu() {
        System.out.println("""
                1) View top junior swimmers
                2) View top senior swimmers
                3) View top pensioner swimmers
                4) View all top swimmers
                5) Return to previous menu
                """);
    }

    public void trainerDisciplines() {
        System.out.println("""
                                
                1) Butterfly
                2) Crawl
                3) Back crawl
                4) Breaststroke
                5) Return to previous menu
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

    public void chairmanMembersMenu() {
        System.out.println("""
                1) View member list
                2) Change member data/status
                3) Top 5 competitive swimmers
                4) Return to previous menu                                
                """);
    }

    public void cashierMenu() {
        System.out.println("""    
                                
                Logged in as Cashier
                                
                1) View expected income
                2) View expected expenses
                3) View payments pending/outstanding
                4) View list of members
                5) Return to previous menu
                """);
    }

    public void malakaSoftwareInc()
    {
        System.out.println("Thanks for using malaka software inc");
    }

    public void expenses()
    {
        System.out.println("expenses option coming soon to a program near you!");
    }

    public void askSwimmingTime() {
        System.out.println("Enter swimming time:");
    }

    public void addTimeConfirm() {
        System.out.println("Time has been added to register");
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

    public void askMemberActivity() {
        System.out.print("Member activity (A/P): ");
    }

    public void askIsCompetitive() {
        System.out.print("Competitive Swimmer (Yes/No):");
    }

    public void cancelSub() {
        System.out.println("Cancel Subscription");
    }

    public void currentMembersNames() {
        System.out.println("\nCurrent members:");

    }

    public void paymentStatus() {
        System.out.println("Payment status");
    }

    public void listOfAllMembers() {
        System.out.println("List of all members");
    }


    public void viewListOfMembers(ArrayList<Member> members) {

        String gender;
        String activity;
        String memberStatus;
        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).isGenderIsFemale())
                gender = "Female";
            else
                gender = "Male";

            if (members.get(i).isActive())
                activity = "Active";
            else
                activity = "Passive";

            if (members.get(i).isCompetitiveSwimmer())
                memberStatus = "Competitive Swimmer";
            else
                memberStatus = "Exerciser";

            System.out.println(members.get(i).getName() + ", " + members.get(i).getAge() + ", " +
                    activity + ", " + memberStatus + ", " + gender + ", " + members.get(i).getAddress() + ", memberID: " + members.get(i).getMemberId());
        }
    }

    public void listOfCompetitiveMembers() {
        System.out.println("List of competitive members");
    }

    public void viewListOfCompetitiveMembers(ArrayList<CompetitiveMember> members) {

        String gender;
        String activity;
        String swimmingDiscipline;
        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).isGenderIsFemale())
                gender = "Female";
            else
                gender = "Male";

            if (members.get(i).isActive())
                activity = "Active";
            else
                activity = "Passive";

            if (members.get(i).getSwimmingDiscipline() != null)
                swimmingDiscipline = ", Discipline: " + members.get(i).getSwimmingDiscipline();
            else
                swimmingDiscipline = "";


            System.out.println(members.get(i).getName() + ", " + members.get(i).getAge() + ", " +
                    activity + ", " + gender + ", " + members.get(i).getAddress() + ", memberID: " + members.get(i).getMemberId()
                    + swimmingDiscipline + ", time: " + members.get(i).getTime());
        }
    }

    public void printMember(Member member) {
        String gender;
        String activity;
        String memberStatus;
        if (member.isGenderIsFemale() == true) {
            gender = "Female";
        } else
            gender = "Male";

        if (member.isActive() == true)
            activity = "Is active";
        else
            activity = "Is passive";

        if (member.isCompetitiveSwimmer() == true)
            memberStatus = "Is competitive Swimmer";
        else
            memberStatus = "Is exerciser";

        System.out.println(member.getName() + ", " + member.getAge() + ", " +
                activity + ", " + memberStatus + ", " + gender + ", " + member.getAddress());
    }

    public void findMemberToAdjust() {
        System.out.print("Enter member name: ");
    }

    public void whatInfoToAdjust() {
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

    public void newMemberSuccessful(String name) {
        System.out.println("You have successfully added a new member!: " + name);
    }

    public void printTotalIncome(double totalIncome) {
        System.out.println(totalIncome + "kr. annual income");
    }

    public void printPaymentList(ArrayList<Member> members, int i, String paymentStatus) {

        System.out.println(members.get(i).getName() + ", Payment: " +
                members.get(i).getMembershipPrice() +
                " kr. Payment status: " + paymentStatus);
    }

    public void printMemberNamesAndID(ArrayList<Member> members) {
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).getName() + ", ID: " + members.get(i).getMemberId());
        }
    }

    public void printCompetitiveMemberNamesAndID(ArrayList<CompetitiveMember> members) {
        String discipline;
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getSwimmingDiscipline() != null) {
                discipline = ", Discipline:" + members.get(i).getSwimmingDiscipline();
            } else
                discipline = "";
            System.out.println(members.get(i).getName() + ", ID: " + members.get(i).getMemberId() + discipline);
        }
    }

    public void memberIDorName() {
        System.out.print("\nType name or member ID: ");
    }

    public void memberNotFound() {
        System.out.println("Member not found");
    }

    public void whichAgeGroup() {
        System.out.println("""
                1) Junior swimmers
                2) Senior swimmers
                3) Pensioner swimmers
                4) Return to previous menu
                """);
    }

    public void printGroupTitle(String ageGroup) {
        System.out.println(ageGroup + " competitors:");

    }

    public void displayTop5(ArrayList<CompetitiveMember> disciplines, ArrayList<CompetitiveMember> competitiveMembers) {
        for (int i = 0; i < disciplines.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (disciplines.get(i) == competitiveMembers.get(j))
                    System.out.println((i+1) + "# " + disciplines.get(i).getName() + ", ID: " + disciplines.get(i).getMemberId() + ", Time: " + disciplines.get(i).getTime());
            }

        }
    }
}
