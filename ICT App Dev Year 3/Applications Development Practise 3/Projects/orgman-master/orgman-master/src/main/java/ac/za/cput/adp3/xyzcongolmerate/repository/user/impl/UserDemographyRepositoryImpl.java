package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDemographyRepositoryImpl implements UserDemographyRepository {

    private Set<UserDemography> userDemographyDB;
    private static UserDemographyRepository userDemographyRepository = null;

    private UserDemographyRepositoryImpl() {
        this.userDemographyDB = new HashSet<>();
    }

    public static UserDemographyRepository getUserDemographyRepository() {
        if (userDemographyRepository == null) userDemographyRepository = new UserDemographyRepositoryImpl();
        return userDemographyRepository;
    }

    //TODO: Implement body
    @Override
    public UserDemography create(UserDemography userDemography) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public UserDemography read(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public UserDemography update(UserDemography userDemography) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public void delete(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Set<UserDemography> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
