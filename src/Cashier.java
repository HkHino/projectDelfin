import java.util.Random;

public class Cashier {
    private boolean hasPaid = false;
    private double expenses;


    private int priceJunior = 1000;
    private int priceSenior = 1600;

    private int pensionistAge = 65;
    private int pensionerDiscount = 100 - 25;
    private int pricePensionist = (1600 * pensionerDiscount) / 100;
    private int pricePassiveMember = 500;


    private Userinterface userinterface;

    public void setChairmanController(ChairmanController chairmanController)
    {
        this.chairmanController = chairmanController;
    }

    private ChairmanController chairmanController;

    public Cashier(Userinterface userinterface) {
        this.userinterface = userinterface;


    }

    public void cashierMenu() {
        boolean loop = true;
        userinterface.loggedInAsCashier();

        while (loop) {
            userinterface.cashierMenu();

            switch (userinterface.returnsUserInputInt()) {
                case 1:
                    totalExpectedIncome();
                    break;
                case 2:
                    //todo feature coming soon to a program near you
                    break;
                case 3:
                    paymentchecker(); //todo attatch to members list, attatch random checker to members to simulate irl payment issues
                    break;
                case 4:
                    userinterface.viewListOfMembers(chairmanController.getAllMembers());
                    break;
                case 5:

                    loop = false;
                    break;
            }
        }
    }

    public void memberPayment() {

        for (int i = 0; i < chairmanController.getPassiveMembers().size(); i++) {
            chairmanController.getPassiveMembers().get(i).setMembershipPrice(pricePassiveMember);
        }

        for (int i = 0; i < chairmanController.getJuniors().size(); i++) {
            if (chairmanController.getJuniors().get(i).isActive() == true)
                chairmanController.getJuniors().get(i).setMembershipPrice(priceJunior);
        }

        for (int i = 0; i < chairmanController.getSeniors().size(); i++) {
            if (chairmanController.getSeniors().get(i).getAge() < pensionistAge)
                chairmanController.getSeniors().get(i).setMembershipPrice(priceSenior);
            else
                chairmanController.getSeniors().get(i).setMembershipPrice(pricePensionist);
        }
    }

    public void paymentList() {
        memberPayment();

        for (int i = 0; i < chairmanController.getAllMembers().size(); i++) {
            System.out.println(chairmanController.getAllMembers().get(i).getName() + ", Payment: " +
                    chairmanController.getAllMembers().get(i).getMembershipPrice());
        } //todo attatch random roller to this here class

    }

    public void totalExpectedIncome() {
        int amountOfMembersJunior = chairmanController.getJuniors().size();
        int amountOfMembersSenior = chairmanController.getSeniors().size();
        int amountOfMembersPassive = chairmanController.getPassiveMembers().size();
        int amountOfMembersPensionists = chairmanController.getPensioner().size();

        int incomePassiveMembers = amountOfMembersPassive * pricePassiveMember;
        int incomeMembersJunior = amountOfMembersJunior * priceJunior;
        int incomeMembersSenior = amountOfMembersSenior * priceSenior;
        int incomeMembersPensionists = amountOfMembersPensionists * pricePensionist;

        int totalIncome = incomeMembersSenior + incomeMembersJunior + incomePassiveMembers + incomeMembersPensionists;
        System.out.println(totalIncome + "kr");
    }

    public void paymentchecker() {
        Random rand = new Random();
        int randNum = rand.nextInt((10) + 1);
        if (randNum > 2)
            hasPaid = false;
        else
            hasPaid = true;
    }

}

