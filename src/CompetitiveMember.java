public class CompetitiveMember extends Member{
    private double time;
    private Enum SwimmingDisciplin;

    public CompetitiveMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, int memberID) {
        super(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer, memberID);
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setSwimmingDisciplin(Enum swimmingDisciplin) {
        SwimmingDisciplin = swimmingDisciplin;
    }

    public Enum getSwimmingDisciplin() {
        return SwimmingDisciplin;
    }

    //TODO lav en compareTo metode. Problemer med at compare doubles:(
}
