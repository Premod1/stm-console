package student;

import java.io.*;
import java.util.*;

class Student extends Subject {

    private int stuid;
    private String stuname;
    private int stuage;
    private String stuaddress;
    private String subject;
    private String stgender;

    public void addNew() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        stuid = sc.nextInt();
        System.out.print("Enter name: ");
        stuname = sc.next();
        System.out.print("Enter age: ");
        stuage = sc.nextInt();
        System.out.print("M or F: ");
        stgender = sc.next();
        System.out.print("Enter address: ");
        stuaddress = sc.next();
    }
   public void showStudent() {
    try {
        FileReader alstu = new FileReader("alstu.txt");
        BufferedReader br = new BufferedReader(alstu);
        String line;
        System.out.printf("%-5s%-20s%-3s%-2s%-30s", "ID", "NAME", "AGE", "GENDER", "ADDRESS");
        System.out.println();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            System.out.printf("%-5s%-20s%-3s%-2s%-30s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            System.out.println();
        }
        alstu.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public void save() {
        try {
            FileWriter alstu = new FileWriter("alstu.txt", true);
            alstu.write(String.format("%-5d%-20s%-3d%-2s%-30s", stuid, stuname, stuage,stgender, stuaddress));
            alstu.write(System.getProperty("line.separator"));
            alstu.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addSubject() {
        int subid;
        int sid;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student id: ");
        sid = sc.nextInt();
        System.out.println("Select subject\n");
        showAll();
        System.out.print("\nEnter subject id: ");
        subid = sc.nextInt();
        try {
            FileWriter student_subject = new FileWriter("stu_sub.txt", true);
            student_subject.write(String.format("%-5d%-3d", sid, subid));
            student_subject.write(System.getProperty("line.separator"));
            student_subject.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteStudent(int st_id) {
    try {
        FileReader alstu = new FileReader("alstu.txt");
        BufferedReader br = new BufferedReader(alstu);
        ArrayList<String> students = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            if (Integer.parseInt(parts[0]) != st_id) {
                students.add(line);
            }
        }
        alstu.close();
        if (students.size() < 1) {
            return false;
        }
        FileWriter alstu_temp = new FileWriter("alstu_temp.txt");
        for (String student : students) {
            alstu_temp.write(student);
            alstu_temp.write(System.getProperty("line.separator"));
        }
        alstu_temp.close();
        File alstuFile = new File("alstu.txt");
        File alstuTempFile = new File("alstu_temp.txt");
        alstuFile.delete();
        alstuTempFile.renameTo(alstuFile);
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
    
    

    public boolean update(int stuid) {
    try {
        FileReader alstu = new FileReader("alstu.txt");
        BufferedReader br = new BufferedReader(alstu);
        ArrayList<String> students = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            if (Integer.parseInt(parts[0]) != stuid) {
                students.add(line);
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter new name: ");
                String newName = sc.next();
                System.out.print("Enter new age: ");
                int newAge = sc.nextInt();
                System.out.print("Enter new address: ");
                String newAddress = sc.next();
                System.out.print("M or F: ");
                String newGender = sc.next();
                String newLine = String.format("%-5d%-20s%-3d%-2s%-30s", stuid, newName, newAge,newGender, newAddress);
                students.add(newLine);
            }
        }
        alstu.close();
        if (students.size() < 1) {
            return false;
        }
        FileWriter alstu_temp = new FileWriter("alstu_temp.txt");
        for (String student : students) {
            alstu_temp.write(student);
            alstu_temp.write(System.getProperty("line.separator"));
        }
        alstu_temp.close();
        File alstuFile = new File("alstu.txt");
        File alstuTempFile = new File("alstu_temp.txt");
        alstuFile.delete();
        alstuTempFile.renameTo(alstuFile);
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
   
    }
    }

    public void getStudentSubjects(int s_id, boolean forPayments) {
        int subid;
        int sid;
        try {
            FileReader stu_sub = new FileReader("stu_sub.txt");
            BufferedReader br = new BufferedReader(stu_sub);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                sid = Integer.parseInt(parts[0]);
                if (s_id == sid) {
                    subid = Integer.parseInt(parts[1]);
                    FileReader subs = new FileReader("alsub.txt");
                    BufferedReader subbr = new BufferedReader(subs);
                    String subline;
                    while ((subline = subbr.readLine()) != null) {
                        String[] subparts = subline.split(" ");
                        if (Integer.parseInt(subparts[0]) == subid) {
                            System.out.println(subparts[1]);
                            if (forPayments) {
// code for displaying and updating payment information
                            }
                        }
                    }
                    subs.close();
                }
            }
            stu_sub.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


