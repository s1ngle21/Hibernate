package dao;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.QueryException;

import java.util.List;
import java.util.function.Function;

public class StudentDaoImpl implements StudentDao{
    private EntityManagerFactory emf;

    public StudentDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void add(Student student) {
        doInTxReturning(em -> {
            em.persist(student);
            return null;
        });
    }

    public void delete(Long id) {
        doInTxReturning(em -> {
            Student student = em.find(Student.class, id);
            em.remove(student);
            return null;
        });
    }

    public void update(Long id, Student updatedStudent) {
        doInTxReturning(em -> {
            Student studentToUpdate = em.find(Student.class, id);
            studentToUpdate.setEmail(updatedStudent.getEmail());
            studentToUpdate.setName(updatedStudent.getName());
            return null;
        });
    }

    public List<Student> getAll() {
        return doInTxReturning(em ->
            em.createQuery("select s from Student s", Student.class)
                   .getResultList()
        );
    }

    public Student getById(Long id) {
        return doInTxReturning(em -> em.find(Student.class, id));
    }


    private <T> T doInTxReturning(Function<EntityManager, T> function) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            T result = function.apply(em);
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            throw new QueryException("Error occurred while performing query!", e);
        } finally {
            em.close();
        }
    }
}
