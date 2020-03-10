package int102.labExam1;

/**
 * เครื่องซื้อบัตรชมการแสดงด้วยเหรียญ สามารถซื้อบัตรได้ครั้งละหลายใบ
 */
public class TicketMachine {
    private double ticketPrice; // มูลค่าบัตร 1 ใบ
    private int numberOfTickets; // จำนวนบัตรในเครื่อง
    private int numberOfCoins; // จำนวนเหรียญ 1 บาทในเครื่อง
    private int customerCoins; // จำนวนเหรียญ 1 บาทที่ลูกค้าหยอดเข้าเครื่อง

    public TicketMachine(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public TicketMachine(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public TicketMachine(double ticketPrice, int numberOfTickets) {
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }
    
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * @return จำนวนบัตรในเครื่อง
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * @return จำนวนเหรียญในเครื่อง
     */
    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    /**
     * @return จำนวนเหรียญที่ลูกค้าหยอดเข้ามา
     */
    public int getCustomerCoins() {
        return customerCoins;
    }
    
    @Override
    public String toString() {
        return String.format(
            "TicketMachine{ticket price=%.2f, %d tickets, %d coins, customer %d coins}",
                ticketPrice,numberOfTickets,numberOfCoins,customerCoins);
    }
    
    /**
     * รับจำนวนบัตรที่ผู้ดูแลระบบเพิ่มเข้ามาในเครื่อง
     * @param tickets จำนวนบัตรที่เพิ่มเข้ามา
     */
    public void receiveTicketsFromAdmin(int tickets) {
        this.numberOfTickets += tickets;
    }
    
    /**
     * ให้เหรียญ 1 บาทในเครื่องทั้งหมดแก่ผู้ดูแลระบบ
     * @return จำนวนเหรียญ 1 บาทที่มีอยู่ในเครื่อง
     */
    public int giveAllCoinsToAdmin() {
        int coins = numberOfCoins;
        numberOfCoins = 0;
        return coins;
    }
    
    /**
     * รับจำนวนเหรียญ 1 บาทที่ลูกค้าหยอดเข้ามาในเครื่อง
     * @param coins จำนวนเหรียญ 1 บาทที่ลูกค้าหยอดเข้ามา
     */
    public void receiveCoinsFromCustomer(int coins) {
        customerCoins += coins;
    }

    /**
     * ลูกค้าต้องการซื้อบัตรด้วยเหรียญ 1 บาทที่หยอดเข้ามา
     * @param numberOfTicketsToSell จำนวนบัตรที่ต้องการซื้อ
     * @return เงินทอน โดยปัดเศษลง แต่ถ้ามีบัตรไม่พอขายหรือบัตรหมด return -1 แต่ถ้าเงินไม่พอซื้อ return -2
     */
    public int sellTicketsToCustomer(int numberOfTicketsToSell) {
        if (numberOfTickets < numberOfTicketsToSell) return -1;
        int ticketCost = (int) Math.ceil(ticketPrice * numberOfTicketsToSell);
        if (customerCoins < ticketCost) return -2;
        numberOfTickets -= numberOfTicketsToSell;
        numberOfCoins += ticketCost;
        customerCoins -= ticketCost;
        return returnCoinsToCustomer();
    }
    
    public int returnCoinsToCustomer() {
        int returnedCoins = customerCoins;
        customerCoins = 0;
        return returnedCoins;
    }
}
