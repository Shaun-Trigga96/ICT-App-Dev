package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
@Entity
public class userRole {

    @Id
    private String userId;
    private int roleId;


    public userRole()
    {}
    public userRole(userRoleBuilder userRoleBuilder) {

        this.roleId = userRoleBuilder.roleId;
        this.userId = userRoleBuilder.userId;


    }

    public String getUserId() {
        return userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public static class userRoleBuilder
    {
        private int roleId;
        private String userId;

        public userRoleBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public userRoleBuilder setRoleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public userRole build()
        {
            return new userRole(this);
        }


        public userRoleBuilder copy(userRole userrole)
        {
            this.roleId = userrole.roleId;
            this.userId = userrole.userId;

            return this;


        }

    }

    @Override
    public String toString() {
        return "userRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}