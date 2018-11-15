package first;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

public class Main {
    private static final String filename1 = "C:/Users/User/Desktop/JAVA/lab5/src/scores.txt";
    private static final String filename2= "C:/Users/User/Desktop/JAVA/lab5/src/grades.txt";
    public static void main(String[] args) {
        BufferedReader rd = null;
        Vector<Student> v=new Vector<>();
        int maxScore=-5;
        try {
            rd = new BufferedReader(new FileReader(new File(filename1)));
            String inputline=null;
            while((inputline=rd.readLine())!=null){
                String[] a = inputline.split(" ");
                maxScore=Math.max(maxScore,Integer.parseInt(a[2]));
                Student s=new Student(a[0],a[1],a[2]);
                System.out.println(s.toString());
                v.add(s);
            }
            rd.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Can't find the file");
        }
        catch (IOException e) {
            System.out.println("Can't read the file");
        }
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(new File(filename2)));
            for(int i=0;i<v.size();i++){
                int score=Integer.parseInt(v.elementAt(i).getScore());
                if(score>=(maxScore-10)){
                    v.elementAt(i).setScore("A");
                }
                else if(score>=(maxScore-20)){
                    v.elementAt(i).setScore("B");
                }
                else if(score>=(maxScore-30)){
                    v.elementAt(i).setScore("C");
                }
                else if(score>=(maxScore-40)){
                    v.elementAt(i).setScore("D");
                }
                else
                    v.elementAt(i).setScore("F");
                bw.write(v.elementAt(i).toString());
                bw.newLine();
            }
            bw.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Can't find the file");
        }
        catch (IOException e) {
            System.out.println("Can't read the file");
        }

    }
}