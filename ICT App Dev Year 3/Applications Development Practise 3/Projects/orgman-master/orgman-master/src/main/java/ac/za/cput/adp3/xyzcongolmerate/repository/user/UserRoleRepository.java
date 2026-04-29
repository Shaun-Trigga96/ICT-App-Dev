package ac.za.cput.adp3.xyzcongolmerate.repository.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;

import java.util.Set;

public interface UserRoleRepository {
    UserRole create(UserRole userRole);
    UserRole read(UserRole userRole);
    UserRole update(UserRole userRole);
    void delete(UserRole userRole);
    Set<UserRole> getAll();
}
