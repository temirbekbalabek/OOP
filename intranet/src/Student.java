import java.util.Vector;

import java.util.HashMap;

public class Student extends User implements Comparable, ViewAttendanceAndTranscript {
    private boolean isPassed;
    private int yearOfStudy;
    private HashMap<Course, Double> marks;
    private double GPA;
    private Faculty faculty;
    private Vector<Course> current = new Vector<>();
    private Vector<Course> passed = new Vector<>();


    public Student() {

        super.setId("no id");
        ;
        super.setLogin("no login");
        super.setPassword("no password");
        marks = new HashMap<>();

    }

    public Student(String surname, String name, String login, String id, String password, int yearOfStudy, Faculty faculty) {
        super(login, password, name, surname, id);
        super.setId(id);
        this.yearOfStudy = yearOfStudy;
        this.faculty = faculty;
    }

    public void setMark(Course course, Double mark) {
        if (hasSubject(course)) {
            marks.put(course, Math.min(100, marks.get(course)));
        }
    }

    public boolean hasSubject(Course course) {
        for (int i = 0; i < current.size(); ++i) {

            if (course.equals(current.elementAt(i))) {
                return true;
            }

        }
        return false;
    }

    public void registrationForCourse(Course course) {
        current.add(course);
    }

    public String viewMarkForSpecificCourse() {
        String s = "";
        return s;
    }

    public double getMark(Course course) {
        if (hasSubject(course) == true) {
            return marks.get(course);
        } else
            return -1;

    }

    public Course getCourse(String name){
        Course course2=new Course();
        for (int i=0;i<current.size();++i)
            if (current.elementAt(i).getName().equals(name))
                course2=current.elementAt(i);
        return course2;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void addSubject(Course course) {
        this.current.add(course);
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void viewCurrentCourse() {

        for (int i = 0; i < passed.size(); ++i)
            System.out.println(passed.elementAt(i));
    }

    public String viewAllCourse() {
        String s = "";
        for (int i = 0; i < Storage.teachers.size(); ++i) {

            s += Storage.teachers.elementAt(i).viewCourse() + "\n";
        }
        return s;
    }

    public void viewPassedCourse() {

        for (int i = 0; i < passed.size(); ++i)
            System.out.println(passed.elementAt(i));

    }

    public void removeSubject(Course course) {
        if (hasSubject(course) == false)
            return;
        for (int i = 0; i < current.size(); ++i) {
            current.removeElementAt(i);
            return;
        }
    }

    public double calculateGPA() {
        double sum = 0;
        for (int i = 0; i < current.size(); ++i) {
            sum += current.elementAt(i).getCreditsNumber() * marks.get(current.elementAt(i));
        }
        if (sum >= 95)
            return 4;
        else if (sum >= 90)
            return 3.67;
        else if (sum >= 85)
            return 3.33;
        else if (sum >= 80)
            return 3.0;
        else if (sum >= 75)
            return 2.67;
        else if (sum >= 70)
            return 2.33;
        else if (sum >= 65)
            return 2;
        else if (sum >= 60)
            return 1.67;
        else if (sum >= 55)
            return 1.33;
        else if (sum >= 50)
            return 1;
        else
            return 0;
    }


    public String viewTranscript() {
        String s = "";
        for (int i = 0; i < current.size(); ++i) {
            s = s + "\n" + current.elementAt(i).getMarkForStudent(this) + "\n" + getMark(current.elementAt(i));
        }
        return s;
    }

    @Override
    public String getTranscript() {

        String s = "";
        for (int i = 0; i < current.size(); ++i) {
            s = s + "\n" + current.elementAt(i).getMarkForStudent(this) + "\n" + getMark(current.elementAt(i));
        }
        return s;
    }

    @Override
    public String getAttendance() {
        String s = "";

        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        else
            return super.equals(obj) && super.getId().equals(((Student) obj).getId());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "id: " + super.getId() + "\n" +
                "year of study: " + yearOfStudy + "\n" +
                "faculty: " + faculty;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        if (super.getName().compareTo(student.getName()) >= 1 && GPA > student.GPA) {
            return 1;
        }
        if (super.getName().compareTo(student.getName()) <= -1 && GPA < student.GPA) {
            return -1;
        }
        return 0;
    }
}
