package book;

import book.model.Book;
import com.google.inject.persist.Transactional;
import jpa.GenericJpaDao;
import todo.model.Todo;
import user.model.User;

import javax.persistence.NoResultException;
import java.util.Optional;

public class BookDao extends GenericJpaDao<Book> {

    public Optional<Book> findByIsbn13(String isbn13){
        try {
            return Optional.of(entityManager.createQuery("SELECT b FROM Book b WHERE b.isbn13 = :isbn13", Book.class)
                    .setParameter("isbn13", isbn13)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }
}
