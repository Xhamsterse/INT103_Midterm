/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaarray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Khaitong Lim
 */
public class SimpleBankAccountApp {
    
    private static BankAccount accounts[] = new BankAccount[10];
    private static Scanner sc = new Scanner(System.in);
    private static int ITEM_PER_LINE = 10;
    
    public static void main(String[] args) {
        try {
            loadData();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        //printAccounts();
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    printAccounts();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    showTopFive(accounts);
                    break;
                default:
                    System.out.println(getAnsiEscapeCode("RED") + "Invalid choice, please select 0-4 ONLY");
            }
        } while (choice != 0);
    }
    
    private static String getAnsiEscapeCode(String color) {
        String escapeCode = "\u001b[0m";
        switch (color.toLowerCase()) {
            case "red":
                escapeCode = "\u001b[31m";
                break;
            case "blue":
                escapeCode = "\u001b[34m";
                break;
            case "magenta":
                escapeCode = "\u001b[34m";
                break;
            case "cyan":
                escapeCode = "\u001b[36m";
                break;
        }
        return escapeCode;
    }
    
    private static int menu() {
        System.out.println(getAnsiEscapeCode("BLUE") + "M e n u ::");
        System.out.println("--------------------------");
        System.out.println("1) List All Accounts");
        System.out.println("2) Find Account by name");
        System.out.println("3) Find Top 5 Richest");
        System.out.println("--------------------------");
        System.out.println(getAnsiEscapeCode("magenta") + "4) Deposit/Withdraw");
        System.out.println("--------------------------");
        System.out.println(getAnsiEscapeCode("RED") + "0) Exit\n");
        System.out.print("Select your choice: ");
        int selected = sc.nextInt();
        sc.nextLine();
        return selected;
    }
    
    private static void printAccounts() {
        printAccounts(SimpleBankAccountApp.accounts);
    }
    
    private static void printAccounts(BankAccount[] accounts) {
        System.out.println(getAnsiEscapeCode("cyan") + "Page #1");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < accounts.length; i++) {
            sc.reset();
            if (accounts[i] != null) {
                System.out.println(formatAccount(accounts[i]));
            }
            if ((i + 1) % ITEM_PER_LINE == 0) {
                System.out.println("------------------------------------------------");
                System.out.print("Press enter see next page, type 'stop' and press enter  to cancel... ");
                String pressKey = sc.nextLine();
                if ("stop".equalsIgnoreCase(pressKey)) {
                    break;
                }
                System.out.println("\n");
                System.out.println(getAnsiEscapeCode("cyan") + "Page #" + ((i + 1) / ITEM_PER_LINE + 1));
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
    
    private static String formatAccount(BankAccount ba) {
        return String.format("%13d : %-35s %10.2f", ba.getAccountNumber(), ba.getName(), ba.getBalance());
    }
    
    private static void loadData() throws FileNotFoundException {
        File file = new File("account.txt");
        Scanner sc = new Scanner(file);
        String line = null;
        int index = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            //System.out.println(line);
            String arrLine[] = line.split(",", 3);
            if (index >= accounts.length) {
                expandArraySize();
            }
            //System.out.println(Arrays.toString(arrLine));
            accounts[index] = new BankAccount(Long.valueOf(arrLine[0]), arrLine[1], Double.valueOf(arrLine[2]));
            index++;
        }
        accounts = compactArray(accounts, index-1);
        sc.close();
    }
    
    private static BankAccount[] compactArray(BankAccount[] bas, int last) {
        BankAccount[] temps = new BankAccount[last];
        System.arraycopy(bas,0, temps, 0, last);
        return temps ;
    }
    
    private static void expandArraySize() {
        SimpleBankAccountApp.accounts = expandArraySize(SimpleBankAccountApp.accounts);
    }
    
    private static BankAccount[] expandArraySize(BankAccount[] orgArray) {
        BankAccount[] newAccounts = new BankAccount[orgArray.length * 3 / 2 + 1];
        System.arraycopy(orgArray, 0, newAccounts, 0, orgArray.length);
        return newAccounts;
    }
    
    private static void findByName() {
        while (true) {
            System.out.print("\n\nEnter account name (enter 'exit' to stop search): ");
            String findName = sc.next();
            if ("exit".equalsIgnoreCase(findName)) {
                break;
            }
            sc.nextLine();
            BankAccount[] bas = findAllAccountByName(findName);
            if (bas == null) {
                System.out.println(findName + " does not exist !!");
            } else {
                printAccounts(bas);
            }
            System.out.println("---------------------------- ");
        }
    }
    
    private static BankAccount[] findAllAccountByName(String name) {
        BankAccount[] bankAccounts = null;
        int startIndex = 0;
        int count = 0;
        while (startIndex < accounts.length) {
            startIndex = findAccountByName(name, startIndex);
            if (startIndex >= 0) {
                if (bankAccounts == null) {
                    bankAccounts = new BankAccount[5];
                }
                if (count >= bankAccounts.length) {
                    bankAccounts = expandArraySize(bankAccounts);
                }
                bankAccounts[count++] = accounts[startIndex];
                
            } else {
                break;
            }
            startIndex++;
        }
        return bankAccounts;
    }
    
    private static int findAccountByName(String name) {
        return findAccountByName(name, 0);
    }
    
    private static int findAccountByName(String name, int startIndex) {
        int index = -1;
        for (int i = startIndex; i < accounts.length; i++) {
            if (accounts[i] == null) {
                break;
            }
            if (accounts[i].getName().toLowerCase().contains(name.toLowerCase())) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    private static void showTopFive(BankAccount[] bas) {
        BankAccount[] topFive = getTopFiveRichest(bas);
        for (int i = topFive.length-1; i >= 0; i--) {
            System.out.println(formatAccount(topFive[i]));
        }
        System.out.println("----------------------------------------");
    }  
    private static BankAccount[] getTopFiveRichest(BankAccount[] bankAccounts) {
        BankAccount[] temps = new BankAccount[bankAccounts.length];
        System.arraycopy(bankAccounts, 0, temps, 0, temps.length);
        Arrays.sort(temps);
        BankAccount result[] = Arrays.copyOfRange(temps, temps.length - 5, temps.length);
        //System.out.println(Arrays.toString(result));
        return result;
    }
}
