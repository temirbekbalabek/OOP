import javafx.geometry.Pos;
import javafx.util.Pair;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
public class Driver {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String login="",name="",surname="",password="",id="",coursename="",studentID="",nameofdocument="",text="";
        int salary,yearofstudy;
        double mark;
        Position position;
        Faculty faculty=Faculty.FIT;
        Storage.deserialize();
       mainmenu: while (true){
        System.out.println("Welcome to our Intranet!!!");
        System.out.println("Are you admin,teacher,executor...");
        System.out.println("1) Admin\n" + "2) Manager\n" + "3) Teacher\n" + "4) Executor\n" + "5) Student\n" + "6) Exit");
        int ch=scanner.nextInt();//ch-choice
        String log,pass;
        if (ch==1){
            menu2: while (true) {
                System.out.println("Hello admin\nEnter login: ");
                log = scanner.next();
                System.out.println("Enter password:");
                pass = scanner.next();
                if (log.equals("admin") && pass.equals("12345")) {
                    menu3: while (true){
                        System.out.println("Welcome " + log + "!!!");
                        System.out.println(
                                "1)View of teachers\n" +
                                "2)Add teacher\n" +
                                "3)Remove teacher\n" +
                                "4)View of students\n" +
                                "5)Add student\n" +
                                "6)Remove student\n" +
                                "7)View of manager\n" +
                                "8)Add manager\n" +
                                "9)Remove manager\n" +
                                "10)View of executors\n" +
                                "11)Add executor\n" +
                                "12)Remove executor\n" +
                                "13)Return back\n" +
                                "14)Exit");
                        int input = scanner.nextInt();
                        if(input==1){
                            for(int i=0;i<Storage.teachers.size();i++){
                                System.out.println(Storage.teachers.elementAt(i));
                            }
                            System.out.println();
                        }
                        else if(input==2 || input==3){
                            System.out.println("Write name, surname, login, password, id, position, salary");
                            System.out.println("name:");
                            name=scanner.next ();
                            System.out.println("surname:");
                            surname=scanner.next();
                            System.out.println("login:");
                            login=scanner.next();
                            System.out.println("pas:");
                            password=scanner.next();
                            System.out.println("id:");
                            id=scanner.next();
                            System.out.println("position:");
                            String posstr=scanner.next();
                            System.out.println("salary:");
                            salary=scanner.nextInt();
                            if(posstr.equals("Tutor"))
                                position=Position.TUTOR;
                            else if(posstr.equals("Lector"))
                                position=Position.LECTOR;
                            else if(posstr.equals("Senior Lector"))
                                position=Position.SENIOR_LECTOR;
                            else if(posstr.equals("Professor"))
                                position=Position.PROFESSOR;
                            else
                                position=Position.NOPOSITION;
                            Teacher t = new Teacher(login, password, name, surname, position, salary, id);
                            if(input==2) {
                                Admin.addUser(t, "teacher");
                                System.out.println("The teacher was successfully added");
                            }
                            else{
                                Admin.removeUser(t, "teacher");
                                System.out.println("The teacher was successfully removed");
                            }
                        }
                        else if(input==4){
                            for(int i=0;i<Storage.students.size();i++){
                                System.out.println(Storage.students.elementAt(i));
                            }
                            System.out.println();
                        }
                        else if(input==5 || input==6){
                            System.out.println("Write name, surname, login, password, id, yearofstudy, faculty");
                            name=scanner.next();
                            surname=scanner.next();
                            login=scanner.next();
                            password=scanner.next();
                            id=scanner.next();
                            yearofstudy=scanner.nextInt();
                            String facstr=scanner.next();
                            if(facstr.equals("FIT"))
                                faculty=Faculty.FIT;
                            else if(facstr.equals("ISE"))
                                faculty=Faculty.ISE;
                            else
                                faculty=Faculty.NOFACULTY;
                            Student s = new Student(surname, name,login, id, password, yearofstudy, faculty);
                            if(input==5) {
                                Admin.addUser(s, "student");
                                System.out.println("The student was successfully added");
                            }
                            else{
                                Admin.removeUser(s, "student");
                                System.out.println("The student was successfully removed");
                            }
                        }
                        else if(input==7){
                            for(int i=0;i<Storage.managers.size();i++){
                                System.out.println(Storage.managers.elementAt(i));
                            }
                            System.out.println();
                        }
                        else if(input==8 || input==9){
                            System.out.println("Write name, surname, login, password, id, salary");
                            name=scanner.next();
                            surname=scanner.next();
                            login=scanner.next();
                            password=scanner.next();
                            id=scanner.next();
                            salary=scanner.nextInt();
                            Manager m = new Manager(login, password, name, surname, salary, id);
                            if(input==8) {
                                Admin.addUser(m, "manager");
                                System.out.println("The manager was successfully added");
                            }
                            else{
                                Admin.removeUser(m, "manager");
                                System.out.println("The manager was successfully removed");
                            }
                        }
                        else if(input==10){
                            for(int i=0;i<Storage.executors.size();i++){
                                System.out.println(Storage.executors.elementAt(i));
                            }
                            System.out.println();
                        }
                        else if(input==11 || input==12){
                            System.out.println("Write name, surname, login, password, id, salary");
                            name=scanner.next();
                            surname=scanner.next();
                            login=scanner.next();
                            password=scanner.next();
                            id=scanner.next();
                            salary=scanner.nextInt();
                            Executor e = new Executor(login, password, name, surname, salary, id);
                            if(input==11) {
                                Admin.addUser(e, "executor");
                                System.out.println("The executor was successfully added");
                            }
                            else{
                                Admin.removeUser(e, "executor");
                                System.out.println("The executor was successfully removed");
                            }
                        }
                        else if(input==13){
                            continue mainmenu;
                        }
                        else if(input==14){
                            Storage.serialize();
                            return;
                        }
                        else {
                            System.out.println("be sure that you enter a correct number");
                            continue ;
                        }
                    }

                } else {
                    System.out.println("Bad root name or password");
                    System.out.println("1) Try again\n2)Return back\n3)Exit");
                    int ch2=scanner.nextInt();//ch2-choice2
                    if (ch2==3)
                        return;
                    if (ch2==2){
                        continue mainmenu;
                    }
                    if (ch2==1){
                        continue;
                    }
                }

            }
        }
        else if (ch==3){
            Boolean ok=false;
            Teacher teacher1=new Teacher();
            System.out.println("Hello teacher!");
            System.out.println("login: ");
            login=scanner.next();
            System.out.println("password: ");
            pass=scanner.next();
            for(int i=0;i<Storage.teachers.size();i++){
                teacher1=Storage.teachers.elementAt(i);
                if (teacher1.getLogin().equals(login) && teacher1.getPassword().equals(pass) ) {
                    ok = true;
                    break;
                }
            }
            if (ok==false){
                System.out.println("Invalid login or password!!!");
                System.out.println("1) Try again\n2)Return back\n3)Exit");
                int ch2=scanner.nextInt();//ch2-choice2
                if (ch2==3)
                    return;
                if (ch2==2){
                    continue mainmenu;
                }
                if (ch2==1){
                    continue;
                }
            }
            else{
                System.out.println("We have successfully logged in");

               menu4: while (true){
                    System.out.println("" +
                            "1) View of Students \n" +
                            "2) Put marks\n" +
                            "3) View of own courses\n" +
                            "4) Add course file\n" +
                            "5) Send message to executor\n" +
                            "6) View message from manager\n" +
                            "7) Change password\n" +
                            "8) Return back\n" +
                            "9) Exit");
                   int input=scanner.nextInt();
                   if (input==1){
                       System.out.println(teacher1.getAllStudents());

                   }
                   if (input==2) {
                       while (true) {
                           System.out.println("Name of course, ID of student, mark: ");
                           coursename = scanner.next();

                           Course course = new Course();
                           Student student=new Student();
                           //for (int i=0;i<teacher1.su)
                           studentID = scanner.next();
                           mark = scanner.nextDouble();
                           if ( teacher1.haveTeacherCourse(coursename)==false || teacher1.haveTeacherStudent(studentID)==false ){
                               System.out.println("Incorrect info!\n1) Try again\n2) Back\n3) Exit");
                               int input3=scanner.nextInt();
                               if (input3==1)
                                   continue;
                               else if (input3==2)
                                   continue menu4;
                               else if (input3==3){
                                   Storage.serialize();
                                   return;
                               }
                           }
                           else{
                               course=teacher1.getCourse(coursename);
                               student=teacher1.getStudent(studentID);
                               teacher1.putMarkToStudentInCourse(course,student,mark);
                               student=teacher1.getStudent(studentID);
                               System.out.println("Successfully have done!");
                               int ind=0;
                               for (int i=0;i<Storage.students.size();++i){
                                   if (Storage.students.elementAt(i).equals(student)) {
                                       Storage.students.remove(i);
                                       break;
                                   }
                               }

                               for (int i=0;i<Storage.teachers.size();++i){
                                   if (Storage.teachers.elementAt(i).equals(teacher1)) {
                                       Storage.teachers.remove(i);
                                       break;
                                   }
                               }
                               Storage.students.add(student);
                               Storage.teachers.add(teacher1);
                               break;
                           }
                       }
                   }

                   if (input==3){
                      System.out.println( teacher1.viewCourse());
                       coursename = scanner.next();
                   }

                   if (input==4){
                    System.out.print("name of course, name of document, text");
                       coursename = scanner.nextLine();
                       nameofdocument=scanner.nextLine();
                        text=scanner.nextLine();
                      if ( teacher1.haveTeacherCourse(coursename)==false)
                          System.out.println("You don't have this course!!!");
                      else{
                          Course course=teacher1.getCourse(coursename);
                          teacher1.getCourse(coursename).addCourseFile(nameofdocument,text);

                      }
                   }

                   if (input==5){
                    System.out.println("message:");
                    text=scanner.next();
                       Executor.order.add(new Pair(teacher1,text));
                       System.out.println("You have successfully done!");
                       continue menu4;
                   }

                   if (input==6){
                    teacher1.viewMessages();

                   }

                   if (input==7){
                        System.out.println("new password:");
                        String input4=scanner.next();
                        teacher1.setPassword(input4);

                   }

                   if (input==8 || input==9){
                       for (int i=0;i<Storage.teachers.size();++i){
                           if (Storage.teachers.elementAt(i).equals(teacher1)) {
                               Storage.teachers.remove(i);
                               break;
                           }
                       }
                       Storage.teachers.add(teacher1);
                        if (input==8)
                            continue menu4;
                        else
                        {
                            Storage.serialize();
                            return;
                        }
                   }


                   if (input==10){

                    System.out.println("Invalid variant");
                   }
               }


            }

        }
        else if (ch==2){
            boolean ok=false;
            System.out.println("login");
            login=scanner.next();
            System.out.println("password");
            pass=scanner.next();
            for (int i=0;i<Storage.managers.size();++i){
                if (Storage.managers.elementAt(i).getLogin().equals(login) &&  Storage.managers.elementAt(i).getPassword().equals(pass)){
                    ok=true;
                }
            }
            if (ok==false){
                System.out.println("NOT Correct!!!");
            }
            else{
                System.out.println("1) Add courses for registration\n2) View Info about students and teachers\n3) Send messages to teachers");
                int n=scanner.nextInt();
                if (n==1){
                    //String name, String id, Teacher teacher, int credit, Faculty faculty, int yearOfStudy
                    System.out.println("name of course , id of course, teacher_id,credit, faculty, yearOfStudy");
                    name=scanner.next();
                    id=scanner.next();
                    String teacherID=scanner.next();
                    int credit=scanner.nextInt();
                    String faculty2=scanner.next();
                    if (faculty2.equals("FIT"))
                        faculty=Faculty.FIT;
                    if (faculty2.equals("ISE"))
                        faculty=Faculty.ISE;
                    yearofstudy=scanner.nextInt();
                    for (int i=0;i<Storage.teachers.size();++i){
                       if (Storage.teachers.elementAt(i).getId().equals(teacherID))
                           Storage.teachers.elementAt(i).addCourse(new Course(name,id,Storage.teachers.elementAt(i),credit,faculty,yearofstudy) );
                    }

                }
                else if (n==2){
                    System.out.println("1) Teachers\n2) Students");
                    int choice=scanner.nextInt();
                    if (choice==1){
                        for (int i=0;i<Storage.teachers.size();++i){
                            System.out.println(Storage.teachers.elementAt(i));
                        }
                    }
                    if (choice==2){
                        for (int i=0;i<Storage.students.size();++i){
                            System.out.println(Storage.students.elementAt(i));
                        }
                    }
                }
                else if (n==3){
                    System.out.println("ID of teacher: ");
                    id=scanner.next();
                    System.out.println("message: ");
                    String message=scanner.nextLine();
                    for (int i=0;i<Storage.teachers.size();++i){
                      if (Storage.teachers.elementAt(i).getId().equals(id))
                          Storage.teachers.elementAt(i).addMessages(message);
                    }
                }
                else{
                    System.out.println("Incorrect!!!");
                }

            }


        }
        else if (ch==4){
            int index=0;
            boolean ok=false;
        menu6:    while (true) {
            System.out.println("login: ");
            login = scanner.next();
            System.out.println("password: ");
            password = scanner.next();
            for (int i = 0; i < Storage.executors.size(); i++) {
                if (Storage.executors.elementAt(i).getLogin().equals(login) && Storage.executors.elementAt(i).getPassword().equals(password)) {
                    index = i;
                    ok = true;
                    break;
                }
            }
            if (ok == false) {

                System.out.println("Incorrect info!\n1) Try again\n2) Back\n3) Exit");
                int input3 = scanner.nextInt();
                if (input3 == 1)
                    continue;
                else if (input3 == 2)
                    continue mainmenu;
                else if (input3 == 3) {
                    Storage.serialize();
                    return;
                }


            }
            else{

              menu7:  while (true){
                    System.out.println("1) Show next\n2) Show done\n3)Show accepted\n4) Accept\n5) Reject\n6) back");
                    int alter=scanner.nextInt();
                    if (alter==1){
                        System.out.println(Executor.viewNextOrder());
                    }
                  if (alter==2){
                      for (int i=0;i<Executor.order.size();++i)
                          System.out.println(Executor.order.peek().getKey()+" \nMessage:"+Executor.order.peek().getValue());
                  }
                  if (alter==3){
                      for (int i=0;i<Executor.done.size();++i)
                          System.out.println(Executor.done.peek().getKey()+" \nMessage:"+Executor.done.peek().getValue());
                  }
                  if (alter==4){
                  Executor.acceptOrder();
                  }
                  if (alter==5){
                      Executor.rejectOrder();
                  }

                  if (alter==6){
                     continue mainmenu;
                  }


              }

            }
        }

        }
        else if (ch==5){
            System.out.println("Write your login and password");
            System.out.print("Login: ");
            login=scanner.next();
            System.out.print("Password: ");
            password=scanner.next();
            Student s = null;
            boolean ok=false;
            for(int i=0;i<Storage.students.size();i++){
                if(Storage.students.elementAt(i).getLogin().equals(login) && Storage.students.elementAt(i).getPassword().equals(password)){
                    s=Storage.students.elementAt(i);
                    ok=true;
                    break;
                }
            }
            if(!ok){
                System.out.println("bad root name or password!");
                continue mainmenu;
            }
            else{
                while (true) {
                    System.out.println("Hello student!");
                    System.out.println("1)Register for a course\n" +
                            "2)View files of courses\n" +
                            "3)View marks for specific course\n" +
                            "4)View transcript\n");
                    int ch3 = scanner.nextInt();
                    if (ch3 == 1) {
                        System.out.println("Write the teacher's and the course's name which you are registering");
                        System.out.print("Teacher's name: ");
                        name = scanner.next();
                        System.out.print("Course's surname: ");
                        surname = scanner.next();

                        System.out.print("Course's name: ");
                        coursename = scanner.next();

                        boolean found = false;
                        Teacher t = null;
                        Course course = null;
                        for (int i = 0; i < Storage.teachers.size(); i++) {
                            if (Storage.teachers.elementAt(i).getName().equals(name) && Storage.teachers.elementAt(i).getSurname().equals(surname) ) {
                                found = true;
                                t = Storage.teachers.elementAt(i);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Sorry, we don't have any teacher named - " + name+" "+surname);
                            continue mainmenu;
                        } else {
                            if (t.haveTeacherCourse(coursename)) {
                                course = t.getCourse(coursename);
                            } else {
                                System.out.println("Sorry, we don't have any course named - " + coursename);
                                continue mainmenu;
                            }
                        }
                        s.registrationForCourse(course);
                        t.addStudentToCourse(course, s);
                        Storage.students.remove(s);
                        Storage.students.add(s);
                        Storage.teachers.remove(t);
                        Storage.teachers.add(t);
                    } else if (ch3 == 2) {
                        for (int i = 0; i < Storage.teachers.size(); i++) {
                            System.out.println(Storage.teachers.elementAt(i).getName() + ":");
                            System.out.println(Storage.teachers.elementAt(i).viewCourse());
                        }
                    } else if (ch3 == 3) {
                        System.out.println("Write a course name");
                        System.out.println("name: ");
                        coursename = scanner.next();
                        Course course = s.getCourse(coursename);
                        System.out.println(s.getMark(course));
                    } else if (ch3 == 4) {
                        System.out.println(s.viewTranscript());
                    } else continue mainmenu;
                }
            }
        }
        else if (ch==6){
            Storage.serialize();
            return;
        }
        else{
            System.out.println("NOT CORRECT! Please try again!");
        }

       }

    }
}
