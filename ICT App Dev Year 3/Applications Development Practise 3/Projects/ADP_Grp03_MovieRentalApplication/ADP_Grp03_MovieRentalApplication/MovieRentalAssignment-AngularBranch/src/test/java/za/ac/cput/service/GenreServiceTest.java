package za.ac.cput.service;


/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Genre;
import za.ac.cput.factory.GenreFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class GenreServiceTest {
    private GenreService service;

    private static Genre genre = GenreFactory.build("ROM", "Romance", "These romance will give you  nights and and scream like never before");


    @Test
    void a_create() {
        Genre created = service.create(genre);
        assertEquals(created.getGenreId(), genre.getGenreId());
        System.out.println("Created" + created);
    }

    @Test
    @Disabled
    void b_read() {
        Genre read = service.read(genre.getGenreId());
        System.out.println("Read: " + read);
    }

    @Test
    @Disabled
    void c_update() {
        Genre old = service.read("HOR");
        Genre updated = new Genre.genreBuilder().copy(genre).setGenreId("ACT").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        service.delete(genre.getGenreId());
        System.out.println("Deleted: " + genre.getGenreId() + "");
    }

    @Test
    @Disabled
    void e_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}
