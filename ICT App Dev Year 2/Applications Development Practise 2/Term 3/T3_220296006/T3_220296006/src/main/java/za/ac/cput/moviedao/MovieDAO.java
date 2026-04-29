/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.moviedao;

import java.security.DomainCombiner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.standard.PrinterStateReason;
import za.ac.cput.Movie;
import za.ac.cput.moviedao.sunshinedb.SunshineDB;

/**
 *
 * @author  Thabiso Matsaba (220296006)
 */
public class MovieDAO {
	
	 
    private final Connection connection;
    
    public MovieDAO() throws SQLException {
  
    this.connection = SunshineDB.sunshineDerby();

}
     public Movie save(Movie movie) throws SQLException{
    
    String insertSQL = "INSERT INTO movie(movie_id, movie_title, movie_director, movie_genre)" + "VALUES(?,?,?,?)";
	    
	    try (PreparedStatement ps = this.connection.prepareStatement(insertSQL)) {
		    ps.setInt(1, movie.getMovieId());
		    ps.setString(2, movie.getMovieTitle());
		    ps.setString(3, movie.getMovieDirector());
		    ps.setString(4, movie.getMovieGenre());
		    
		    ps.executeUpdate();
	    }
	return movie;
	
}
     
      public List<Movie> getAll() throws SQLException{
      
      String getAll_SQL = "SELECT * FROM movie";
      
	List<Movie> movies = new ArrayList<>();   
	PreparedStatement ps = this.connection.prepareStatement(getAll_SQL);
	ResultSet rs = ps.executeQuery();
	      
	while(rs.next()){
	
	int movieId = rs.getInt("movie_id");
	String movieTitle = rs.getString("movie_title");
	String movieDirector = rs.getString("movie_director");
	String movieGenre = rs.getString("mobie_genre");
	
	}
	     
	return movies;
      }
     
      public void closeResources() throws SQLException{
           this.connection.close();
           
    }
}
