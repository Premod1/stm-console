package student;

import java.io.*;
import java.util.*;

class Payments {

    private int stuid;
    private int subid;
    private String subname;
    private float fee;
    private float paid;
    private float due;

    public void addPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student id: ");
        stuid = sc.nextInt();
        System.out.print("Enter subject id: ");
        subid = sc.nextInt();
        System.out.print("Enter amount paid: ");
        paid = sc.nextFloat();
        try {
            FileReader alsub = new FileReader("alsub.txt");
            BufferedReader br = new BufferedReader(alsub);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (Integer.parseInt(parts[0]) == subid) {
                    subname = parts[1];
                    fee = Float.parseFloat(parts[2]);
                    break;
                }
            }
            alsub.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        due = fee - paid;
        try {
            FileWriter pay = new FileWriter("payments.txt", true);
            pay.write(String.format("%-5d%-3d%-20s%-5.2f%-5.2f%-5.2f", stuid, subid, subname, fee, paid, due));
            pay.write(System.getProperty("line.separator"));
            pay.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPayments() {
        try {
            FileReader pay = new FileReader("payments.txt");
            BufferedReader br = new BufferedReader(pay);
            String line;
            System.out.printf("%-5s%-3s%-20s%-5s%-5s%-5s", "stuid", "subid", "subname", "fee", "paid", "due");
            System.out.println();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                System.out.printf("%-5s%-3s%-20s%-5s%-5s%-5s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                System.out.println();
            }
            pay.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
