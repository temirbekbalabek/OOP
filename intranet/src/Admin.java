import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends Employee {
    Admin(String login, String password, String name, String surname,
          int salary, Position position, String id){
        super(login, password, name, surname, salary, position, id);
    }
    public void addUser(User user, String type){
        if(type.equals("teacher")){
            Teacher teacher=(Teacher) user;
            Storage.teachers.add(teacher);
        }
        if(type.equals("student")){
            Student student=(Student) user;
            Storage.students.add(student);
        }
        if(type.equals("manager")){
            Manager manager=(Manager) user;
            Storage.managers.add(manager);
        }
    }
    public void removeUser(User user, String type){
        if(type.equals("teacher")){
            Teacher teacher=(Teacher) user;
            Storage.teachers.remove(teacher);
        }
        if(type.equals("student")){
            Student student=(Student) user;
            Storage.students.remove(student);
        }
        if(type.equals("manager")){
            Manager manager=(Manager) user;
            Storage.managers.remove(manager);
        }
    }
    public void updatePassword(User user, String type, String password){
        if(type.equals("teacher")){
            Teacher teacher=(Teacher) user;
            if(Storage.teachers.contains(teacher)){
                int index = Storage.teachers.indexOf(teacher);
                Storage.teachers.elementAt(index).setPassword(password);
            }
        }
        if(type.equals("student")){
            Student student=(Student) user;
            if(Storage.students.contains(student)){
                int index = Storage.students.indexOf(student);
                Storage.students.elementAt(index).setPassword(password);
            }

        }
        if(type.equals("manager")){
            Manager manager=(Manager) user;
            if(Storage.managers.contains(manager)){
                int index = Storage.managers.indexOf(manager);
                Storage.managers.elementAt(index).setPassword(password);
            }
        }
    }
    public String seeUserActions() throws FileNotFoundException {
        String s="";
        BufferedReader br=null;
        String inputline=null;
        try {
            br = new BufferedReader(new FileReader("userActions.txt"));
            while((inputline=br.readLine())!=null){
                s += (inputline+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
