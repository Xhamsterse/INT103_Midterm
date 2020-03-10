import java.util.Scanner;

public class Menu {

    private static Club[] clubs = new Club[99];
    private static int clubAmount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuNumber;
        do {
            System.out.println("<<Main Menu>>");
            System.out.println("1. New Club");
            System.out.println("2. List Clubs");
            System.out.println("3. Membership Subscribe");
            System.out.println("4. Edit Membership Information");
            System.out.println("5. Membership Unsubscribe");
            System.out.println("6. List Members");
            System.out.println("7. Exit");
            System.out.print("Enter Your Menu[1-7]: ");
            menuNumber = scanner.nextInt();
            System.out.println("");
            switch (menuNumber) {
                case 1:
                    newClub();
                    break;
                case 2:
                    listClubs();
                    break;
                case 3:
                    memberSub();
                    break;
                case 4:
                    edit();
                    break;
                case 5:
                    memberUnSub();
                    break;
                case 6:
                    listMembers();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please Enter Number 1-7 Only\n");
                    break;
            }
        } while (menuNumber != 7);
    }

    public static void newClub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter club's name: ");
        String fullName = scanner.next();
        System.out.print("Please enter club's short name: ");
        String abb = scanner.next();
        System.out.print("How many members can your club have: ");
        int amount = scanner.nextInt();
        if (amount <= 0) {
            System.out.println("Member Amount Invalid\n");
        } else {
            clubs[clubAmount++] = new Club(fullName, abb, amount);
            System.out.println("Add Club Succesfully\n");
        }
    }

    public static Club searchClub(String abb) {
        for (Club c : clubs) {
            if (c.getAbb().toLowerCase().equals(abb.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public static boolean digitChecker(long id) {
        int digit = 1;
        while (id >= 10) {
            id /= 10;
            digit++;
        }
        return digit == 11;
    }

    public static void memberSub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            if (!(club.isFull())) {
                System.out.print("Please Enter Your Student ID: ");
                long id = scanner.nextLong();
                if (digitChecker(id)) {
                    if (club.doesExist(id) < 0) {
                        System.out.print("Please Enter Your Name: ");
                        String name = scanner.next();
                        System.out.print("Please Enter Your Surname: ");
                        String surname = scanner.next();
                        System.out.print("Please Enter Your Faculty: ");
                        String faculty = scanner.next();
                        club.addMember(new Student(id, name, surname, faculty));
                        System.out.println("Student added successfully\n");
                        return;
                    } else {
                        System.out.println("Student already existed\n");
                        return;
                    }
                } else {
                    System.out.println("Invalid Student ID\n");
                    return;
                }
            } else {
                System.out.println("Club is full\n");
                return;
            }
        } else {
            System.out.println("Club not Found\n");
            return;
        }
    }

    private static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            System.out.print("Please Enter Your Student ID: ");
            long id = scanner.nextLong();
            if (digitChecker(id)) {
                if (club.doesExist(id) >= 0) {
                    System.out.print("Please Enter Your Name: ");
                    String name = scanner.next();
                    System.out.print("Please Enter Your Surname: ");
                    String surname = scanner.next();
                    System.out.print("Please Enter Your Faculty: ");
                    String faculty = scanner.next();
                    club.editMember(new Student(id, name, surname, faculty));
                    System.out.println("Student editted successfully\n");
                    return;
                } else {
                    System.out.println("Student does not exist\n");
                    return;
                }
            } else {
                System.out.println("Invalid Student ID\n");
                return;
            }
        } else {
            System.out.println("Club not Found\n");
            return;
        }
    }

    private static void memberUnSub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            System.out.print("Please Enter Your Student ID: ");
            long id = scanner.nextLong();
            if (digitChecker(id)) {
                if (club.doesExist(id) >= 0) {
                    club.removeMember(id);
                    System.out.println("Student removed successfully\n");
                    return;
                } else {
                    System.out.println("Student does not exist\n");
                    return;
                }
            } else {
                System.out.println("Invalid Student ID\n");
                return;
            }
        } else {
            System.out.println("Club not Found\n");
            return;
        }
    }

    private static void listMembers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            System.out.println("<<List of Members in " + club.getFullName() + " [" + club.getAbb() + "]>>");
            if (club.getStudentAmount() == 0) {
                System.out.println("There is no member");
            } else {
                for (int i = 0; i < club.getStudentAmount(); i++) {
                    System.out.print(i + 1 + ". ");
                    System.out.println(club.getMembers()[i].toString());
                }
            }
            System.out.println("*********************************\n");
        }
    }

    private static void listClubs() {
        System.out.println("<<List of Clubs>>");
        if (clubAmount == 0) {
            System.out.println("There is no club");
        } else {
            for (int i = 0; i < clubAmount; i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(clubs[i].toString());
            }
        }
        System.out.println("*********************************\n");
    }
}
