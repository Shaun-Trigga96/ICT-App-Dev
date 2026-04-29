package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.StudioMovie;
import za.ac.cput.repository.StudioMovieRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudioMovieServices implements IStudioMovieService{
    private static StudioMovieServices service = null;

    @Autowired
    private StudioMovieRepository repository;

    @Override
    public StudioMovie create(StudioMovie studioMovie){
        return this.repository.save(studioMovie);
    }

    @Override
    public StudioMovie read(String studioId){
        return this.repository.findById(studioId).orElse(null);
    }

    @Override
    public StudioMovie update(StudioMovie studioMovie){
        if(this.repository.existsById(studioMovie.getStudioId()))
            return this.repository.save(studioMovie);
        return null;
    }

    @Override
    public boolean delete(String studioId){
        this.repository.deleteById(studioId);
        if(this.repository.existsById(studioId))
            return false;
        else
            return true;
    }

    @Override
    public Set<StudioMovie> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
