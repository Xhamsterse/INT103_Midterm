package int102.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class MemberCard2 {

    public static final int POINTS2CASH100 = 800;
    public static final int BAHT2POINTS = 25;

    private long memberId;
    private double totalPurchaseAmount;
    private int totalPoints;
    private int numberOfRedeem;

    public MemberCard2(long idCard) {
        this.memberId = idCard;
    }

    public void buy(double purchaseAmount) {
        this.totalPurchaseAmount += purchaseAmount;
        addPoints(purchaseAmount);
    }

    private void addPoints(double purchaseOrder) {
        totalPoints += (int) (purchaseOrder / BAHT2POINTS);
    }

    public int redeem() {
        int baht = 0;
        if (getRemainingPoints() >= 800) {
            baht = 800;
            numberOfRedeem++;
           
        }
        return baht;
    }

   

    public int getRemainingPoints() {
        return totalPoints - numberOfRedeem*800;
    }

    public long getMemberId() {
        return memberId;
    }

    public double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

   

    public int getTotalPoints() {
        return totalPoints;
    }

    

    public int getUsagePoints() {
        return numberOfRedeem*800;
    }



    @Override
    public String toString() {
        return "MemberCard{" + "memberId=" + memberId
                + ", totalPurchaseAmount=" + totalPurchaseAmount + ", totalPoints=" + totalPoints
                + ", numberOfRedeem=" + numberOfRedeem + ", remainingPoints=" + getRemainingPoints() + '}';
    }

  

}
