public class CompetitiveMember extends Member
{
    private int time;
    public CompetitiveMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, int time)
    {
        super(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer);
        this.time = time;
    }
}
