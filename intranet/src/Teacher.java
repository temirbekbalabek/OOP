import javafx.geometry.Pos;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class Teacher extends Employee implements Comparable, ViewAttendanceAndTranscript {
    private Vector<Student> students;
    private Vector<Course> subjects;
    private Vector<String> messages;
    Position position;

    public Teacher() {
        students = new Vector<Student>();
        subjects = new Vector<Course>();

        super.setLogin("no login");
        super.setPassword("no password");

    }


    public Teacher(String login, String password, String name, String surname, Position position, int salary, String id) {


        super(login, password, name, surname, salary, id);
        super.setLogin(login);
        super.setPassword(password);
        students = new Vector<Student>();
        subjects = new Vector<Course>();
        this.position=position;
    }

    public void addCourse(Course course) {
        subjects.add(course);
    }

    public String viewMessages(){
        String s="";
        for (int i=0;i<messages.size();++i)
            s+=messages.elementAt(i);
        return s;
    }
    public void addMessages(String s){
        messages.add(s);
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

    public void addStudentToCourse(Course course, Student student) {
        for (int i = 0; i < subjects.size(); ++i) {
            if (subjects.elementAt(i).equals(course)) {
                subjects.elementAt(i).addStudent(student);
                break;
            }
        }
    }
    public String getAllStudents(){
        String s="";
        for (int i=0;i<students.size();++i)
            s+=students.elementAt(i);
        return s;
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
    public boolean haveTeacherCourse(String name){
        boolean ok=false;
        for (int i=0;i<subjects.size();++i)
            if (subjects.elementAt(i).getName().equals(name))
                ok=true;
            return ok;
    }
    public Course getCourse(String name){
        Course course2=new Course();
        for (int i=0;i<subjects.size();++i)
            if (subjects.elementAt(i).getName().equals(name))
                course2=subjects.elementAt(i);
            return course2;
    }
    public boolean haveTeacherStudent(String id){
        boolean ok=false;
        for (int i=0;i<students.size();++i)
            if (students.elementAt(i).getId().equals(id))
                ok=true;
        return ok;
    }
    public Student getStudent(String id){
        Student student1=new Student();
        for (int i=0;i<students.size();++i)
            if (students.elementAt(i).getId().equals(id))
              student1=students.elementAt(i);
            return student1;
    }

    public void sendMessageToItSupportGuys(String s)
    {
        Executor.order.add(new Pair(this,s));
    }
    @Override
    public String getTranscript() {

        String s = "";

        return s;
    }
    @Override
    public String getAttendance(){
        String s="";

        return s;
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