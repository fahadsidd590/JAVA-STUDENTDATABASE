package studentdatabase;

import java.io.*;

public class Result extends Student {

    String prname, tpname, numtp;

    public void addprize() {
        
        System.out.println("Enter the prize name");
        prname = sc.nextLine();
      
        System.out.println("Enter the topic name");
        tpname = sc.next();
       
        System.out.println("Enter the number of topic");
        numtp = sc.next();
        try {
            char a = Character.toUpperCase('p');
            String file = "studentdata.txt";
            //if you want to override the file you can remove the true from filewriter
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(a + "," + prname + "," + tpname + "," + numtp + ",   ,   ");
            pw.flush();
            pw.close();
            System.out.println("prize data is  saved");
        } catch (Exception e) {
            System.out.println("data not saved  " + e);
        }
        sc.nextLine();
    }

    public void saveresult(String std, String topcode, String grade, String marks) {
        try {
            char a = Character.toUpperCase('r');
            String file = "studentdata.txt";
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(a + "," + std + "," + topcode + "," + grade + "," + marks + ",       ");
            pw.flush();
            pw.close();
            System.out.println("Data saved");
        } catch (Exception e) {
            System.out.println("data not saved " + e);
        }
    }
}
