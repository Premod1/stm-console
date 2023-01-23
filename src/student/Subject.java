
package student;

import java.io.*;
import java.util.*;

class Subject {
    protected int id;
    protected String name;
    protected float fee;

    public void addSubject() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter subject id: ");
        id = sc.nextInt();
        System.out.print("Enter subject name: ");
        name = sc.next();
        System.out.print("Enter subject fee: ");
        fee = sc.nextFloat();
    }

    public void getanykey() {
        System.out.println("\n\nPress any key to back");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            FileWriter alsub = new FileWriter("alsub.txt", true);
            alsub.write(String.format("%-3d%-20s%-5.2f", id, name, fee));
            alsub.write(System.getProperty("line.separator"));
            alsub.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAll() {
        try {
            FileReader alsub = new FileReader("alsub.txt");
            BufferedReader br = new BufferedReader(alsub);
            String line;
            System.out.printf("%-3s%-20s%-5s", "id", "name", "fee");
            System.out.println();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (!parts[1].equals("x")) {
                    System.out.printf("%-3s%-20s%-5s", parts[0], parts[1], parts[2]);
                    System.out.println();
                }
            }
            alsub.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubject(int sub_id) {
        try {
            FileReader alsub = new FileReader("alsub.txt");
            BufferedReader br = new BufferedReader(alsub);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (Integer.parseInt(parts[0]) == sub_id) {
                    sb.append("0 x 0");
                } else {
                    sb.append(line);
                }
                sb.append(System.getProperty("line.separator"));
            }
            alsub.close();
            FileWriter fw = new FileWriter("alsub.txt");
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

