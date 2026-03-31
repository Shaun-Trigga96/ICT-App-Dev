package ac.za.cput.adp3.xyzcongolmerate.service.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;

import java.util.Set;

public interface UserRoleService {
    UserRole create(UserRole userRole);
    UserRole read(UserRole userRole);
    UserRole update(UserRole userRole);
    void delete(UserRole userRole);
    Set<UserRole> getAll();
}
