package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Rating;
import za.ac.cput.repository.RatingRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RatingService implements IRatingService{
    private static RatingService service = null;

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create (Rating rating){
        return this.repository.save(rating);
    }

    @Override
    public Rating read (String movieId){
        return this.repository.findById(movieId).orElse(null);
    }

    @Override
    public Rating update (Rating rating){
        if(this.repository.existsById(rating.getMovieId()))
            return this.repository.save(rating);
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
    public Set<Rating> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Rating getMovieGivenRating(double movieRating){
        Rating r = null;
        Set<Rating> ratings = getAll();
        for (Rating rating : ratings){
            if(rating.getRating()==movieRating){
                r = rating;
                break;
            }
        }
        return r;
    }

}//end of class