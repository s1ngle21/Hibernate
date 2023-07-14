import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateEntityManagerFactory {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static EntityManagerFactory createEntityManagerFactory() {
        return emf;
    }

}
