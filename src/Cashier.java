import java.util.Random;

public class Cashier {
    private boolean hasPaid = false;
    private double expenses;


    private int priceJunior = 1000;
    private int priceSenior = 1600;

    private int pensionerAge = 60;
    private double pensionerDiscount = 0.75;
    private double pricePensioner = 1600 * pensionerDiscount;
    private int pricePassiveMember = 500;

    private ChairmanController chairmanController;
    private UserInterface userinterface;

    public void setChairmanController(ChairmanController chairmanController) {
        this.chairmanController = chairmanController;
    }


    public Cashier(UserInterface userinterface) {
        this.userinterface = userinterface;
    }

    public void cashierMenu() {
        boolean loop = true;

        while (loop) {
            userinterface.cashierMenu();

            switch (userinterface.returnsUserInputInt()) {
                case 1:
                    userinterface.printTotalIncome(totalExpectedIncome());
                    break;
                case 2:
                    userinterface.expenses();
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
            if (chairmanController.getSeniors().get(i).isActive() == true)
                chairmanController.getSeniors().get(i).setMembershipPrice(priceSenior);
        }

        for (int i = 0; i < chairmanController.getPensioner().size(); i++) {
            if (chairmanController.getPensioner().get(i).isActive() == true)
                chairmanController.getPensioner().get(i).setMembershipPrice(pricePensioner);
        }
    }

    public void paymentList() {
        memberPayment();
        paymentChecker();
        String paymentstatus;

        userinterface.paymentStatus();
        for (int i = 0; i < chairmanController.getAllMembers().size(); i++) {
            if (chairmanController.getAllMembers().get(i).isHasPaid() == true) {
                paymentstatus = "Has paid";
            } else {
                paymentstatus = "Not paid yet";
            }
            userinterface.printPaymentList(chairmanController.getAllMembers(),i,paymentstatus);
        }

    }

    public double totalExpectedIncome() {
        double totalIncome = 0;
        
        memberPayment();
        double memberPrice;
        for (int i = 0; i < chairmanController.getAllMembers().size(); i++) {
            memberPrice = chairmanController.getAllMembers().get(i).getMembershipPrice();
            totalIncome = totalIncome + memberPrice;
        }
        return totalIncome;

    }

    public void paymentChecker() {
        Random rand = new Random();

        for (int i = 0; i < chairmanController.getAllMembers().size(); i++) {
            int randNum = rand.nextInt((10) + 1);
            if (randNum < 2)
                hasPaid = false;
            else
                hasPaid = true;

            chairmanController.getAllMembers().get(i).setHasPaid(hasPaid);

        }
    }
}

