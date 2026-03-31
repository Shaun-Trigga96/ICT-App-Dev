package za.ac.cput.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class PersonalDetail {

    @Id
    private String personalId;
    private String contactEmail;
    private String contactCellNumber;
    private String qualificationType;//Remove and add entity personalDetailQualification

    public PersonalDetail() {
    }

    private PersonalDetail(Builder builder){
        this.personalId = builder.personalId;
        this.contactCellNumber = builder.contactCellNumber;
        this.contactEmail = builder.contactEmail;
        this.qualificationType = builder.qualificationType;
    }

    public String getPersonalId() { return personalId; }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactCellNumber() {
        return contactCellNumber;
    }

    public String getQualificationType() {
        return qualificationType;
    }


    @Override
    public String toString() {
        return "PersonalDetail{" +
                "personalId='" + personalId + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactCellNumber='" + contactCellNumber + '\'' +
                ", qualificationType='" + qualificationType + '\'' +
                '}';
    }

    public static class Builder{
        private String personalId;
        private String contactEmail;
        private String contactCellNumber;
        private String qualificationType;

        public Builder setPersonalId(String personalId) {
            this.personalId = personalId;
            return this;
        }

        public Builder setContactEmail(String contactEmail){
            this.contactEmail = contactEmail;
            return this;
        }

        public Builder setContactCellNumber(String contactCellNumber){
            this.contactCellNumber = contactCellNumber;
            return this;
        }

        public Builder setQualificationType(String qualificationType){
            this.qualificationType = qualificationType;
            return this;
        }

        public Builder copy(PersonalDetail personalDetail) {
            this.personalId = personalDetail.personalId;
            this.contactEmail = personalDetail.contactEmail;
            this.contactCellNumber = personalDetail.contactCellNumber;
            this.qualificationType = personalDetail.qualificationType;
            return this;
        }

        public PersonalDetail build(){
            return new PersonalDetail(this);
        }
    }
}
