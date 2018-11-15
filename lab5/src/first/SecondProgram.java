package first;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.Vector;

public class SecondProgram {
    private static final String filename1 = "C:/Users/User/Desktop/JAVA/lab5/src/scores.txt";
    private static final String filename2 = "C:/Users/User/Desktop/JAVA/lab5/src/grades.txt";

    public static void main(String[] args) {
        BufferedReader rd = null;
        int maxScore = -1, minScore = 101, cnt = 0, sum = 0;
        double avgScore = -1;
        try {
            rd = new BufferedReader(new FileReader(new File(filename1)));
            String inputline = null;
            while ((inputline = rd.readLine()) != null) {
                String[] a = inputline.split(" ");
                maxScore = Math.max(maxScore, Integer.parseInt(a[2]));
                minScore = Math.min(minScore, Integer.parseInt(a[2]));
                cnt++;
                sum += Integer.parseInt(a[2]);
            }
            avgScore = sum / cnt;
            rd.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find the file");
        } catch (IOException e) {
            System.out.println("Can't read the file");
        }
        BufferedWriter rd2 = null;
        try {
            rd2 = new BufferedWriter(new FileWriter(new File(filename2), true));
            rd2.write("Average - " + avgScore + "\n" +
                    "Maximum - " + maxScore + "\n" +
                    "Minimum - " + minScore + "\n");
            rd2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the file");
        } catch (IOException e) {
            System.out.println("IO error occurred!");
        }
    }
}
