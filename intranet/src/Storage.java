import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class Storage implements Serializable {
    public static Vector<Student> students;
    public static Vector<Teacher> teachers;
    public static Vector<Manager> managers;
    public void addStudentToCourse(Student student,Course course){
            int index=students.indexOf(student);
            students.elementAt(index).addSubject(course);
            Teacher teacher=course.getTeacher();
            index=teachers.indexOf(teacher);
            teachers.elementAt(index).AddStudentToCourse(course,student);
    }
    public void saveStudents() {
        try {

            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("students.out"));
            o.writeObject(students);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void saveTeachers() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("teachers.out"));
            o.writeObject(teachers);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public void saveManagers() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("managers.out"));
            o.writeObject(managers);
            o.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
