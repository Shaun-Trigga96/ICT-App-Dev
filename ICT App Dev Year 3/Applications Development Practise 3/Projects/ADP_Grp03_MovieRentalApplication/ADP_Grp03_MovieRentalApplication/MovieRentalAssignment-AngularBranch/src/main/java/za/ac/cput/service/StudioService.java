package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Studio;
import za.ac.cput.repository.StudioRepository;

import java.util.List;


// Author: Marchello Carolus 218234457

@Service
public class StudioService implements IStudioService{

    private static StudioService service = null;

    @Autowired
    private StudioRepository repo;

    @Override
    public Studio create(Studio studio){
        return this.repo.save(studio);
    }

    @Override
    public Studio read(String studioId) {
        return this.repo.findById(studioId).orElse(null);
    }

    @Override
    public Studio update(Studio studio) {
        if (this.repo.existsById(studio.getStudioId()))
            return this.repo.save(studio);
        return null;
    }

    @Override
    public boolean delete(String studioId) {
        this.repo.deleteById(studioId);
        if(this.repo.existsById(studioId))
            return false;
        else
            return true;

    }

    @Override
    public List<Studio> getAll() {
        return this.repo.findAll();
    }

    public Studio getStudioId(String studioId){
        Studio s = null;
        List<Studio> studios = getAll();
        for(Studio studio: studios){
            if(studio.getStudioId().equals(studioId)){
                s = studio;
                break;
            }
        }
        return s;
    }
}
