import javafx.geometry.Pos;

public class Employee extends User {
    private int salary;

    Employee() {
    }

    Employee(String login, String password, String name, String surname,
             int salary,  String id) {
        super(login, password, name, surname, id);
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "FullName: " + super.getName() + ' ' + super.getSurname() + "\n" +
                "id: " + super.getId() + "\n" +
                "salary: " + salary;
    }
}
