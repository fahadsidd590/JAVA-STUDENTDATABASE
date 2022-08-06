package studentdatabase;

import java.io.*;
public class Medstudent extends Student {
    String award;
    public String getprize() {
        sc.nextLine();
        System.out.println("Enter the  prize");
        award = sc.nextLine();
        if (award == "") {
            award = "  ";
        }
        return award;
    }

    public void addstudent(char d,String stnum, String faname, String stname, String prize) {
        try {
            char a = Character.toUpperCase(d);
            String file = "studentdata.txt";
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(a + "," + stnum + "," + faname + "," + stname + " , " + prize + ",     ,   ");
            pw.flush();
            pw.close();
            System.out.println("Data saved");
        } catch (Exception e) {
            System.out.println("data not saved " + e);
        }
    }

}
