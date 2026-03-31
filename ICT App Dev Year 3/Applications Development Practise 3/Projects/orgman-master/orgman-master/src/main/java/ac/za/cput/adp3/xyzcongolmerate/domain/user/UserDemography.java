package ac.za.cput.adp3.xyzcongolmerate.domain.user;

import java.util.Date;
import java.util.Objects;

/**
 * DO NOT MODIFY!
 */
public class UserDemography {

    private String userEmail, userTitle, genderId, raceId;
    private Date dateOfBirth;

    public UserDemography(String userEmail, String userTitle, String genderId, String raceId, Date dateOfBirth) {
        this.userEmail = userEmail;
        this.userTitle = userTitle;
        this.genderId = genderId;
        this.raceId = raceId;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserDemography{" +
                "email='" + userEmail + '\'' +
                ", userTitle='" + userTitle + '\'' +
                ", genderId='" + genderId + '\'' +
                ", raceId='" + raceId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDemography that = (UserDemography) o;
        return userEmail.equals(that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail);
    }
}
