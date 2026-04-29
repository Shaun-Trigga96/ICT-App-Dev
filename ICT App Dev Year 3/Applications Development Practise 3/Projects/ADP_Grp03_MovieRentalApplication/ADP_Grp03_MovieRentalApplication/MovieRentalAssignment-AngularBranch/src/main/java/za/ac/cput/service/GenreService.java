
package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Genre;
import za.ac.cput.repository.GenreRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService implements IGenreService{


    @Autowired
    private GenreRepository repository;

    @Override
    public Genre create(Genre genre){
        return this.repository.save(genre);
    }

    @Override
    public Genre read(String genreId){
        return this.repository.findById(genreId).orElse(null);
    }

    @Override
    public Genre update(Genre genre){
        if(this.repository.existsById(genre.getGenreId()))
            return this.repository.save(genre);
        return null;
    }

    @Override
    public boolean delete(String genreId){
        this.repository.deleteById(genreId);
        if(this.repository.existsById(genreId))
            return false;
        else
            return true;
    }

    @Override
    //converting List to set
    public Set<Genre> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Set<Genre> getSingleGenre() {
        Set<Genre> singleGenre =new HashSet<Genre>();
        Set<Genre> GenreSet = getAll();

        for (Genre genre : GenreSet)
        {
            if(genre.getGenreId().trim().toUpperCase().contains("A")){
                singleGenre.add(genre);
            }
        }
        return singleGenre;
    }
}

