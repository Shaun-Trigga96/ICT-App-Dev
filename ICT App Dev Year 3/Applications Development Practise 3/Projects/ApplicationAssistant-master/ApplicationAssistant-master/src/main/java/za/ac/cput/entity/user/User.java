package za.ac.cput.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    private String userId;
    private String username;
    private String userEmail;
    private String password;
    private String confirmEmail;
    private String confirmPassword;

    protected User(){}

    private User(Builder builder){
        this.userId = builder.userId;
        this.username = builder.username;
        this.userEmail = builder.userEmail;
        this.password = builder.password;
        this.confirmEmail = builder.confirmEmail;
        this.confirmPassword = builder.confirmPassword;
    }

    public String getUserId() { return userId; }

    public String getUsername() {
        return username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + userId + '\'' +
                ", UserName='" + username + '\'' +
                ", UserEmail='" + userEmail + '\'' +
                ", Password='" + password + '\'' +
                ", confirmEmail='" + confirmEmail + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    public static class Builder{
        private String userId;
        private String username;
        private String userEmail;
        private String password;
        private String confirmEmail;
        private String confirmPassword;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUsername(String username){
            this.username = username;
            return this;
        }

        public Builder setUserEmail(String userEmail){
            this.userEmail = userEmail;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder setConfirmEmail(String confirmEmail){
            this.confirmEmail = confirmEmail;
            return this;
        }

        public Builder setConfirmPassword(String confirmPassword){
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.username = user.username;
            this.userEmail = user.userEmail;
            this.password = user.password;
            this.confirmEmail = user.confirmEmail;
            this.confirmPassword = user.confirmPassword;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
