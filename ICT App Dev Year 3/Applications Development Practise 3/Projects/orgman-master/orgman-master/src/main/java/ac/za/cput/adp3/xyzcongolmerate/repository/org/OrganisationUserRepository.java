package ac.za.cput.adp3.xyzcongolmerate.repository.org;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;

import java.util.Set;

public interface OrganisationUserRepository {
    OrganisationUser create(OrganisationUser organisationUser);
    OrganisationUser read(String orgCode, String userEmail);
    OrganisationUser update(OrganisationUser organisationUser);
    void delete(String orgCode, String userEmail);
    Set<OrganisationUser> getAll();
}
