import javax.xml.crypto.Data;
import java.io.DataInput;
import java.io.Serializable;
import java.util.*;

public class Course {
    private String name, id;
    private Teacher teacher;
    private Faculty faculty;
    private int yearOfStudy;
    private HashMap<Date, HashMap<Student, Boolean>> attendance;
    private Vector<Student> students = new Vector<>();
    private Vector<CourseFile> courseFiles;
    private int credit;

    //Vector<CourseFile> courseFile;
    public Course() {

    }


    public Course(String name, String id, Teacher teacher, int credit, Faculty faculty, int yearOfStudy) {
        this.name = name;
        this.teacher = teacher;
        this.credit = credit;
        this.id = id;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        courseFiles = new Vector<CourseFile>();
    }
    public void addCourseFile(String name,String body){
        courseFiles.add(new CourseFile(name,body));
    }
    public void attendance(Date date, Student student, boolean attendedOrNot) {
        HashMap<Student, Boolean> a = attendance.get(student);
        a.put(student, attendedOrNot);
        attendance.put(date, a);
    }

    public String viewAttendance(Date date) {
        String s = "";
        HashMap<Student, Boolean> a = new HashMap<>();
        for (int i = 0; i < students.size(); ++i) {
            if (a.get(students.get(i)) == true)
                s += students.elementAt(i) + " attended\n";
            else
                s += students.elementAt(i) + " not attended\n";
        }
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {

        this.teacher = teacher;
    }

    public Vector<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public int getCreditsNumber() {

        return credit;

    }

    public String getMarkForStudent(Student student) {
        String s = "";
        for (int i = 0; i < students.size(); ++i) {
            if (students.elementAt(i).equals(student)) {
                Student student2 = students.elementAt(i);
                s += "Name of course: " + name + "\n" + "Number of GPA: " + credit + "\n";
                break;
            }
        }
        return s;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }


    public void setCreditsNumber(int creditsNumber) {
        this.credit = creditsNumber;
    }

    public String viewCourseFiles() {
        String s = "";
        for (int i = 0; i < courseFiles.size(); ++i) {
            s += courseFiles.elementAt(i);
        }
        return s;
    }

    public String OpenCourseFile(String name) {
        String s = "";
        for (int i = 0; i < courseFiles.size(); ++i) {
            if (courseFiles.elementAt(i).getName().equals(name)) {
                s += courseFiles.elementAt(i);
                break;
            }
        }
        return s;
    }


    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        else {
            Course course2 = (Course) obj;
            if (this.id.equals(course2.id))
                return true;
            else
                return false;
        }
    }


    @Override
    public String toString() {
        return "Name of course: " + name + "\n" +
                "Teacher of course: " + teacher + "\n" +
                "Course id: " + id;

    }

}
