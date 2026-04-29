package ac.za.cput.service.demography.impl;

import ac.za.cput.domain.demography.Race;
import ac.za.cput.repostory.demography.RaceRepository;
import ac.za.cput.service.demography.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RaceServiceImpl implements RaceService {

    private static RaceService raceService = null;
    @Autowired
    private RaceRepository raceRepository;

    private RaceServiceImpl() {

    }

    public static RaceService getRaceService() {
        if (raceService == null) raceService = new RaceServiceImpl();
        return raceService;
    }

    @Override
    public Race create(Race race) {
        return this.raceRepository.save(race);
    }

    @Override
    public Race read(String s) {
        return this.raceRepository.findById(s).orElse(null);
    }

    @Override
    public Race update(Race race) {
        return this.raceRepository.save(race);
    }

    @Override
    public void delete(String s) {
        this.raceRepository.deleteById(s);
    }

    @Override
    public Race retrieveByDesc(String raceDesc) {
        List<Race> races = getAll();
        for(Race race : races) {
            if (race.getDesc().equalsIgnoreCase(raceDesc))
                return race;
        } return null;
    }

    @Override
    public List<Race> getAll() {
        return this.raceRepository.findAll();
    }
}
