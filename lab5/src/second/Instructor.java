package second;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Instructor implements Serializable {
    private String firstName,lastName,department,email;
    Instructor(String firstName, String lastName, String department, String email){
        this.firstName=firstName;
        this.department=department;
        this. lastName=lastName;
        this.email=email;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getDepartment(){return department;}
    public String getEmail(){return email;}
    public void save(Vector<Instructor> v){
        try{
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\instructor.out"));
            o.writeObject(v);
            o.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    @Override
    public String toString(){
        return firstName + " " + lastName + " " + department + " " + email;
    }
    @Override
    public boolean equals(Object o){
        Instructor i=(Instructor)o;
        if(this.firstName==i.firstName && this.lastName==i.lastName &&
        this.department==i.department && this.email==i.email)
            return true;
        return false;
    }
}
