package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepository genderRepository = null;
    private Set<Gender> genderDB;

    private GenderRepositoryImpl() {
        this.genderDB = new HashSet<>();
    }

    public static GenderRepository genderRepository() {
        if (genderRepository == null) genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }

    //TODO: Implement body
    @Override
    public Gender create(Gender gender) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Gender read(String genderId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Gender update(Gender gender) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public void delete(String genderId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Set<Gender> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
