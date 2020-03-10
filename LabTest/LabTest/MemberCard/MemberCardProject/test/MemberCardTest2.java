/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import int102.model.MemberCard2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class MemberCardTest2 {

    private MemberCard2 mcActual;

    public MemberCardTest2() {
        mcActual = new MemberCard2(123456789L);
    }
    @Test
    public void createObjectWithInitalIdCardtoMemberId(){
        assertEquals(123456789L, mcActual.getMemberId());
    }
    @Test
    public void firstOrderLessThan25BahtAddToPurchaseOrderOnly() {

        mcActual.buy(20);
        assertEquals(20, mcActual.getTotalPurchaseAmount(), 0.001);
        assertEquals(0, mcActual.getTotalPoints());
        assertEquals(0, mcActual.getRemainingPoints());
        assertEquals(0, mcActual.getUsagePoints());
    }

    @Test
    public void firstOrderEqualTo25BahtAddToPurchaseOrderAndAdd1Point() {

        mcActual.buy(25);

        assertEquals(25, mcActual.getTotalPurchaseAmount(), 0.001);
        assertEquals(1, mcActual.getTotalPoints());
        assertEquals(1, mcActual.getRemainingPoints());
        assertEquals(0, mcActual.getUsagePoints());

    }

    @Test
    public void nextOrder50000BahtAddToPurchaseOrderAndAdd2000Points() {

        mcActual.buy(25);
        mcActual.buy(50000);
        assertEquals(50025, mcActual.getTotalPurchaseAmount(), 0.001);
        assertEquals(2001, mcActual.getTotalPoints());
        assertEquals(2001, mcActual.getRemainingPoints());
        assertEquals(0, mcActual.getUsagePoints());

    }

    @Test
    public void firstRedeem() {

        mcActual.buy(25);
        mcActual.buy(50000);
        mcActual.redeem();
        assertEquals(50025, mcActual.getTotalPurchaseAmount(), 0.001);
        assertEquals(2001, mcActual.getTotalPoints());
        assertEquals(1201, mcActual.getRemainingPoints());
        assertEquals(800, mcActual.getUsagePoints());

    }

    @Test
    public void nextRedeem() {

        mcActual.buy(25);
        mcActual.buy(50000);
        mcActual.redeem();
        mcActual.redeem();

        assertEquals(50025, mcActual.getTotalPurchaseAmount(), 0.001);
        assertEquals(2001, mcActual.getTotalPoints());
        assertEquals(1600, mcActual.getUsagePoints());
        assertEquals(401, mcActual.getRemainingPoints());
  

    }

  

    @Test
    public void nextCanNotRedeemOverRemainingPoints() {

        mcActual.buy(25);
        mcActual.buy(50000);
        mcActual.buy(1500);
        mcActual.redeem();
        mcActual.redeem();
        mcActual.redeem();
        assertEquals(51525, mcActual.getTotalPurchaseAmount(), 0.001);
        assertEquals(2061, mcActual.getTotalPoints());
        assertEquals(1600, mcActual.getUsagePoints());
        assertEquals(461, mcActual.getRemainingPoints());

    }
    
    public void oneRedeemReturn100Baht(){
        mcActual.buy(100000);
        assertEquals(100,  mcActual.redeem());
    }
    
    public void oneRedeemReturn0Baht(){
        mcActual.buy(10000);
        assertEquals(0,  mcActual.redeem());
    }
    
   
}
