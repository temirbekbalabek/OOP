package second;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Textbook implements Serializable {
    private int isbn;
    private String title, author;
    public Textbook(int isbn, String title, String author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }
    public void setIsbn(int isbn){
        this.isbn=isbn;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public int getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public void save(Vector<Textbook> v){
        try{
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\textbook.out"));
            o.writeObject(v);
            o.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    @Override
    public String toString(){
        return "The title is " + title;
    }
    @Override
    public boolean equals(Object o){
        Textbook t=(Textbook)o;
        if(this.isbn==t.isbn){
            return true;
        }
        return false;
    }

}
