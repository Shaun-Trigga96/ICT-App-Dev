package ac.za.cput.adp3.xyzcongolmerate.service.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationRepository;
import ac.za.cput.adp3.xyzcongolmerate.service.org.OrganisationService;

import java.util.Set;

public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationRepository organisationRepository;
    private static OrganisationService organisationService = null;

    private OrganisationServiceImpl() {
        this.organisationRepository = null;
    }

    public OrganisationService getOrganisationService() {
        if (organisationService == null) organisationService = new OrganisationServiceImpl();
        return organisationService;
    }

    @Override
    public Organisation create(Organisation d) {
        return this.organisationRepository.create(d);
    }

    @Override
    public Organisation read(String orgCode) {
        return this.organisationRepository.read(orgCode);
    }

    @Override
    public Organisation update(Organisation organisation) {
        return this.organisationRepository.update(organisation);
    }

    @Override
    public void delete(String orgCode) {
        this.organisationRepository.delete(orgCode);
    }

    @Override
    public Set<Organisation> getAll() {
        return this.organisationRepository.getAll();
    }
}
