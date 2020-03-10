/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class TestShuttleBus {
    public static void main(String[] args) {
        ShuttleBus sb=new ShuttleBus();
        sb.setBusId("B#001");
        sb.lockDoors();
        sb.addPassengers(7);
        sb.go();
        sb.go();
        sb.go();
       
        sb.resetMoney();
        System.out.println(sb);
    }
}
