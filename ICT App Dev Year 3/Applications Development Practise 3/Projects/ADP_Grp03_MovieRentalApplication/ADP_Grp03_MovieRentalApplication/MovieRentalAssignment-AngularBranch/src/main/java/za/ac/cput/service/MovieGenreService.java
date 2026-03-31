package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.MovieGenre;
import za.ac.cput.repository.MovieGenreRepository;
import java.util.List;

/*  MovieGenreService.java
    Author: Marchello Carolus 218234457
*/

@Service
public class MovieGenreService implements IMovieGenreService{
    private static StudioService service = null;

    @Autowired
    private MovieGenreRepository repo;

    @Override
    public MovieGenre create(MovieGenre genre){
        return this.repo.save(genre);
    }

    @Override
    public MovieGenre read(String genreId) {
        return this.repo.findById(genreId).orElse(null);
    }

    @Override
    public MovieGenre update(MovieGenre genre) {
        if (this.repo.existsById(genre.getMovieId()))
            return this.repo.save(genre);
        return null;
    }

    @Override
    public boolean delete(String genreId) {
        this.repo.deleteById(genreId);
        if(this.repo.existsById(genreId))
            return false;
        else
            return true;

    }

    @Override
    public List<MovieGenre> getAll() {
        return this.repo.findAll();
    }

//    public MovieGenre getGenreId(String genreId){
//        MovieGenre s = null;
//        List<MovieGenre> genres = getAll();
//        for(MovieGenre genre: genres){
//            if(genres.getGenreId().equals(genreId)){
//                s = genres;
//                break;
//            }
//        }
//        return s;
//    }


}
