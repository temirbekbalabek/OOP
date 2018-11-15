package first;
public class Student {
    private String name,surname,score;
    Student(String name, String surname, String score){
        this.score=score;
        this.name=name;
        this.surname=surname;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setScore(String score){
        this.score=score;
    }
    @Override
    public String toString(){
        return name+' ' + surname+' ' + score;
    }
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getScore(){return score;}
}
