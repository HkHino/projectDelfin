public class CompetitiveMember extends Member
{
    private int time;
    public CompetitiveMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, int time, int memberID)
    {
        super(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer,memberID);
        this.time = time;
    }
}
