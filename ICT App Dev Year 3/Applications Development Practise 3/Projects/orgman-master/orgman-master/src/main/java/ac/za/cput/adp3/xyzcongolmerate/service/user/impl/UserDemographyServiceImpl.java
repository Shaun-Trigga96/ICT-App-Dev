package ac.za.cput.adp3.xyzcongolmerate.service.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.impl.UserDemographyRepositoryImpl;
import ac.za.cput.adp3.xyzcongolmerate.service.user.UserDemographyService;

import java.util.Set;

public class UserDemographyServiceImpl implements UserDemographyService {

    private UserDemographyRepository userDemographyRepository;
    private static UserDemographyService userDemographyService = null;

    private UserDemographyServiceImpl() {
        this.userDemographyRepository = UserDemographyRepositoryImpl.getUserDemographyRepository();
    }

    public static UserDemographyService getUserDemographyService() {
        if (userDemographyService == null) userDemographyService = new UserDemographyServiceImpl();
        return userDemographyService;
    }

    @Override
    public UserDemography create(UserDemography d) {
        return this.userDemographyRepository.create(d);
    }

    @Override
    public UserDemography read(String userEmail) {
        return this.userDemographyRepository.read(userEmail);
    }

    @Override
    public UserDemography update(UserDemography userDemography) {
        return this.userDemographyRepository.update(userDemography);
    }

    @Override
    public void delete(String userEmail) {
        this.userDemographyRepository.delete(userEmail);
    }

    @Override
    public Set<UserDemography> getAll() {
        return this.userDemographyRepository.getAll();
    }
}
