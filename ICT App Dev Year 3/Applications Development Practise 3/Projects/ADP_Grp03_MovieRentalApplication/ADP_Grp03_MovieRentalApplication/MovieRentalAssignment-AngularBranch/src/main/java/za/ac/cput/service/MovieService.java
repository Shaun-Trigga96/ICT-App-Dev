package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Movie;
import za.ac.cput.repository.MovieRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{
    private static MovieService service = null;

    @Autowired
    private MovieRepository repository;

    @Override
    public Movie create (Movie movie){
        return this.repository.save(movie);
    }

    @Override
    public Movie read (String movieId){
        return this.repository.findById(movieId).orElse(null);
    }

    @Override
    public Movie update (Movie movie){
        if(this.repository.existsById(movie.getMovieId()))
            return this.repository.save(movie);
        return null;
    }

    @Override
    public boolean delete(String movieId){
        this.repository.deleteById(movieId);
        if(this.repository.existsById(movieId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Movie> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Movie getMovieGivenTitle(String movieTitle){
        Movie m = null;
        Set<Movie> movies = getAll();
        for (Movie movie : movies){
            if(movie.getTitle().equals(movieTitle)){
                m = movie;
                break;
            }
        }
        return m;
    }

}//end of class