import java.time.LocalDateTime;
import java.util.Date;

public class Members {

    //attributes
    private String name;
    private int age;  //todo make method that calculate birthdays automatically and adjusts system.
    private String adress;
    private Date dayOfBirth;
    private int membershipPrice;

    private boolean genderIsFemale;
    private boolean isActive;
    private boolean isCompetitiveSwimmer;

    //methods
    public void calculateAge() {
        String dateOfBirth = "17-05-1986";

        int currentYear = LocalDateTime.now().getYear();
        int currentMonth = LocalDateTime.now().getMonthValue();
        int currentDay = LocalDateTime.now().getDayOfMonth();

        int year = Integer.parseInt(dateOfBirth.substring(6, 10));
        int month = Integer.parseInt(dateOfBirth.substring(3, 5));
        int day = Integer.parseInt(dateOfBirth.substring(0, 2));

        System.out.println(month);

        int age;
        if (currentMonth >= month && currentDay >= day)
            age = currentYear - year;
        else
            age = currentYear - year - 1;

        System.out.println("age: " + age);
    }

    //constructor
    public Members(String name, int age, String adress, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer)
    {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.genderIsFemale = genderIsFemale;
        this.isActive = isActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
    }

    public int getAge()
    {
        return age;
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return adress;
    }

    public boolean isGenderIsFemale(){
        return genderIsFemale;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isCompetitiveSwimmer() {
        return isCompetitiveSwimmer;
    }

    public void setMembershipPrice(int membershipPrice) {
        this.membershipPrice = membershipPrice;
    }

    public int getMembershipPrice() {
        return membershipPrice;
    }

    public void getDate(){

    }

}

