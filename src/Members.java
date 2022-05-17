import java.time.LocalDateTime;
import java.util.Date;

public class Members {

    //attributes
    private String name;
    private int age;
    private String adress;
    private String dateOfBirth;
    private int membershipPrice;

    private boolean genderIsFemale;
    private boolean isActive;
    private boolean isCompetitiveSwimmer;

    //methods
    public int calculateAge() {

        int currentYear = LocalDateTime.now().getYear();
        int currentMonth = LocalDateTime.now().getMonthValue();
        int currentDay = LocalDateTime.now().getDayOfMonth();

        int year = Integer.parseInt(dateOfBirth.substring(6, 10));
        int month = Integer.parseInt(dateOfBirth.substring(3, 5));
        int day = Integer.parseInt(dateOfBirth.substring(0, 2));

        System.out.println(month);

        if (currentMonth >= month && currentDay >= day)
            age = currentYear - year;
        else
            age = currentYear - year - 1;

        return age;
    }

    //constructor
    public Members(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer)
    {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.adress = address;
        this.genderIsFemale = genderIsFemale;
        this.isActive = isActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;

        calculateAge();

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

    public int getMembershipPrice() {
        return membershipPrice;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setMembershipPrice(int membershipPrice) {
        this.membershipPrice = membershipPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenderIsFemale(boolean genderIsFemale) {
        this.genderIsFemale = genderIsFemale;
    }

    public void setCompetitiveSwimmer(boolean competitiveSwimmer) {
        isCompetitiveSwimmer = competitiveSwimmer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

