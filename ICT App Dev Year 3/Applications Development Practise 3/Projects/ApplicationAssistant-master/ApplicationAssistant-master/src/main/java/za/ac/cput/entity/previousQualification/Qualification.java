package za.ac.cput.entity.previousQualification;


import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Objects;
import java.util.Set;
@Entity
public class Qualification {
    @Id private String qualificationId;
//    private Set<Subject> subjectList;// Remove and create an entity qualificationSubject
    private String levelOfQualifications;

    protected Qualification(){}

    private Qualification(Builder builder) {
        this.qualificationId = builder.qualificationId;
//        this.subjectList = builder.subjectList;
        this.levelOfQualifications = builder.levelOfQualifications;
    }

    public String getQualificationId() { return qualificationId; }

// public Set<Subject> getSubjectList() {
//        return subjectList;
//    }

    public String getLevelOfQualifications() {
        return levelOfQualifications;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "qualificationId='" + qualificationId + '\'' +
                ", subjectList=" /*+ subjectList */+
                ", levelOfQualifications='" + levelOfQualifications + '\'' +
                '}';
    }

    public static class Builder {
        private String qualificationId;
//        private Set<Subject> subjectList;
        private String levelOfQualifications;

        public Builder setQualificationId(String qualificationId) {
            this.qualificationId = qualificationId;
            return this;
        }

//        public Builder setSubjectList(Set<Subject> subjectList) {
//            this.subjectList = subjectList;
//            return this;
//        }

        public Builder setLevelOfQualifications(String levelOfQualifications) {
            this.levelOfQualifications = levelOfQualifications;
            return this;
        }

        public  Builder copy(Qualification qualification) {
            this.qualificationId = qualification.qualificationId;
//            this.subjectList = qualification.subjectList;
            this.levelOfQualifications = qualification.levelOfQualifications;
            return this;
        }

        public Qualification build(){
            return new Qualification(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qualification that = (Qualification) o;
        return qualificationId.equals(that.qualificationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualificationId);
    }
}
