import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class Teacher extends Employee implements Comparable {
    private Vector<Student> students;
    private Vector<Course> subjects;


    public Teacher() {
        students = new Vector<Student>();
        subjects = new Vector<Course>();

        super.setLogin("no login");
        super.setPassword("no password");

    }

    public void addCourse(Course course) {
        subjects.add(course);
    }

    public Teacher(String login, String password, String name, String surname, int salary, Position position, String id) {


        super(login, password, name, surname, salary, position, id);
        super.setLogin("no login");
        super.setPassword("no password");
        students = new Vector<Student>();
        subjects = new Vector<Course>();


    }


    public String viewCourse() {
        String s = "";
        for (int i = 0; i < subjects.size(); ++i)
            s = s + subjects.elementAt(i);
        return s;
    }

    public void removeCourse(Course course) {
        for (int i = 0; i < subjects.size(); ++i)
            if (subjects.elementAt(i).equals(course)) {
                subjects.removeElementAt(i);
                return;
            }
    }

    public String getStudentsInCourse(Course course) {
        String s = "";
        for (int i = 0; i < subjects.size(); ++i) {
            if (subjects.elementAt(i).equals(course)) {
                Vector<Student> students = (subjects.elementAt(i)).getStudents();
                for (int j = 0; j < students.size(); ++j)
                    s = s + students.elementAt(j);
                break;

            }
        }
        return s;
    }

    public void AddStudentToCourse(Course course, Student student) {
        for (int i = 0; i < subjects.size(); ++i) {
            if (subjects.elementAt(i).equals(course)) {
                subjects.elementAt(i).addStudent(student);
                break;
            }
        }
    }

    public void putMarkToStudentInCourse(Course course, Student student, double mark) {
        for (int i = 0; i < subjects.size(); ++i) {
            if (subjects.elementAt(i).equals(course)) {
                Vector<Student> students = (subjects.elementAt(i)).getStudents();
                for (int j = 0; j < students.size(); ++j) {
                    if (students.elementAt(j).equals(student)) {
                        students.elementAt(j).setMark(course, mark);
                        break;
                    }
                }
                break;

            }
        }
    }
    public void sendMessageToItSupportGuys(String s)
    {
        Executor.order.add(new Pair(this,s));
    }
    @Override
    public int compareTo(Object o){
        Teacher teacher=(Teacher)o;
        return super.getName().compareTo(teacher.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        else
            return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}