import java.util.ArrayList;
import java.util.Scanner;

public class Userinterface
{

    Scanner scanner = new Scanner(System.in);

    //metoder til scanneren
    public int returnsUserInputInt()
    {
        while (!scanner.hasNextInt())
        {
            System.out.print("Error, enter number: ");
            scanner.next();
        }
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }

    public String returnsUserInputString()
    {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public void StartMenu()
    {
        System.out.print("""
                Log in:
                1) Formand
                2) Trainer
                3) Kassér
                """);
    }

    public void trainerMenu()
    {
        System.out.println("""
                what would you like to do?
                               
                3) return to previous menu       
                4) view list of members               
                6) view top 5 (10?) list maybe make to lists?
                7) Add time to competitive swimmer
                                
                """);
    }

    public void chairmanMenu()
    {
        System.out.println("""
                                
                Logged in as FORMAND
                             
                 1) Sign up new member
                 2) Unregister member
                 3) Return to previous menu  
                 4) Members
                 
                 //VIRKER IKKE ENDNU     
                 5) save list of members to file
                 6) view top 5 (10?) list maybe make to lists?
                 7) view payments
                 8) view expenses
                 9) view balance left """);
    }

    public void kasserMenu()
    {
        System.out.println("""              
                what would you like to do?  
                                            
                3) return to previous menu  
                4) view list of members""");
    }

    public void askName()
    {
        System.out.print("Name: ");
    }

    public void askAddress()
    {
        System.out.print("Address: ");
    }

    public void askDateOfBirth()
    {
        System.out.print("Date of birth (xx-xx-xxxx): ");
    }

    public void askGender()
    {
        System.out.print("Gender (F/M): ");
    }

    public void askMemberacctivity()
    {
        System.out.print("Member activity (A/P): ");
    }

    public void askIsCompetitive()
    {
        System.out.print("Competitive Swimmer (Yes/No):");
    }

    public void cancelSub()
    {
        System.out.println("Cancel Subscription");
    }

    public void viewListOfMembers(ArrayList<Members> members)
    {
        System.out.println("List of all members");
        for (int i = 0; i < members.size(); i++)
        {
            System.out.println(members.get(i).getName() + ", Age:" + members.get(i).getAge() + ", Is active member: " +
                    members.get(i).isActive() + ", is competitive Swimmer: " + members.get(i).isCompetitiveSwimmer());

        }
    }
}
