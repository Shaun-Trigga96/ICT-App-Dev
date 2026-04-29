/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.moviedao;

import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Movie;

/**
 *
 * @author CPUT
 */
public class MovieDAOTest {
	
	private MovieDAO dao;
	
	public MovieDAOTest() {
	
	}
	
	@BeforeAll
	public static void setUpClass() {
	}
	
	@AfterAll
	public static void tearDownClass() {
	}
	
	@BeforeEach
	public void setUp() throws SQLException {
		 this.dao = new MovieDAO();
	}
	
	@AfterEach
	public void tearDown() throws SQLException {
		this.dao.closeResources();
	}

	/**
	 * Test of save method, of class MovieDAO.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testSave() throws Exception {
		System.out.println("save");
		Movie movie = new Movie(99789456, "Ben Goes Bananas", "Terrence Fortuin", "Comedy");
		Movie expResult = movie;
		Movie result = this.dao.save(movie);
		assertEquals(expResult, result);
	}
	/**
	 * Test of getAll method, of class MovieDAO.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testGetAll() throws Exception {
		System.out.println("getAll");
		MovieDAO instance = new MovieDAO();
		int expResult = 1;
		List<Movie> result = this.dao.getAll();
		assertEquals(expResult, result);	
	}

	/**
	 * Test of closeResources method, of class MovieDAO.
	 */
	@Test
	public void testCloseResources() throws Exception {
		System.out.println("closeResources");
		MovieDAO instance = new MovieDAO();
		instance.closeResources();
	}
	
}
