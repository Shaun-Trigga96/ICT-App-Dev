package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private Set<UserRole> userRoleDB;
    private static UserRoleRepository userRoleRepository = null;

    private UserRoleRepositoryImpl() {
        this.userRoleDB = new HashSet<>();
    }

    public static UserRoleRepository getUserRoleRepository() {
        if (userRoleRepository == null) userRoleRepository = new UserRoleRepositoryImpl();
        return userRoleRepository;
    }

    //TODO: Implement body
    @Override
    public UserRole create(UserRole userRole) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public UserRole read(UserRole userRole) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public UserRole update(UserRole userRole) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public void delete(UserRole userRole) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Set<UserRole> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
