import dao.StudentDaoImpl;
import entity.Student;
import jakarta.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateEntityManagerFactory.createEntityManagerFactory();

        StudentDaoImpl sdi = new StudentDaoImpl(emf);

        Student student = new Student();
        student.setName("Vanya");
        student.setEmail("vanya2345@gmail.com");

        Student student2 = new Student();
        student2.setName("Vlad");
        student2.setEmail("vlad4567@gmail.com");

        Student student3 = new Student();
        student3.setName("John");
        student3.setEmail("john2457@gmail.com");

        sdi.addStudent(student);
        sdi.addStudent(student2);
        sdi.addStudent(student3);

        sdi.deleteStudent(3L);

        sdi.updateStudent(2L, student3);

        System.out.println(sdi.getAllStudents());

        System.out.println(sdi.getStudentById(1L));



    }
}
