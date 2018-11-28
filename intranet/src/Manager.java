import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Manager extends Employee {
    Manager(String login, String password, String name, String surname,
            int salary, String id) {
        super(login, password, name, surname, salary, id);
    }

    public void addCourse(Course course, Teacher teacher) {
            int index = Storage.teachers.indexOf(teacher);
            Storage.teachers.elementAt(index).addCourse(course);
    }

    public String viewInfosAboutTeachersAndStudents() {
        String s = "Teachers: ";
        Collections.sort(Storage.teachers);
        for (int i = 0; i < Storage.teachers.size(); i++) {
            Teacher teacher = Storage.teachers.elementAt(i);
            s += ((i + 1) + ")" + teacher.toString() + "\n");
        }
        Collections.sort(Storage.students);
        s += "Students: ";
        for (int i = 0; i < Storage.students.size(); i++) {
            Student student = Storage.students.elementAt(i);
            s += ((i + 1) + ")" + student.toString() + "\n");
        }
        return s;
    }

    public void sendMessageToTeacher() {

    }
}
