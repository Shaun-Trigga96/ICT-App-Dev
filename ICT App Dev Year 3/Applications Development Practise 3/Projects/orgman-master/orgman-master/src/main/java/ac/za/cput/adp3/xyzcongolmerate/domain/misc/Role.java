package ac.za.cput.adp3.xyzcongolmerate.domain.misc;

/**
 * DO NOT MODIFY!
 */
public class Role {

    private String roleId, roleName;

    private Role() {}

    public Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public static class Builder {
        private String roleId, roleName;

        public Builder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder copy(Role role) {
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
