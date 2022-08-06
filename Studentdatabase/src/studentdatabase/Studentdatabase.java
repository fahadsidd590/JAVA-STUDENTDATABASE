package studentdatabase;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Collation;

public class Studentdatabase {

    public static void main(String[] args) throws FileNotFoundException {
        int n = 0;
        int sel1, sel2;
        Student bn = new Student();
        char deg;
        //for student input
        String stnum, stfam, stname, major, minor;
        //for rsult input
        String stid, topcode, grade, mark;
        artscience at = new artscience();
        Medstudent md = new Medstudent();
        Result rs = new Result();
        Scanner a = new Scanner(System.in);
        do {
            System.out.println("Please select the operation ");
            System.out.println("1)Display database");
            System.out.println("2)Add student ");
            System.out.println("3)Add Result");
            System.out.println("4)Add Prize");
            System.out.println("5)Clear file");
            System.out.println("6)Exit");
            sel1 = a.nextInt();
            switch (sel1) {
                case 1:
                    showdata();
                    break;
                case 2:
                    System.out.println("Enter the Degree (S:science , M:medical"
                            + " or A:art) ");
                    deg = a.next().charAt(0);
                    stnum = bn.getstnum();
                    if (stnum.length() < 7 || stnum.length() > 7) {
                        System.out.println("Please insert the 7 digit number");
                        break;
                    }
                    stfam = bn.getstfamname();
                    stname = bn.getstname();
                    if (deg == 'S' || deg == 's') {
                        bn.addstudent(deg, stnum, stfam, stname);
                    } else if (deg == 'M' || deg == 'M') {
                        String prize = md.getprize();
                        md.addstudent(deg, stnum, stfam, stname, prize);
                    } else if (deg == 'A' || deg == 'a') {
                        major = at.getmajsub();
                        minor = at.getminsub();
                        at.addstudent(deg, stnum, stfam, stname, major, minor);
                    }
                    break;
                case 3:
                    System.out.println("Enter student id");
                    stid = a.next();
                    System.out.println("Enter Topic code");
                    topcode = a.next();
                    System.out.println("Enter grade");
                    grade = a.next();
                    System.out.println("Enter marks");
                    mark = a.next();
                    rs.saveresult(stid, topcode, grade, mark);
                    break;
                case 4:
                    rs.addprize();
                    break;
                case 5: {
                    try {
                        clearfile();
                    } catch (IOException ex) {
                        Logger.getLogger(Studentdatabase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("file is clear");
                break;
                case 6:
                    n = 1;
                    break;
                default:
                    System.out.println("Enter correct choice between 1-4");
            }
        } while (n == 0);
    }

    public static void clearfile() throws IOException {

        String file = "studentdata.txt";
        FileWriter fw = new FileWriter(file);
        PrintWriter writer = new PrintWriter(fw);
        writer.print("");
        writer.close();

    }
    public static String[] readcol(int col, String filepath, String delimeter) {
        String data[];
        String currentline;
        ArrayList<String> coldata = new ArrayList<>();        
            try {
                FileReader fr = new FileReader(filepath);
                BufferedReader br = new BufferedReader(fr);
                int i = 0;
                while ((currentline = br.readLine()) != null) {
                    data = currentline.split(delimeter);
                    i = i + 1;
                    coldata.add(data[col]);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        
        return coldata.toArray(new String[0]);
    }

    public static void showdata() throws FileNotFoundException {
        String file = "studentdata.txt";
        String degree = "";
        Scanner s = new Scanner(new File(file));
        String Subject[] = readcol(0, file, ",");
        String id[] = readcol(1, file, ",");
        String surname[] = readcol(2, file, ",");
        String name[] = readcol(3, file, ",");
        String sub[] = readcol(4, file, ",");         
        String sub1[] = readcol(5, file, ",");
        int rst = Subject.length, pr = Subject.length;
        for (int i = 0; i < Subject.length; i++) {
            if (Subject[i].equalsIgnoreCase("R")) {
                rst = i;

                break;
            }
        }
        for (int i = 0; i < Subject.length; i++) {
            if (Subject[i].equalsIgnoreCase("P")) {
                pr = i;

                break;
            }
        }
        for (int i = 0; i < rst; i++) {

            if (Subject[i].equalsIgnoreCase("S")) {
                degree = "Science";
            } else if (Subject[i].equalsIgnoreCase("M")) {
                degree = "Medical";
            } else if (Subject[i].equalsIgnoreCase("A")) {
                degree = "Art";
            }
            if (Subject[i].equalsIgnoreCase("S") || Subject[i].equalsIgnoreCase("M")) {
                System.out.println("Academic record for " + name[i] + " " + surname[i] + " (" + id[i] + ")");
                System.out.println("Degree: " + degree);
                if (Subject[i].equalsIgnoreCase("M")) {
                    System.out.println("Prize: " + sub[i]);
                }
                for (int j = rst; j < pr; j++) {
                    if (id[j].equalsIgnoreCase(id[i])) {
                        System.out.println("" + surname[j] + "  " + name[j] + "   " + sub[j]);
                    }
                }
            } else if (Subject[i].equalsIgnoreCase("A")) {
                System.out.println("Academic record for " + name[i] + " " + surname[i] + " (" + id[i] + ")");
                System.out.println("Degree: " + degree);
                System.out.println("Major : " + sub[i]);
                System.out.println("Minor : " + sub1[i]);
            }
            System.out.println("");
            System.out.println("");

        }
    }

    public static void search() {
    }

}
