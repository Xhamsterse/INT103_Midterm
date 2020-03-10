/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class TestQuestion {
    public static void main(String[] args) {
        Question q1=new Question("What is not Java primitive data type?", 1, 4);
        q1.addChoice(1, "int");
        q1.addChoice(2, "String");
        q1.addChoice(3, "double");
       // q1.addChoice(4, "boolean");
        q1.setCorrectAnswer(new Choice(2, "String"));
        System.out.println(q1);
        System.out.println("replace: "+q1.replaceChoice(1, "long"));
        System.out.println(q1);
        System.out.println("Your answer: "+q1.checkAnswer(new Choice(2, "String")));
    }
}
