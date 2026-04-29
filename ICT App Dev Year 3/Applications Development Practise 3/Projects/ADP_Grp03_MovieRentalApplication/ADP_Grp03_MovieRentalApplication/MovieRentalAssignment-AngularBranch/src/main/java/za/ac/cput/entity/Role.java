package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
@Entity
public class Role {
    @Id
    private String roleId;

    private String name,description;

    public Role(){}

    public Role(roleBuilder roleBuilder) {

        this.roleId = roleBuilder.roleId;
        this.name = roleBuilder.name;
        this.description = roleBuilder.description;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class roleBuilder
    {

        private String name,description,roleId;

        public roleBuilder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public roleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public roleBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public roleBuilder copy(Role role)
        {
            this.roleId = role.roleId;
            this.name = role.name;
            this.description = role.description;

            return this;


        }

        public Role build()
        {
            return new Role(this);
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
