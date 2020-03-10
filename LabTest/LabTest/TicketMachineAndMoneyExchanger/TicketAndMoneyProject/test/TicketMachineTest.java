
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import int102.labExam1.TicketMachine;

public class TicketMachineTest {

    private void compareState(String msg, TicketMachine tm, double tp, int nt, int nc, int cc) {
        assertEquals(msg+": Incorrect customerCoins",cc,tm.getCustomerCoins());
        assertEquals(msg+": Incorrect numberOfCoins",nc,tm.getNumberOfCoins());
        assertEquals(msg+": Incorrect numberOfTickets",nt,tm.getNumberOfTickets());
        assertEquals(msg+": Incorrect ticketPrice",tp,tm.getTicketPrice(),0.001);
    }
    
    @Test
    public void testConstructorsGettersSetters() {
        TicketMachine tm;
        tm = new TicketMachine(4.0,2);
        compareState("2-parameter constructor",tm,4.0,2,0,0);
        
        tm = new TicketMachine(2.0);
        compareState("constructor with ticketPrice",tm,2.0,0,0,0);

        tm = new TicketMachine(5);
        compareState("constructor with numberOfTickets",tm,0.0,5,0,0);

        tm = new TicketMachine(6);
        tm.setTicketPrice(3.5);
        compareState("ticketPrice setter",tm,3.5,6,0,0);
    }
    
    @Test 
    public void testReceiveTicketsFromAdmin() {
        TicketMachine tm = new TicketMachine(4);
        tm.receiveTicketsFromAdmin(5);
        compareState("receiveTicketsFromAdmin()", tm,0.0,9,0,0);
        tm.receiveTicketsFromAdmin(3);
        compareState("receiveTicketsFromAdmin() again",tm,0.0,12,0,0);
    }
    
    @Test
    public void testReceiveCoinsFromCustomer() {
        TicketMachine tm = new TicketMachine(0);
        tm.receiveCoinsFromCustomer(8);
        compareState("receiveCoinsFromCustomer() 1st time",tm,0.0,0,0,8);
        tm.receiveCoinsFromCustomer(11);
        compareState("receiveCoinsFromCustomer() 2nd time",tm,0.0,0,0,19);
        tm.receiveCoinsFromCustomer(7);
        compareState("receiveCoinsFromCustomer() 3rd time",tm,0.0,0,0,26);
    }

    @Test
    public void testReturnCoinsToCustomer() {
        TicketMachine tm = new TicketMachine(0);
        tm.receiveCoinsFromCustomer(5);
        compareState("returnCoinsToCustomer() - receive 1st time",tm,0.0,0,0,5);
        tm.returnCoinsToCustomer();
        compareState("returnCoinsToCustomer() - return 1st time",tm,0.0,0,0,0);
        tm.receiveCoinsFromCustomer(9);
        tm.receiveCoinsFromCustomer(14);
        compareState("returnCoinsToCustomer() - receive 2nd time",tm,0.0,0,0,23);
        tm.returnCoinsToCustomer();
        compareState("returnCoinsToCustomer() - return 2nd time",tm,0.0,0,0,0);
    }

    @Test
    public void testReturnCoinsToCustomerCheckReturnValue() {
        TicketMachine tm = new TicketMachine(0);
        tm.receiveCoinsFromCustomer(8);
        compareState("returnCoinsToCustomer() - check state before return",tm,0.0,0,0,8);
        assertEquals("returnCoinsToCustomer(): return incorrect value",8, tm.returnCoinsToCustomer());
        compareState("returnCoinsToCustomer() - check state after return",tm,0.0,0,0,0);
        tm.receiveCoinsFromCustomer(5);
        tm.receiveCoinsFromCustomer(7);
        compareState("returnCoinsToCustomer() - check state before return",tm,0.0,0,0,12);
        assertEquals("returnCoinsToCustomer(): return incorrect value",12, tm.returnCoinsToCustomer());
        assertEquals("returnCoinsToCustomer(): return incorrect value",0, tm.returnCoinsToCustomer());
        compareState("returnCoinsToCustomer() - check state after return",tm,0.0,0,0,0);
    }

    @Test
    public void testSellTicketsToCustomerNotEnoughTickets() {
        TicketMachine tm = new TicketMachine(5.0);
        tm.receiveCoinsFromCustomer(8);
        compareState("sellTicketsToCustomer() - receive coins",tm,5.0,0,0,8);
        tm.sellTicketsToCustomer(1);
        compareState("sellTicketsToCustomer() - not enough tickets",tm,5.0,0,0,8);
        
        tm.receiveCoinsFromCustomer(4);
        compareState("sellTicketsToCustomer() - receive coins",tm,5.0,0,0,12);
        tm.sellTicketsToCustomer(2);
        compareState("sellTicketsToCustomer() - not enough tickets",tm,5.0,0,0,12);
    }
    
    @Test
    public void testSellTicketsToCustomerNotEnoughTicketsCheckReturnValue() {
        TicketMachine tm = new TicketMachine(5.0);
        tm.receiveCoinsFromCustomer(8);
        compareState("sellTicketsToCustomer() - receive coins",tm,5.0,0,0,8);
        assertEquals("sellTicketsToCustomer(): return incorrect value",-1,tm.sellTicketsToCustomer(1));
        compareState("sellTicketsToCustomer() - not enough tickets",tm,5.0,0,0,8);
        
        tm.receiveCoinsFromCustomer(6);
        compareState("sellTicketsToCustomer() - receive coins",tm,5.0,0,0,14);
        assertEquals("sellTicketsToCustomer(): return incorrect value",-1,tm.sellTicketsToCustomer(3));
        compareState("sellTicketsToCustomer() - not enough tickets",tm,5.0,0,0,14);
    }
    
    @Test
    public void testSellTicketsToCustomerNotEnoughCoins() {
        TicketMachine tm = new TicketMachine(5.0,3);
        tm.receiveCoinsFromCustomer(2);
        compareState("sellTicketsToCustomer() - receive coins",tm,5.0,3,0,2);
        tm.sellTicketsToCustomer(1);
        compareState("sellTicketsToCustomer() - not enough coins",tm,5.0,3,0,2);
        tm.receiveCoinsFromCustomer(4);
        tm.receiveCoinsFromCustomer(5);
        compareState("sellTicketsToCustomer() - receive coins",tm,5.0,3,0,11);
        tm.sellTicketsToCustomer(3);
        compareState("sellTicketsToCustomer() - not enough coins",tm,5.0,3,0,11);
    }
    
    @Test
    public void testSellTicketsToCustomerNotEnoughCoinsCheckReturnValue() {
        TicketMachine tm = new TicketMachine(4.0,5);
        tm.receiveCoinsFromCustomer(3);
        compareState("sellTicketsToCustomer() - receive coins",tm,4.0,5,0,3);
        assertEquals("sellTicketsToCustomer(): return incorrect value",-2,tm.sellTicketsToCustomer(1));
        compareState("sellTicketsToCustomer() - not enough coins",tm,4.0,5,0,3);
        tm.receiveCoinsFromCustomer(5);
        tm.receiveCoinsFromCustomer(7);
        compareState("sellTicketsToCustomer() - receive coins",tm,4.0,5,0,15);
        assertEquals("sellTicketsToCustomer(): return incorrect value",-2,tm.sellTicketsToCustomer(4));
        compareState("sellTicketsToCustomer() - not enough coins",tm,4.0,5,0,15);
    }

    @Test
    public void testSellTicketsToCustomerNotEnoughCoinsWithDecimalPrice() {
        TicketMachine tm = new TicketMachine(4.5,2);
        tm.receiveCoinsFromCustomer(4);
        compareState("sellTicketsToCustomer() - receive coins",tm,4.5,2,0,4);
        assertEquals("sellTicketsToCustomer(): return incorrect value",-2,tm.sellTicketsToCustomer(1));
        compareState("sellTicketsToCustomer() - not enough coins",tm,4.5,2,0,4);
        tm.receiveCoinsFromCustomer(3);
        tm.receiveCoinsFromCustomer(1);
        compareState("sellTicketsToCustomer() - receive coins",tm,4.5,2,0,8);
        assertEquals("sellTicketsToCustomer(): return incorrect value",-2,tm.sellTicketsToCustomer(2));
        compareState("sellTicketsToCustomer() - not enough coins",tm,4.5,2,0,8);
    }

    @Test
    public void testSellTicketsToCustomerSuccess() {
        TicketMachine tm = new TicketMachine(4.0,5);
        tm.receiveCoinsFromCustomer(1);
        tm.receiveCoinsFromCustomer(3);
        compareState("sellTicketsToCustomer() - receive coins",tm,4.0,5,0,4);
        assertEquals("sellTicketsToCustomer(): return incorrect value",0,tm.sellTicketsToCustomer(1));
        compareState("sellTicketsToCustomer() - enough tickets and coins",tm,4.0,4,4,0);
        tm.receiveCoinsFromCustomer(11);
        tm.receiveCoinsFromCustomer(23);
        compareState("sellTicketsToCustomer() - receive coins",tm,4.0,4,4,34);
        assertEquals("sellTicketsToCustomer(): return incorrect value",18,tm.sellTicketsToCustomer(4));
        compareState("sellTicketsToCustomer() - enough tickets and coins",tm,4.0,0,20,0);
    }

    @Test
    public void testSellTicketsToCustomerSuccessWithDecimalPrice() {
        TicketMachine tm = new TicketMachine(6.5,8);
        tm.receiveCoinsFromCustomer(5);
        tm.receiveCoinsFromCustomer(2);
        compareState("sellTicketsToCustomer() - receive coins",tm,6.5,8,0,7);
        assertEquals("sellTicketsToCustomer(): return incorrect value",0,tm.sellTicketsToCustomer(1));
        compareState("sellTicketsToCustomer() - enough tickets and coins",tm,6.5,7,7,0);
        tm.receiveCoinsFromCustomer(17);
        tm.receiveCoinsFromCustomer(9);
        compareState("sellTicketsToCustomer() - receive coins",tm,6.5,7,7,26);
        assertEquals("sellTicketsToCustomer(): return incorrect value",6,tm.sellTicketsToCustomer(3));
        compareState("sellTicketsToCustomer() - enough tickets and coins",tm,6.5,4,27,0);
    }
    
    @Test
    public void testGiveAllCoinsToAdmin() {
        TicketMachine tm = new TicketMachine(6.0,5);
        tm.receiveCoinsFromCustomer(20);
        compareState("giveAllCoinsToAdmin() - receive coins",tm,6.0,5,0,20);
        assertEquals("giveAllCoinsToAdmin() - sell tickets",2,tm.sellTicketsToCustomer(3));
        compareState("giveAllCoinsToAdmin() - sell tickets",tm,6.0,2,18,0);
        tm.receiveCoinsFromCustomer(11);
        assertEquals("giveAllCoinsToAdmin(): return incorrect value",18,tm.giveAllCoinsToAdmin());
        compareState("giveAllCoinsToAdmin() - after return",tm,6.0,2,0,11);
    }

    @Test
    public void testToString() {
        TicketMachine tm = new TicketMachine(5.25,8);
        tm.receiveCoinsFromCustomer(20);
        tm.sellTicketsToCustomer(3);
        tm.receiveCoinsFromCustomer(7);
        assertEquals(
                "TicketMachine{ticket price=5.25, 5 tickets, 16 coins, customer 7 coins}",
                tm.toString());
    }
    
    @Test
    public void testNumberOfAttributesAndMethods() {
        Class cls = TicketMachine.class;
        assertEquals("Incorrect number of attributes",4,cls.getDeclaredFields().length);
        assertEquals("Incorrect number of constructors",3,cls.getConstructors().length);
        assertEquals("Incorrect number of methods",11,cls.getDeclaredMethods().length);
    }
    
}
