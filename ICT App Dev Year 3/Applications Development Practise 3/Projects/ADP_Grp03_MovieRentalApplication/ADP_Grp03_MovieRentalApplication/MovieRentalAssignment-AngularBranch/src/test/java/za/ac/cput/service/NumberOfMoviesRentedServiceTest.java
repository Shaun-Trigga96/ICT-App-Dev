package za.ac.cput.service;

/**
 * Author: Lance Kruger
 * Student Number: 218159501
 * Program: Number of Movies Rented out Service
 *lk
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.NumberOfMoviesRented;
import za.ac.cput.factory.NumberOfMoviesRentedFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class NumberOfMoviesRentedServiceTest {

    private static INumberOfMoviesRentedService service = NumberOfMoviesRentedService.getService();
    private static NumberOfMoviesRented numberOfMoviesRented = NumberOfMoviesRentedFactory.build(250 , "A5Jk52", 38, 5);

    @Test
    void Create()
    {
        NumberOfMoviesRented built =service.create(numberOfMoviesRented);

        assertEquals(built.getUserID() , numberOfMoviesRented.getUserID());
        System.out.println("Create :"+ built);

    }
    @Test
    void Read()
    {
        NumberOfMoviesRented read = service.read(numberOfMoviesRented.getUserID());
        System.out.println("Read : " + read);

    }
    @Test
    void Update()
    {
        NumberOfMoviesRented updated = new NumberOfMoviesRented.NumberOfMoviesRentedBuilder().copy(numberOfMoviesRented).setMovieID(300).setUserID("50").setRentalID(20).setNumMovies(3).build();
        System.out.println("updated : "+ updated);


    }
    @Test
    void Delete()
    {
        boolean success =service.delete(numberOfMoviesRented.getUserID());
        assertTrue(success);
        System.out.println("Deleted : "+ success);

    }

    @Test
    void getAll()
    {
        System.out.println("Show All : ");
        System.out.println(service.getAll());

    }
}
