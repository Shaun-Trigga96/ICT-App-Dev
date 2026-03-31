package ac.za.cput.adp3.xyzcongolmerate.service.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.impl.OrganisationUserRepositoryImpl;
import ac.za.cput.adp3.xyzcongolmerate.service.org.OrganisationUserService;

import java.util.Set;

public class OrganisationUserServiceImpl implements OrganisationUserService {

    private OrganisationUserRepository organisationUserRepository;
    private static OrganisationUserService organisationUserService = null;

    private OrganisationUserServiceImpl() {
        this.organisationUserRepository = OrganisationUserRepositoryImpl.getOrganisationUserRepository();
    }

    public OrganisationUserService getOrganisationUserService() {
        if (organisationUserService == null) organisationUserService = new OrganisationUserServiceImpl();
        return organisationUserService;
    }

    @Override
    public OrganisationUser create(OrganisationUser organisationUser) {
        return this.organisationUserRepository.create(organisationUser);
    }

    @Override
    public OrganisationUser read(String orgCode, String userEmail) {
        return this.organisationUserRepository.read(orgCode, userEmail);
    }

    @Override
    public OrganisationUser update(OrganisationUser organisationUser) {
        return this.organisationUserRepository.update(organisationUser);
    }

    @Override
    public void delete(String orgCode, String userEmail) {
        this.organisationUserRepository.delete(orgCode, userEmail);
    }

    @Override
    public Set<OrganisationUser> getAll() {
        return this.organisationUserRepository.getAll();
    }

    //TODO: Implement body - Question 1: Service that returns fullnames (as Set) of users in organisation given orgCode
    @Override
    public Set<String> getUserFullNamesInOrganisation(String orgCode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body - Question 2: Service that returns names of organisations (as Set) a user belongs to given userEmail
    @Override
    public Set<String> getUserOrganisations(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
