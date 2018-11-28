import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class Storage implements Serializable {
    public static Vector<Student> students=new Vector<>();
    public static Vector<Teacher> teachers=new Vector<>();
    public static Vector<Manager> managers=new Vector<>();
    public static Vector<Executor> executors=new Vector<>();
    public void addStudentToCourse(Student student,Course course){
            int index=students.indexOf(student);
            students.elementAt(index).addSubject(course);
            Teacher teacher=course.getTeacher();
            index=teachers.indexOf(teacher);
            teachers.elementAt(index).addStudentToCourse(course,student);
    }
    public static void saveStudents() {
        try {

            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("students.out"));
            o.writeObject(students);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void saveExecutors() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("executors.out"));
            o.writeObject(executors);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void saveTeachers() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("teachers.out"));
            o.writeObject(teachers);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public static void saveManagers() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("managers.out"));
            o.writeObject(managers);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void deserialize(){
        try{
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("students.out"));
            students = (Vector<Student>)o.readObject();
            o.close();
            ObjectInputStream o1=new ObjectInputStream(new FileInputStream("teachers.out"));
            teachers = (Vector<Teacher>)o1.readObject();
            o1.close();
            ObjectInputStream o2=new ObjectInputStream(new FileInputStream("managers.out"));
            managers = (Vector<Manager>)o2.readObject();
            o2.close();
            ObjectInputStream o3=new ObjectInputStream(new FileInputStream("executors.out"));
            executors = (Vector<Executor>)o3.readObject();
            o3.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void serialize(){
        saveExecutors();
        saveTeachers();
        saveStudents();
        saveManagers();
    }
}
