import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Operations {
    Configuration con;
    SessionFactory sf;
    Session session;
    Transaction tx;
    Scanner input = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("**".repeat(10) + "  TechPro School Yonetim Sayfasına Hoşgeldiniz  " + "**".repeat(10));
        do {


            System.out.println("Lütefen Yapmak İstediğiniz İşlemi Seçiniz...");
            System.out.println("1- Teacher Operation\n" +
                    "2- Student Operation\n" +
                    "3- Exit ");
            int secim = input.nextInt();
            if (secim == 3) {
                System.out.println("İyi günler dileriz");
                break;
            } else if (secim == 1) {
                teacherMenu();

            } else if (secim == 2) {
                studentMenu();

            } else {
                System.out.println("Geçersiz seçim yaptınız\n" +
                        "Ana Sayfaya yöenlendiriliyorsunuz");
            }


        } while (true);
    }


    public void studentMenu() {
        do {
            System.out.println("Öğrenci Menüsüne Hoşgeldiniz");
            System.out.println("Lutfen Yapmak İstediğiniz İşlemi Seçiniz");
            System.out.println("1-Öğrenci Ekleme\n" +
                    "2-Öğrenci Listesi \n" +
                    "3-Öğrenci Arama \n" +
                    "4-Öğrenci Güncelleme \n" +
                    "5-Öğrenci Silme \n" +
                    "6-Ana Menü ");
            int secim = input.nextInt();
            if (secim == 6) {
                break;

            } else switch (secim) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    listStudent();
                    break;
                case 3:
                    searchstudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                default:
                    System.out.println("Geçersiz İşlem\n" +
                            "İşlem Sayfasına yönlendiriliyorsunuz");

            }

        } while (true);

    }

    public void teacherMenu() {
        do {
            System.out.println("Öğretmen Menüsüne Hoşgeldiniz");
            System.out.println("Lutfen Yapmak İstediğiniz İşlemi Seçiniz");
            System.out.println("1-Öğretmen Ekleme\n" +
                    "2-Öğretmen Listesi \n" +
                    "3-Öğretmen Arama \n" +
                    "4-Öğretmen Güncelleme \n" +
                    "5-Öğretmen Silme \n" +
                    "6-Ana Menü ");
            int secim = input.nextInt();
            if (secim == 6) {
                break;

            } else switch (secim) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    listTeacher();
                    break;
                case 3:
                    searchTeacher();
                    break;
                case 4:

                case 5:
                    deleteTeacher();
                    break;
                default:
                    System.out.println("Geçersiz İşlem\n" +
                            "İşlem Sayfasına yönlendiriliyorsunuz");

            }

        } while (true);

    }

    public void addStudent() {
        System.out.println("Öğrenci Ekleme Sayfası");

        System.out.println("Öğrencinin Numarasını giriniz");
        int studentId = input.nextInt();
        input.nextLine();
        System.out.println("Öğrenci Adını giriniz");
        String name = input.nextLine();
        System.out.println("Öğrenci Soyadını giriniz");
        String surname = input.nextLine();
        System.out.println("Öğrenci Yaşını giriniz");

        int age = input.nextInt();
        input.nextLine();
        System.out.println("Öğrenci Sınıfını giriniz");
        String std_class = input.nextLine();

        Student student = new Student(studentId, name, surname, age, std_class);
        openHibernate();
        session.save(student);
        commitCloseHibernate();


    }


    public void addTeacher() {

        System.out.println("Öğretmen Ekleme Sayfası");
        System.out.println("Öğretmen Sicil Numarasını giriniz");
        int teacherID = input.nextInt();
        input.nextLine();
        System.out.println("Öğretmen Adını giriniz");
        String name = input.nextLine();
        System.out.println("Öğretmen Soyadını giriniz");
        String surname = input.nextLine();
        System.out.println("Öğretmen Branşını giriniz");
        String branch = input.nextLine();
        System.out.println("Öğretmen Yaşını giriniz");
        int age = input.nextInt();

        Teacher teacher = new Teacher(teacherID, name, surname, age, branch);
        openHibernate();
        session.save(teacher);
        commitCloseHibernate();

    }


    public void listStudent() {
        System.out.println("Öğrenci Listesi");
        openHibernate();
        String hqlSorgu = "from Student";
        List<Student> list = session.createQuery(hqlSorgu).getResultList();
        list.forEach(t -> System.out.println(t));
        commitCloseHibernate();

    }

    public void listTeacher() {
        System.out.println("Öğretmen Listesi");
        openHibernate();
        String hqlSorgu = "FROM Teacher";
        List<Teacher> teachers = session.createQuery(hqlSorgu).getResultList();
        teachers.forEach(t -> System.out.println(t));
        commitCloseHibernate();

    }

    public void searchstudent() {
        openHibernate();
        System.out.println("Görüntülemek istediğiniz öğrencinin ID sini giriniz");
        int studentID = input.nextInt();
        Student student = session.get(Student.class, studentID);
        if (student == null) {
            commitCloseHibernate();
            System.out.println("Bu ID ile kayıtlı bir öğrenci bulunmamaktadır");
        } else {
            System.out.println(student);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            commitCloseHibernate();
        }


    }

    public void searchTeacher() {
        openHibernate();
        System.out.println("Görüntülemek istediğiniz öğretmenin sicil nosunu giriniz");
        int teacherID = input.nextInt();
        Teacher teacher = session.get(Teacher.class, teacherID);
        if (teacher == null) {
            commitCloseHibernate();
            System.out.println("Bu sicil ile kayıtlı bir öğretmen bulunmamaktadır");
            searchTeacher();
        } else {
            System.out.println(teacher);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            commitCloseHibernate();
        }

    }


    public void deleteStudent() {
        System.out.println("Silmek istediğiniz öğrencinin ID'sini giriniz");
        int studentID = input.nextInt();
        System.out.println("Silinecek Öğrenci Bilgileri");
        openHibernate();
        Student student = session.get(Student.class, studentID);
        System.out.println(student);
        input.nextLine();
        System.out.println("Silmek istediğinize emin misiniz ?");
        String secim = input.nextLine();
        if (secim.equalsIgnoreCase("e")) {
            session.delete(student);
            commitCloseHibernate();
            System.out.println("Silme işlemine devam etmek istiyor musunuz E/H");
            String tercih = input.nextLine();
            if (tercih.equalsIgnoreCase("e")) {
                deleteStudent();
            } else {

                //Anasayfa
            }
        } else {
            commitCloseHibernate();
            deleteStudent();

        }


    }


    public void deleteTeacher() {
        System.out.println("Silmek istediğiniz öğretmenin sicil no giriniz");
        int sicilNo = input.nextInt();
        System.out.println("Silinecek Öğretmen Bilgileri");
        openHibernate();
        Teacher teacher = session.get(Teacher.class, sicilNo);
        System.out.println(teacher);
        input.nextLine();
        System.out.println("Silmek istediğinize emin misiniz ?");
        String secim = input.nextLine();
        if (secim.equalsIgnoreCase("e")) {
            session.delete(teacher);
            commitCloseHibernate();
            System.out.println("Silme işlemine devam etmek istiyor musunuz E/H");
            String tercih = input.nextLine();
            if (tercih.equalsIgnoreCase("e")) {
                deleteTeacher();
            } else {
                System.out.println("Anasayfaya yönlendiriliyorsunuz");
                //Anasayfa
            }
        } else {
            commitCloseHibernate();
            deleteStudent();

        }


    }


    public void updateStudent() {
        openHibernate();
        System.out.print("Guncellemek istediğiniz öğrenci numarasını giriniz :");
        int studentID = input.nextInt();
        System.out.println("Guncellenecek öğrenci bilgileri");
        Student student = session.get(Student.class, studentID);
        System.out.println(student);
        System.out.println("Güncellenecek Bilgileri Giriniz");

//        System.out.println("Öğrencinin Numarasını giriniz");
//        int studentId= input.nextInt();
        input.nextLine();
        System.out.println("Öğrenci Adını giriniz");
        String name = input.nextLine();
        System.out.println("Öğrenci Soyadını giriniz");
        String surname = input.nextLine();
        System.out.println("Öğrenci Yaşını giriniz");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Öğrenci Sınıfını giriniz");
        String std_class = input.nextLine();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setStd_class(std_class);


        commitCloseHibernate();
    }

    public void updateTeacher() {
        openHibernate();
        System.out.print("Guncellemek istediğiniz öğretmen sicil numarasını giriniz :");
        int teacherID = input.nextInt();
        System.out.println("Guncellenecek öğretmen bilgileri");
        Teacher teacher = session.get(Teacher.class, teacherID);
        System.out.println(teacher);
        String hqlSorgu = "update Student s set e=s.marks=50 where s.studentId=10; "; // burayı kendine uyarla
        commitCloseHibernate();
    }


    public void openHibernate() {
        con = new Configuration().configure("hibernate.cfg.xml");
        sf = con.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
    }

    public void commitCloseHibernate() {
        tx.commit();
        session.close();
        sf.close();

    }


}
