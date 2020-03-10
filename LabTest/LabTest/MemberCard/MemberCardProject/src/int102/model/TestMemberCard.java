/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int102.model;

/**
 *
 * @author User
 */
public class TestMemberCard {
    public static void main(String[] args) {
        MemberCard2 mc2=new MemberCard2(123);
        mc2.buy(100000);
        System.out.println(mc2.redeem());
    }
}
