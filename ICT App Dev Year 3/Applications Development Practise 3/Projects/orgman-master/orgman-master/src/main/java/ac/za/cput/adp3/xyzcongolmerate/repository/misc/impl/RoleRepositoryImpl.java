package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.repository.misc.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private Set<Role> roleDB;
    private static RoleRepository roleRepository = null;

    private RoleRepositoryImpl() {
        this.roleDB = new HashSet<>();
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null) roleRepository = new RoleRepositoryImpl();
        return roleRepository;
    }

    //TODO: Implement body
    @Override
    public Role create(Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Role read(String roleId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Role update(Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public void delete(String roleId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO: Implement body
    @Override
    public Set<Role> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
