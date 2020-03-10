package int102labExam2;

/**
 * เครื่องแลกเงินตราต่างประเทศ
 */
public class MoneyExchanger {

    private double exchangeRate; // อัตราแลกเปลี่ยน
    // ถ้า exchangeRate เป็น 0.25 แปลว่า เงิน 1 บาท แลกได้ 0.25 foreign units
    private int foreignUnits; // เงินตราต่างประเทศที่มีอยู่ในเครื่อง
    private int collectedBaht; // เงินบาทที่สะสมได้จากการแลกเงินของลูกค้า
    private int customerBaht; // เงินบาทที่ลูกค้าใส่เข้ามาเพื่อขอแลกเงินต่างประเทศ

    public MoneyExchanger(double exchangeRate, int foreignUnits) {
        this.exchangeRate = exchangeRate;
        this.foreignUnits = foreignUnits;
    }

    public MoneyExchanger(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public MoneyExchanger(int foreignUnits) {
        this.foreignUnits = foreignUnits;
    }

    /**
     * Get the value of customerBaht
     * @return the value of customerBaht
     */
    public int getCustomerBaht() {
        return customerBaht;
    }
    
    /**
     * Get the value of collectedBaht
     * @return the value of collectedBaht
     */
    public int getCollectedBaht() {
        return collectedBaht;
    }

    /**
     * Get the value of foreignUnits
     * @return the value of foreignUnits
     */
    public int getForeignUnits() {
        return foreignUnits;
    }

    /**
     * Get the value of exchangeRate
     * @return the value of exchangeRate
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Set the value of exchangeRate
     * @param exchangeRate new value of exchangeRate
     */
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return String.format("Exchanger{rate=%.2f, foreign %d units, collected %d baht, customer adds %d baht}",
                exchangeRate,foreignUnits,collectedBaht,customerBaht);
    }
    
    /**
     * รับเงินตราต่างประเทศที่ผู้ดูแลระบบเพิ่มเข้ามาในเครื่อง
     * @param foreignUnits จำนวนเงินตราต่างประเทศที่เพิ่มเข้ามา
     */
    public void receiveForeignUnitsFromAdmin(int foreignUnits) {
        this.foreignUnits += foreignUnits;
    }
    
    /**
     * ให้เงินบาทที่สะสมมาได้ทั้งหมดในเครื่องแก่ผู้ดูแลระบบ
     * @return เงินบาททั้งหมดที่มีอยู่ในเครื่อง
     */
    public int giveAllCollectedBahtToAdmin() {
        int baht = collectedBaht;
        collectedBaht = 0;
        return baht;
    }
    
    /**
     * รับเงินบาทที่ลูกค้าใส่เข้ามาในเครื่อง
     * @param baht จำนวนบาทที่ลูกค้าใส่เพิ่มเข้ามา
     */
    public void receiveBahtFromCustomer(int baht) {
        customerBaht += baht;
    }

    /**
     * ลูกค้าต้องการแลกเงินตราต่างประเทศด้วยเงินบาทที่ใส่เข้ามา
     * @param foreignUnits จำนวนเงินตราต่างประเทศที่ลูกค้าต้องการได้รับ
     * @return เงินบาทที่เหลือจากการแลก โดยปัดเศษลง 
     * แต่ถ้าเครื่องมีเงินตราต่างประเทศไม่พอให้แลกตามที่ลูกค้าต้องการ return -1 
     * หรือถ้าเครื่องมีเงินตราต่างประเทศเพียงพอ แต่ถ้าลูกค้าใส่เงินมาไม่เพียงพอ return -2
     */
    public int exchangeToForeignUnitsForCustomer(int foreignUnits) {
        if (this.foreignUnits < foreignUnits) return -1;
        int requiredBaht = (int) Math.ceil(foreignUnits / exchangeRate);
        if (customerBaht < requiredBaht) return -2;
        this.foreignUnits -= foreignUnits;
        collectedBaht += requiredBaht;
        customerBaht -= requiredBaht;
        return returnBahtToCustomer();
    }
    
    public int returnBahtToCustomer() {
        int returnedBaht = customerBaht;
        customerBaht = 0;
        return returnedBaht;
    }    

}
