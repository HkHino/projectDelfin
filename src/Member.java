import java.time.LocalDateTime;

public class Member {

    //attributes
    private String name;
    private int memberId;
    private int age;
    private String address;
    private String dateOfBirth;
    private double membershipPrice;

    private boolean genderIsFemale;
    private boolean isActive;
    private boolean isCompetitiveSwimmer;
    private boolean hasPaid;

    //methods
    public void calculateAge() {

        int currentYear = LocalDateTime.now().getYear();
        int currentMonth = LocalDateTime.now().getMonthValue();
        int currentDay = LocalDateTime.now().getDayOfMonth();

        int year = Integer.parseInt(dateOfBirth.substring(6, 10));
        int month = Integer.parseInt(dateOfBirth.substring(3, 5));
        int day = Integer.parseInt(dateOfBirth.substring(0, 2));

        if (currentMonth >= month && currentDay >= day)
            age = currentYear - year;
        else
            age = currentYear - year - 1;
    }

    //constructor
   /* public Member(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer)
    {
        this.name = name;

        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.genderIsFemale = genderIsFemale;
        this.isActive = isActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;

        calculateAge();
    }

    */

    public Member(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, int numberGen)
    {
        this.name = name;

        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.genderIsFemale = genderIsFemale;
        this.isActive = isActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.memberId = numberGen;

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
        return address;
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

    public double getMembershipPrice() {
        return membershipPrice;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setMembershipPrice(double membershipPrice) {
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setHasPaid(boolean hasPaid)
    {
        this.hasPaid = hasPaid;
    }
    public boolean isHasPaid()
    {
        return hasPaid;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }
}
