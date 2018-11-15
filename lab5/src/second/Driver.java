package second;

import javax.swing.text.TabExpander;
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args){

        try{
            ObjectInputStream oinstructor=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\instructor.out"));
            Vector<Instructor>instructors=new Vector<>();//(Vector<Instructor>)oinstructor.readObject();
            oinstructor.close();
            ObjectInputStream ocourse=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\courses.out"));
            Vector<Course>courses=(Vector<Course>)ocourse.readObject();
            ocourse.close();
            ObjectInputStream otextbook=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\textbook.out"));
            Vector<Textbook>textbooks=(Vector<Textbook>)otextbook.readObject();
            textbooks.clone();
            Scanner sc=new Scanner(System.in);
            menu: while(true){
                System.out.println("In order to continue to use the program you have to choose that you're admin or user.");
                System.out.println("Tap u to choose the user");
                System.out.println("or a to choose the admin");
                System.out.println("Otherwise write quit to exit the program");
                String input=sc.next();
                switch(input){
                    case "u":
                        user:while(true){
                            System.out.println("Choose\n [1] - instructor\n [2] - textbook\n [3] - course" +
                                    "\nto view the list each of them");
                            String input_user=sc.next();
                            Iterator it;
                            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\instructor.out"));
                            switch(input_user){
                                case "1":
                                    ois=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\instructor.out"));
                                    Vector<Instructor> temp_instructors = (Vector<Instructor>) ois.readObject();
                                    it = temp_instructors.iterator();
                                    while (it.hasNext()) {
                                        System.out.println(it.next());
                                    }
                                    break;
                                case "2":
                                    ois=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\textbook.out"));
                                    Vector<Textbook> temp_textbooks=(Vector<Textbook>)ois.readObject();
                                    it=temp_textbooks.iterator();
                                    while(it.hasNext()){
                                        System.out.println(it.next());
                                    }
                                    break;
                                case "3":
                                    ois=new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\courses.out"));
                                    Vector<Course> temp_courses=(Vector<Course>)ois.readObject();
                                    it=temp_courses.iterator();
                                    while(it.hasNext()){
                                        System.out.println(it.next());
                                    }
                                    break;
                                case "back":
                                    ois.close();
                                    continue menu;
                                default:
                                    System.out.println("Wrong input, now you returned to user");
                                    continue user;
                            }

                        }

                    case "a":
                        System.out.println("Please write your login and password");
                        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\JAVA\\lab5\\src\\second\\admin.txt"));
                        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\\\User\\Desktop\\JAVA\\lab5\\src\\second\\admin.txt", true));
                        String Adminlogin=br.readLine();
                        String adminPassword=br.readLine();
                        int hashedAdminPassword= Objects.hash(adminPassword);
                        String login=sc.next();
                        String password=sc.next();
                        int hashedPassword=Objects.hash(password);
                        br.close();
                        if(Adminlogin.equals(login) && hashedAdminPassword==hashedPassword){
                            System.out.println("OK");
                            okadmin: while(true){
                                System.out.println("Choose\n[1] - addTextbook\n[2] - addCourse\n[3] - addInstructor");
                                Date date=new Date();
                                bw.write(String.format("%s Admin logged into a system",date));
                                bw.newLine();
                                String input_admin=sc.next();
                                switch (input_admin){
                                    case "1":
                                        System.out.println("Write the isbn, title, author of new Textbook");
                                        int isbn=sc.nextInt();
                                        String title=sc.next();
                                        String author=sc.next();
                                        Textbook textbook=new Textbook(isbn, title, author);
                                        textbooks.add(textbook);
                                        date=new Date();
                                        bw.write(String.format("%s Admin added new textbook \"%s\"",date,textbook));
                                        bw.newLine();
                                        System.out.println("OKK");
                                        textbook.save(textbooks);
                                        break;
                                    case "2":
                                        System.out.println("Write courseTitle, Textbook, Instructor to create a new Course");
                                        String courseTitle=sc.next();
                                        System.out.println("Write the isbn, title, author of new Textbook");
                                        int cisbn=sc.nextInt();
                                        String ctitle=sc.next();
                                        String cauthor=sc.next();
                                        Textbook ctextbook=new Textbook(cisbn, ctitle, cauthor);
                                        System.out.println("Write firstName, lastName, department, email");
                                        String cfirstName=sc.next();
                                        String clastName=sc.next();
                                        String cdepartment=sc.next();
                                        String cemail=sc.next();
                                        Instructor cinstructor=new Instructor(cfirstName, clastName, cdepartment, cemail);
                                        date=new Date();
                                        Course course=new Course(ctextbook, cinstructor,courseTitle);
                                        courses.add(course);
                                        bw.write(String.format("%s Admin added new course \"%s\"",date,course));
                                        bw.newLine();
                                        course.save(courses);
                                        break;
                                    case "3":
                                        System.out.println("Write firstName, lastName, department, email");
                                        String firstName=sc.next();
                                        String lastName=sc.next();
                                        String department=sc.next();
                                        String email=sc.next();
                                        Instructor instructor=new Instructor(firstName, lastName, department, email);
                                        instructors.add(instructor);
                                        date=new Date();
                                        bw.write(String.format("%s Admin added new instructor \"%s\"",date,instructor));
                                        bw.newLine();
                                        instructor.save(instructors);
                                        break;
                                    case "back":
                                        bw.close();
                                        continue menu;
                                    default:
                                        System.out.println("Wrong input, now you returned to admin");
                                        continue okadmin;
                                }

                            }
                        }
                        else{
                            System.out.println("Incorrect login/password");
                            continue menu;
                        }
                    case "back":
                        continue menu;
                    case "quit":
                        System.exit(150);
                    default:
                        System.out.println("Wrong input, now you returned to menu");
                        continue menu;
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        } catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }
}
