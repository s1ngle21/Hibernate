import dao.StudentDaoImpl;
import entity.Student;
import jakarta.persistence.EntityManagerFactory;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

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

        sdi.add(student);
        sdi.add(student2);
        sdi.add(student3);

        sdi.delete(3L);

        sdi.update(2L, student3);

        LOGGER.info("All students: " + sdi.getAll());

        LOGGER.info("Student with id 1:" + sdi.getById(1L));



    }
}
