public class CompetitiveMember extends Member
{
    private int time;
    private Enum SwimmingDisciplin;

    public CompetitiveMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, int memberID)
    {
        super(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer,memberID);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setSwimmingDisciplin(Enum swimmingDisciplin) {
        SwimmingDisciplin = swimmingDisciplin;
    }

    public Enum getSwimmingDisciplin() {
        return SwimmingDisciplin;
    }
}
