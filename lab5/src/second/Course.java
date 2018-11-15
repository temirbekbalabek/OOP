package second;

import com.sun.imageio.plugins.common.I18N;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
    private String courseTitle;
    Textbook textbook;
    Instructor instructor;
    Course(Textbook textbook,Instructor instructor , String courseTitle){
        this.courseTitle = courseTitle;
        this.textbook = textbook;
        this.instructor = instructor;
    }
    public String getCourseTitle(){return courseTitle;}
    public Textbook getTextbook(){return textbook;}
    public Instructor getInstructor(){return instructor;}

    public void setCourseTitle(String courseTitle){
        this.courseTitle=courseTitle;
    }
    public void setTextbook(Textbook textbook){
        this.textbook=textbook;
    }
    public void setInstructor(Instructor instructor){
        this.instructor=instructor;
    }
    public void save(Vector<Course> v){
        try{
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\courses.out"));
            o.writeObject(v);
            o.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    @Override
    public String toString(){
        return courseTitle;
    }
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        Course course = (Course) o;
        if(this.courseTitle==course.courseTitle && this.instructor==course.instructor&&
        this.textbook==course.textbook)
        return true;
        return false;
    }
}
