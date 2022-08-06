package studentdatabase;

import java.io.*;
import java.util.Scanner;
public class Student {

    Scanner sc = new Scanner(System.in);
    String stnum, famname, stname;
    public String getstnum() {
        System.out.println("Enter student number");
        stnum = sc.next();
        sc.nextLine();
        return stnum;
    }
    public String getstfamname() {
        System.out.println("Enter student family name");
        famname = sc.next();
        sc.nextLine();
        return famname;
    }
    public String getstname() {
        System.out.println("Enter student  name ");
        stname = sc.nextLine();
//        System.out.print("Enter student  name "+stname);
        return stname;
    }
    public void showinfo() {
        System.out.println("The student number is " + stnum);
        System.out.println("The student name is " + stname);
        System.out.println("The student family name is " + famname);
    }
    public void addstudent(char a, String stnum, String faname, String stname) {
        try {
            a = Character.toUpperCase(a);
            String file = "studentdata.txt";
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(a + "," + stnum + "," + faname + "," + stname + ", " + "  ,     ");
            pw.flush();
            pw.close();
            System.out.println("Data saved succesfully");
        } catch (Exception e) {
            System.out.println("Data not saved succesfully");

        }
    }

}
