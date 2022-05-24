import java.util.Collections;
import java.util.Comparator;

public class CompetitiveMember extends Member implements Comparable<CompetitiveMember>
{
    private double time;
    private Enum SwimmingDisciplin;

    public CompetitiveMember(String name, String dateOfBirth, String address, boolean genderIsFemale, boolean isActive, boolean isCompetitiveSwimmer, int memberID)
    {
        super(name, dateOfBirth, address, genderIsFemale, isActive, isCompetitiveSwimmer, memberID);
    }

    public void setTime(double time)
    {
        this.time = time;
    }

    public double getTime()
    {
        return time;
    }

    public void setSwimmingDisciplin(Enum swimmingDisciplin)
    {
        SwimmingDisciplin = swimmingDisciplin;
    }

    public Enum getSwimmingDisciplin()
    {
        return SwimmingDisciplin;
    }

    @Override
    public int compareTo(CompetitiveMember o)
    {
        return (int) (time - o.time);
    }
}

