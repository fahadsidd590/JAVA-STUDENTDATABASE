package studentdatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class artscience  extends Student{
    String min ,maj;
    
    public String getminsub(){
        System.out.println("Enter the minor subjects");
        min = sc.next();
        sc.nextLine();
        return min;
    }
      public String getmajsub(){
        System.out.println("Enter the major subjects");
        maj = sc.next();
        sc.nextLine();
        return maj;
    }
      public void addstudent(char a ,String stnum, String faname ,String stname,String major,String minor) {
          try{
                a = Character.toUpperCase(a);
                String file = "./studentdata.txt";
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(a + "," + stnum + "," + faname + "," + stname+" ,"+major+","+minor+",  ");
                pw.flush();
                pw.close();
                System.out.println("Data saved succesfully");
                
        } catch (Exception e) {
          System.out.println("Data not saved succesfully "+e);
        }
    }
}
