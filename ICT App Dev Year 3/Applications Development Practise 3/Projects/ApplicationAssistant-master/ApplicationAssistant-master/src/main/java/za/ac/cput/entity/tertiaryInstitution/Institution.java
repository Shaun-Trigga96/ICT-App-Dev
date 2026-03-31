package za.ac.cput.entity.tertiaryInstitution;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Institution implements Serializable
{
    @Id
    private String institutionId;
    private String institutionName;
    private String institutionCode;
    //ToDo: Create entity institutionFaculty - shows which faculties belong to which institution

    protected Institution () {}

    private Institution (Builder builder){
        this.institutionId = builder.institutionId;
        this.institutionCode = builder.institutionCode;
        this.institutionName = builder.institutionName;
    }

    public String getInstitutionId() { return institutionId; }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "institutionId='" + institutionId + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", institutionCode='" + institutionCode + '\'' +
                '}';
    }

    public static class Builder {
        private String institutionId;
        private String institutionName;
        private String institutionCode;

        public Builder setInstitutionId(String institutionId) {
            this.institutionId = institutionId;
            return this;
        }

        public Builder setInstitutionName(String institutionName) {
            this.institutionName = institutionName;
            return this;
        }

        public Builder setInstitutionCode(String institutionCode) {
            this.institutionCode = institutionCode;
            return this;
        }

        public Builder copy(Institution institution) {
            this.institutionId = institution.institutionId;
            this.institutionName = institution.institutionName;
            this.institutionCode = institution.institutionCode;
            return this;
        }

        public Institution build() {
            return new Institution(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution that = (Institution) o;
        return institutionId.equals(that.institutionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institutionId);
    }
}
