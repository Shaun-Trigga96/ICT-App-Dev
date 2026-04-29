package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private Set<Race> raceDB;
    private static RaceRepository raceRepository = null;

    private RaceRepositoryImpl() {
        this.raceDB = new HashSet<>();
    }

    public static RaceRepository getRaceRepository() {
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    //TODO: Implement body
    @Override
    public Race create(Race race) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Race read(String raceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Race update(Race race) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public void delete(String raceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Set<Race> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
