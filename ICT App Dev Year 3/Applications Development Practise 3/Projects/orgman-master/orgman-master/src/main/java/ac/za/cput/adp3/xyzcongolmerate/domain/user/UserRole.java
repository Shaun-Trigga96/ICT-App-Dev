package ac.za.cput.adp3.xyzcongolmerate.domain.user;

import java.util.Objects;

/**
 * DO NOT MODIFY!
 */
public class UserRole {

    private String orgCode, userEmail, roleId;

    public UserRole(String orgCode, String userEmail, String roleId) {
        this.orgCode = orgCode;
        this.userEmail = userEmail;
        this.roleId = roleId;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "orgCode='" + orgCode + '\'' +
                ", email='" + userEmail + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return orgCode.equals(userRole.orgCode) &&
                userEmail.equals(userRole.userEmail) &&
                roleId.equals(userRole.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgCode, userEmail, roleId);
    }
}
