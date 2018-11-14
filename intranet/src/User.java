import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.lang.*;
import java.util.Scanner;

public class User implements Serializable {
    private String name, surname, login, password, id;

    public User(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }

    public User(String login, String password, String name, String surname, String id) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public User(String surname, String name, int age) {
        this.name = name;
        this.surname = surname;
    }

    public User() {
        name = "no name";
        surname = "no surname";

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Full name : " + surname + ' ' + name + "\n" + "login : " + login;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this.getClass() == obj.getClass()) {
            User p = (User) obj;
            if (this.surname.equals(p.surname) && this.name.equals(p.name)
                    && this.login.equals(p.login))
                return true;
            else
                return false;
        }
        return false;
    }

}
