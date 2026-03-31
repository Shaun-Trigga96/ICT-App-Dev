package za.ac.cput.entity.tertiaryInstitution;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Faculty {
    @Id
    private String facultyId;
    private String facultyName;
    private String facultyCode;
    //ToDo: Create entity FacultyDepartment - shows which departments belong to which faculty

    private Faculty (Builder builder){
        this.facultyId = builder.facultyId;
        this.facultyCode = builder.facultyCode;
        this.facultyName = builder.facultyName;
    }

    protected Faculty (){}

    public String getFacultyId() { return facultyId; }

    public String getFacultyName() { return facultyName;    }

    public String getFacultyCode() { return facultyCode;    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId='" + facultyId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                '}';
    }

    public static class Builder{
        private String facultyId;
        private String facultyName;
        private String facultyCode;

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setFacultyCode(String facultyCode) {
            this.facultyCode = facultyCode;
            return this;
        }

        public Builder copy(Faculty faculty) {
            this.facultyId = faculty.facultyId;
            this.facultyName = faculty.facultyName;
            this.facultyCode = faculty.facultyCode;
            return this;
        }

        public Faculty build(){
            return new Faculty(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyId.equals(faculty.facultyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId);
    }
}
