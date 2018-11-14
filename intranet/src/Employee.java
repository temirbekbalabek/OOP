public class Employee extends User {
    private int salary;
    private Position position;

    Employee() {
    }

    Employee(String login, String password, String name, String surname,
             int salary, Position position, String id) {
        super(login, password, name, surname, id);
        this.salary = salary;
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "FullName: " + super.getName() + ' ' + super.getSurname() + "\n" +
                "id: " + super.getId() + "\n" +
                "position: " + position + "\n" +
                "salary: " + salary;
    }
}
