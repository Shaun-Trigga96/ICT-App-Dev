package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;

import java.util.HashSet;
import java.util.Set;

public class OrganisationUserRepositoryImpl implements OrganisationUserRepository {

    private Set<OrganisationUser> organisationUserDB;
    private static OrganisationUserRepository organisationUserRepository = null;

    private OrganisationUserRepositoryImpl() {
        this.organisationUserDB = new HashSet<>();
    }

    public static OrganisationUserRepository getOrganisationUserRepository() {
        if (organisationUserRepository == null) organisationUserRepository = new OrganisationUserRepositoryImpl();
        return organisationUserRepository;
    }

    //TODO: Implement body
    @Override
    public OrganisationUser create(OrganisationUser organisationUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public OrganisationUser read(String orgCode, String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public OrganisationUser update(OrganisationUser organisationUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public void delete(String orgCode, String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Set<OrganisationUser> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
