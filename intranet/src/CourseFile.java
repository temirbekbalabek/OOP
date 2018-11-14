import java.io.Serializable;

public class CourseFile implements Serializable {
    String name, body;

    public CourseFile() {
        name = "no name";
        body = "";
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        else {
            CourseFile courseFile2 = (CourseFile) obj;
            if (this.name.equals(courseFile2.getName()) && this.body.equals(courseFile2.getBody()))
                return true;
            else
                return false;
        }
    }

    @Override
    public String toString() {
        return "Name of CourseFile: " + name + "\n" + body + "\n";
    }
}
