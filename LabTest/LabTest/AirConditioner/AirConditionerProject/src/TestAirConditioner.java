/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class TestAirConditioner {
    public static void main(String[] args) {
        AirConditioner ac=new AirConditioner(25, 1);
        System.out.println(ac.isAirOn());
        ac.turnAirOnOff();
        System.out.println(ac);
        System.out.println("Current: "+ac.getTargetTemperature());
        ac.increaseTemperature();
        System.out.println("After Increase: "+ac.getTargetTemperature());
        ac.decreaseTemperature();
        System.out.println("After Decrease: "+ac.getTargetTemperature());
        ac.changeFanSpeed();
        System.out.println("After Set Fan Speed: "+ac);
    }
}
