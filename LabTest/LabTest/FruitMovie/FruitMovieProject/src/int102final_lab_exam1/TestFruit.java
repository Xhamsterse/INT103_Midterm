/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int102final_lab_exam1;

/**
 *
 * @author Umaporn
 */
public class TestFruit {
    public static void main(String[] args) {
        Fruit a = new Fruit("Apple", 150.9, 10); 
        Fruit b = new Fruit("Banana", 48.52, 6); 
        System.out.println(a); 
        System.out.println(a.equals(b)); 
        System.out.println(a.compareTo(b)); 
 
        FruitCollection fc = new FruitCollection(2); 
        fc.addFruit("Cherry", 85.179, 8); 
        fc.addFruit("Date", 94.62, 9); 
        fc.expand(1); 
        fc.addFruit("Kiwi", 64.93, 7); 
        for (int i = 0; i < fc.getCount(); i++) {
            System.out.println("No:" + i + " :: " + fc.getFruitAt(i));
        }
        int s = fc.searchForFruitName("Date"); 
        if (s>=0) {     
            System.out.println(fc.getFruitAt(s)); 
        } 
    }
}
