import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_table")
public class Teacher {
    @Id
    private int teacherId;
    private String name;
    private String surname;
    private int age;
    private String branch;


    public Teacher() {
    }

    public Teacher(int teacherId, String name, String surname, int age, String branch) {
        this.teacherId = teacherId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.branch = branch;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", branch='" + branch + '\'' +
                '}';
    }
}
