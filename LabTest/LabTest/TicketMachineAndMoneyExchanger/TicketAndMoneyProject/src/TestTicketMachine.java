
import int102.labExam1.TicketMachine;

public class TestTicketMachine {

    public static void main(String[] args) {
        TicketMachine tm = new TicketMachine(5.5, 2);
        tm.receiveTicketsFromAdmin(3);
        tm.receiveTicketsFromAdmin(4);
        System.out.println(tm);
        tm.receiveCoinsFromCustomer(25);
        tm.receiveCoinsFromCustomer(12);
        System.out.println(tm);
        System.out.println(tm.sellTicketsToCustomer(5));
        System.out.println(tm);
        System.out.println(tm.giveAllCoinsToAdmin());
        System.out.println(tm);
    }
}
