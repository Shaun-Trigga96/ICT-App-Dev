package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.MovieRentedOut;
import za.ac.cput.factory.MoviesRentedOutFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MovieRentedOutRepositoryTest {
    private static MovieRentedOutRepository repository = MovieRentedOutRepository.getRepository();
    private static MovieRentedOut movieRentedOut = MoviesRentedOutFactory.build("Ajk52l",1);

    @Test
    void a_create(){
        MovieRentedOut created = repository.create(movieRentedOut);
        assertEquals(created.getMovieID(), movieRentedOut.getMovieID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read(){
        MovieRentedOut read = repository.read(movieRentedOut.getMovieID());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update(){
        MovieRentedOut updated = new MovieRentedOut.MovieRentedOutBuilder().copy(movieRentedOut).setMovieID("").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

     @Test
     void e_delete(){
        boolean success = repository.delete(movieRentedOut.getMovieID());
        assertTrue(success);
         System.out.println("Delete: "+ success);
     }

    @Test
    void d_getAll(){
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }
}
