import java.util.Random;

public class Kassér {

    private boolean hasPaid = false;
    private double expenses;

    private int priceJunior = 1000;
    private int priceSenior = 1600;

    private int pensionistAge = 65;
    private int pensionerDiscount= 100-25;
    private int pricePensionist = (1600*pensionerDiscount)/100;
    private int pricePassiveMember = 500;


    private Userinterface userinterface;
    private Formand formand;



    public Kassér(Userinterface userinterface, Formand formand) {
        this.userinterface = userinterface;
        this.formand = formand;
    }


    public void memberPayment() {

        for (int i = 0; i < formand.getPassiveMembers().size() ; i++) {
            formand.getPassiveMembers().get(i).setMembershipPrice(pricePassiveMember);
        }

        for (int i = 0; i < formand.getJuniors().size(); i++) {
            if(formand.getJuniors().get(i).isActive()==true)
                formand.getJuniors().get(i).setMembershipPrice(priceJunior);
        }

        for (int i = 0; i < formand.getSeniors().size(); i++) {
            if(formand.getSeniors().get(i).getAge()<pensionistAge)
                formand.getSeniors().get(i).setMembershipPrice(priceSenior);
            else
                formand.getSeniors().get(i).setMembershipPrice(pricePensionist);
        }
    }

    public void paymentList(){
        memberPayment();

        for (int i = 0; i < formand.getAllMembers().size(); i++) {
            System.out.println(formand.getAllMembers().get(i).getName() + ", Payment: " +
                    formand.getAllMembers().get(i).getMembershipPrice());
        }

    }
    public void totalExpectedIncome()
    {
        int amountOfMembersJunior = formand.getJuniors().size();
        int amountOfMembersSenior = formand.getSeniors().size();
        int amountOfMembersPassive = formand.getPassiveMembers().size();
        int amountOfMembersPensionists = formand.getPentionist().size();

        int incomePassiveMembers = amountOfMembersPassive * pricePassiveMember;
        int incomeMembersJunior = amountOfMembersJunior * priceJunior;
        int incomeMembersSenior = amountOfMembersSenior * priceSenior;
        int incomeMembersPensionists = amountOfMembersPensionists * pricePensionist;

        int totalIncome = incomeMembersSenior + incomeMembersJunior + incomePassiveMembers + incomeMembersPensionists;
        System.out.println(totalIncome+ "kr");
    }

    public void randomGen() {
        Random rand = new Random();
        int randNum = rand.nextInt((10)+1);
        if (randNum > 2)
            hasPaid = false;
        else
            hasPaid = true;
    }

}

