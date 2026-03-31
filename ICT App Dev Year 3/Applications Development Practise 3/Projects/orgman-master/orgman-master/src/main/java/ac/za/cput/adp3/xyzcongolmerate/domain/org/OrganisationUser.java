package ac.za.cput.adp3.xyzcongolmerate.domain.org;

import java.util.Objects;

/**
 * DO NOT MODIFY!
 */
public class OrganisationUser {

    private String orgCode, userEmail;

    public OrganisationUser(String orgCode, String userEmail) {
        this.orgCode = orgCode;
        this.userEmail = userEmail;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "OrganisationUser{" +
                "orgCode='" + orgCode + '\'' +
                ", email='" + userEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganisationUser that = (OrganisationUser) o;
        return orgCode.equals(that.orgCode) &&
                userEmail.equals(that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgCode, userEmail);
    }
}
