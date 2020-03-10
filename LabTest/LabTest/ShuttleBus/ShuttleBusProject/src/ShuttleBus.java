/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class ShuttleBus {
    private String busId;
    private int frontDoor;
    private int rearDoor;
    private int noOfPassengers;
    private int odometer;
    private int money;

    public ShuttleBus() {
    }

    public ShuttleBus(String busId) {
        this.busId = busId;
    }

    public ShuttleBus(String busId, int odometer) {
        this.busId = busId;
        this.odometer = odometer;
    }

    public ShuttleBus(String busId, int odometer, int money) {
        this.busId = busId;
        this.odometer = odometer;
        this.money = money;
    }
    
    
    public String getBusId(){
        return busId;
    }
    public void setBusId(String busId){
        this.busId=busId;
    }
    public void closeFrontDoor(){
        frontDoor=1;
    }
    public void openFrontDoor(){
        frontDoor=0;
        
    }
    public void closesRearDoor(){
        rearDoor=1;
    }
    
    public void openRearDoor(){
        rearDoor=0;
    }
    public void lockDoors(){
        frontDoor=2;
        rearDoor=2;
        
    }
    public void addPassengers(int passengers){
        noOfPassengers=passengers;
        incrementMoney(passengers*7);
        
    }
    public void incrementMoney(int money){
        this.money=money;
    }
    public int getMoney(){
        return this.money;
    }
    public void go(){
        incrementOdometer();
    }
    public void incrementOdometer(){
        odometer+=800;
    }
    public void resetMoney(){
        this.money=0;
    }

    @Override
    public String toString() {
        return "ShuttleBus{" + "busId=" + busId + ", frontDoor=" + frontDoor + ", rearDoor=" + rearDoor + ", noOfPassengers=" + noOfPassengers + ", odometer=" + odometer + ", money=" + money + '}';
    }
    
}
