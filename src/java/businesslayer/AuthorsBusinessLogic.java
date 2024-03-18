/* File: AuthorsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.AuthorsDaoImpl;
import java.util.List;
import java.sql.SQLException;
import model.Author;

public class AuthorsBusinessLogic {

    private AuthorsDaoImpl authorsDao = null;

    public AuthorsBusinessLogic() {
        authorsDao = new AuthorsDaoImpl();
    }

    public List<Author> getAllAuthors() throws SQLException {
        return authorsDao.getAllAuthors();
    }

    public void addAuthor(Author author) {
        authorsDao.addAuthor(author);
    }
}
