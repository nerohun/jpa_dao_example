package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import user.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {




        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);

        for (int i =1;i<=100;i++) {
            Book book = BookGenerator.generatebook();
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            System.out.println(book);
        }
        bookDao.findByIsbn13("9780899335674");
        em.close();
        emf.close();

    }
}
