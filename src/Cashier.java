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
                    System.out.println("expenses option coming soon to a program near you!");
                    //todo feature coming soon to a program near you
                    break;
                case 3:
                    paymentList();
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
        paymentchecker();
        String paymentstatus;

        for (int i = 0; i < chairmanController.getAllMembers().size(); i++) {
            if (chairmanController.getAllMembers().get(i).isHasPaid() == true)
            {
                paymentstatus= "This member has paid";
            }
            else {
                paymentstatus="This member has not paid yet";
            }
            System.out.println(chairmanController.getAllMembers().get(i).getName() + ", Payment: " +
            chairmanController.getAllMembers().get(i).getMembershipPrice() +
            " Payment status for this member is: " + paymentstatus);
        }

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

        for (int i = 0; i < chairmanController.getAllMembers().size(); i++)
        {
            int randNum = rand.nextInt((10) + 1);
            if (randNum < 2)
                hasPaid = false;
            else
                hasPaid = true;

            chairmanController.getAllMembers().get(i).setHasPaid(hasPaid);

        }
    }



}

