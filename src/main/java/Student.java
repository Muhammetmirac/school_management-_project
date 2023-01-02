import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
    @Id
    private int studentId;
    private String name;
    private String surname;
    private int age;
    private String std_class;


    public Student() {
    }

    public Student(int studentId, String name, String surname, int age, String std_class) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.std_class = std_class;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStd_class() {
        return std_class;
    }

    public void setStd_class(String std_class) {
        this.std_class = std_class;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", std_class='" + std_class + '\'' +
                '}';
    }
}
