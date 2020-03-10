
import int102labExam2.MoneyExchanger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MoneyExchangerTest {

    private void compareState(String msg, MoneyExchanger cm, double xr, int fu, int baht, int cb) {
        assertEquals(msg+": Incorrect customer baht",cb,cm.getCustomerBaht());
        assertEquals(msg+": Incorrect collected baht",baht,cm.getCollectedBaht());
        assertEquals(msg+": Incorrect foreign units",fu,cm.getForeignUnits());
        assertEquals(msg+": Incorrect exchange rate",xr,cm.getExchangeRate(),0.001);
    }
    
    @Test
    public void _01_testConstructorsGettersSetters() {
        MoneyExchanger cm;
        cm = new MoneyExchanger(0.25,200);
        compareState("2-parameter constructor",cm,0.25,200,0,0);
        
        cm = new MoneyExchanger(0.20);
        compareState("constructor with exchange rate",cm,0.20,0,0,0);

        cm = new MoneyExchanger(5000);
        compareState("constructor with foreign units",cm,0.0,5000,0,0);

        cm = new MoneyExchanger(400);
        cm.setExchangeRate(0.10);
        compareState("exchangeRate setter",cm,0.10,400,0,0);
    }
    
    @Test 
    public void _02_testReceiveForeignUnitsFromAdmin() {
        MoneyExchanger cm = new MoneyExchanger(100);
        cm.receiveForeignUnitsFromAdmin(300);
        compareState("receiveForeignUnitsFromAdmin()", cm,0.0,400,0,0);
        cm.receiveForeignUnitsFromAdmin(200);
        compareState("receiveForeignUnitsFromAdmin() again",cm,0.0,600,0,0);
    }
    
    @Test
    public void _03_testReceiveCoinsFromCustomer() {
        MoneyExchanger cm = new MoneyExchanger(0);
        cm.receiveBahtFromCustomer(1000);
        compareState("receiveBahtFromCustomer() 1st time",cm,0.0,0,0,1000);
        cm.receiveBahtFromCustomer(500);
        compareState("receiveBahtFromCustomer() 2nd time",cm,0.0,0,0,1500);
        cm.receiveBahtFromCustomer(400);
        compareState("receiveBahtFromCustomer() 3rd time",cm,0.0,0,0,1900);
    }

    @Test
    public void _04_testReturnBahtToCustomer() {
        MoneyExchanger cm = new MoneyExchanger(0);
        cm.receiveBahtFromCustomer(2000);
        compareState("returnBahtToCustomer() - receive 1st time",cm,0.0,0,0,2000);
        cm.returnBahtToCustomer();
        compareState("returnBahtToCustomer() - return 1st time",cm,0.0,0,0,0);
        cm.receiveBahtFromCustomer(400);
        cm.receiveBahtFromCustomer(9000);
        compareState("returnBahtToCustomer() - receive 2nd time",cm,0.0,0,0,9400);
        cm.returnBahtToCustomer();
        compareState("returnBahtToCustomer() - return 2nd time",cm,0.0,0,0,0);
    }

    @Test
    public void _05_testReturnBahtToCustomerCheckReturnValue() {
        MoneyExchanger cm = new MoneyExchanger(0);
        cm.receiveBahtFromCustomer(2000);
        compareState("returnBahtToCustomer() - check state before return",cm,0.0,0,0,2000);
        assertEquals("returnBahtToCustomer(): return incorrect value",2000, cm.returnBahtToCustomer());
        compareState("returnBahtToCustomer() - check state after return",cm,0.0,0,0,0);
        cm.receiveBahtFromCustomer(500);
        cm.receiveBahtFromCustomer(750);
        compareState("returnBahtToCustomer() - check state before return",cm,0.0,0,0,1250);
        assertEquals("returnBahtToCustomer(): return incorrect value",1250, cm.returnBahtToCustomer());
        assertEquals("returnBahtToCustomer(): return incorrect value",0, cm.returnBahtToCustomer());
        compareState("returnBahtToCustomer() - check state after return",cm,0.0,0,0,0);
    }

    @Test
    public void _06_testExchangeToForeignUnitsForCustomerNotEnoughForeignUnits() {
        MoneyExchanger cm = new MoneyExchanger(0.10);
        cm.receiveBahtFromCustomer(1000);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.10,0,0,1000);
        cm.exchangeToForeignUnitsForCustomer(100);
        compareState("exchangeToForeignUnitsForCustomer() - not enough foreign units",cm,0.10,0,0,1000);
        
        cm.receiveForeignUnitsFromAdmin(200);
        compareState("exchangeToForeignUnitsForCustomer() - receive foreign units",cm,0.10,200,0,1000);
        cm.exchangeToForeignUnitsForCustomer(300);
        compareState("exchangeToForeignUnitsForCustomer() - not enough foreign units",cm,0.10,200,0,1000);
    }
    
    @Test
    public void _07_testExchangeToForeignUnitsForCustomerNotEnoughForeignUnitsCheckReturnValue() {
        MoneyExchanger cm = new MoneyExchanger(100);
        cm.receiveBahtFromCustomer(1000);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0,100,0,1000);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",-1,cm.exchangeToForeignUnitsForCustomer(200));
        compareState("exchangeToForeignUnitsForCustomer() - not enough foreign units",cm,0,100,0,1000);
        
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",-1,cm.exchangeToForeignUnitsForCustomer(101));
        compareState("exchangeToForeignUnitsForCustomer() - not enough foreign units",cm,0,100,0,1000);
    }
    
    @Test
    public void _08_testExchangeToForeignUnitsForCustomerNotEnoughBaht() {
        MoneyExchanger cm = new MoneyExchanger(0.20,400);
        cm.receiveBahtFromCustomer(1000);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.20,400,0,1000);
        cm.exchangeToForeignUnitsForCustomer(300);
        compareState("exchangeToForeignUnitsForCustomer() - not enough baht",cm,0.20,400,0,1000);
        cm.receiveBahtFromCustomer(500);
        cm.receiveBahtFromCustomer(250);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.20,400,0,1750);
        cm.exchangeToForeignUnitsForCustomer(400);
        compareState("exchangeToForeignUnitsForCustomer() - not enough baht",cm,0.20,400,0,1750);
    }
    
    @Test
    public void _09_testExchangeToForeignUnitsForCustomerNotEnoughBahtCheckReturnValue() {
        MoneyExchanger cm = new MoneyExchanger(0.20,500);
        cm.receiveBahtFromCustomer(1000);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.20,500,0,1000);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",-2,cm.exchangeToForeignUnitsForCustomer(400));
        compareState("exchangeToForeignUnitsForCustomer() - not enough baht",cm,0.20,500,0,1000);
    }

    @Test
    public void _10_testExchangeToForeignUnitsForCustomerNotEnoughBahtWithDecimalPrice() {
        MoneyExchanger cm = new MoneyExchanger(0.35,3000);
        cm.receiveBahtFromCustomer(571);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.35,3000,0,571);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",-2,cm.exchangeToForeignUnitsForCustomer(200));
        compareState("exchangeToForeignUnitsForCustomer() - not enough coins",cm,0.35,3000,0,571);
    }

    @Test
    public void _11_testExchangeToForeignUnitsForCustomerSuccess() {
        MoneyExchanger cm = new MoneyExchanger(0.50,5000);
        cm.receiveBahtFromCustomer(1000);
        cm.receiveBahtFromCustomer(3000);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.50,5000,0,4000);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",0,cm.exchangeToForeignUnitsForCustomer(2000));
        compareState("exchangeToForeignUnitsForCustomer() - state after exchange",cm,0.50,3000,4000,0);
        cm.receiveBahtFromCustomer(400);
        cm.receiveBahtFromCustomer(1600);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.50,3000,4000,2000);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",1300,cm.exchangeToForeignUnitsForCustomer(350));
        compareState("exchangeToForeignUnitsForCustomer() - state after exchange",cm,0.50,2650,4700,0);
    }

    @Test
    public void _12_testExchangeToForeignUnitsForCustomerSuccessWithDecimalPrice() {
        MoneyExchanger cm = new MoneyExchanger(0.36,4500);
        cm.receiveBahtFromCustomer(3500);
        cm.receiveBahtFromCustomer(2000);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.36,4500,0,5500);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",4388,cm.exchangeToForeignUnitsForCustomer(400));
        compareState("exchangeToForeignUnitsForCustomer() - state after exchange",cm,0.36,4100,1112,0);
        cm.receiveBahtFromCustomer(250);
        cm.receiveBahtFromCustomer(1125);
        compareState("exchangeToForeignUnitsForCustomer() - receive baht",cm,0.36,4100,1112,1375);
        assertEquals("exchangeToForeignUnitsForCustomer(): return incorrect value",611,cm.exchangeToForeignUnitsForCustomer(275));
        compareState("exchangeToForeignUnitsForCustomer() - state after exchange",cm,0.36,3825,1876,0);
    }
    
    @Test
    public void _13_testGiveAllCollectedBahtToAdmin() {
        MoneyExchanger cm = new MoneyExchanger(0.20,1000);
        cm.receiveBahtFromCustomer(2000);
        compareState("giveAllCollectedBahtToAdmin() - receive baht",cm,0.20,1000,0,2000);
        assertEquals("giveAllCollectedBahtToAdmin() - exchange to foreign units",1500,cm.exchangeToForeignUnitsForCustomer(100));
        compareState("giveAllCollectedBahtToAdmin() - after exchange to foreign units",cm,0.20,900,500,0);
        cm.receiveBahtFromCustomer(1500);
        assertEquals("giveAllCollectedBahtToAdmin(): return incorrect value",500,cm.giveAllCollectedBahtToAdmin());
        compareState("giveAllCollectedBahtToAdmin() - after giving all collected baht",cm,0.20,900,0,1500);
    }

    @Test
    public void _14_testToString() {
        MoneyExchanger cm = new MoneyExchanger(0.10,300);
        cm.receiveBahtFromCustomer(1500);
        cm.exchangeToForeignUnitsForCustomer(100);
        cm.receiveBahtFromCustomer(150);
        assertEquals(
                "Exchanger{rate=0.10, foreign 200 units, collected 1000 baht, customer adds 150 baht}",
                cm.toString());
    }
    
    @Test
    public void _15_testNumberOfAttributesAndMethods() {
        Class cls = MoneyExchanger.class;
        assertEquals("Incorrect number of attributes",4,cls.getDeclaredFields().length);
        assertEquals("Incorrect number of constructors",3,cls.getConstructors().length);
        assertEquals("Incorrect number of methods",11,cls.getDeclaredMethods().length);
    }
    
}
