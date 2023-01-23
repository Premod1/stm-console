package student;

import java.util.Scanner;

public class Main {

    public static void stuManage() {
        Student stu = new Student();
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add new student");
            System.out.println("2. Add subject to student");
            System.out.println("3. Show all subject");
            System.out.println("4. Show Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Update Student");
            System.out.println("7. Exite");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    stu.addNew();
                    stu.save();
                    break;
                case 2:
                    stu.addSubject();
                    break;
                case 3:
                    stu.showAll();
                    break;
                case 4:
                    stu.showStudent();
                    break;
                case 5:
                    System.out.print("Enter student id to delete: ");
                    int st_id = sc.nextInt();
                    stu.deleteStudent(st_id);
                    break;
                case 6:
                    System.out.print("Enter student id to update: "); 
                    int stuid = sc.nextInt();
                    stu.update(stuid);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

    }

    public static void paymentMenu() {

        Payments pay = new Payments();
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add payment");
            System.out.println("2. Show payments");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    pay.addPayment();
                    break;
                case 2:
                    pay.showPayments();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
        public static boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        // replace the hardcoded values with actual user credentials
        if (username.equals("thushirini") && password.equals("thushirini")) {
            System.out.println("Login successful!");
             mainMenu();
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }


    public static void mainMenu() {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Student management");
            System.out.println("2. Subject management");
            System.out.println("3. Payments management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    stuManage();
                    break;
                case 2:
                    subManage();
                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void subManage() {
        Subject sub = new Subject();
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add subject");
            System.out.println("2. Show all subjects");
            System.out.println("3. Delete subject");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sub.addSubject();
                    sub.save();
                    break;
                case 2:
                    sub.showAll();
                    break;
                case 3:
                    System.out.print("Enter subject id to delete: ");
                    int sub_id = sc.nextInt();
                    sub.deleteSubject(sub_id);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
       
        login();
    }
}
