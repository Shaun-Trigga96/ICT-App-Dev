package ac.za.cput.adp3.xyzcongolmerate.domain.demography;

/**
 * DO NOT MODIFY
 */
public class Gender {

    private String genderId, genderDescription;

    private Gender() {}

    public Gender(Builder builder){
        this.genderId = builder.genderId;
        this.genderDescription = builder.genderDescription;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderDescription='" + genderDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String genderId, genderDescription;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder genderDescription(String genderDescription) {
            this.genderDescription = genderDescription;
            return this;
        }

        public Builder copy(Gender gender) {
            this.genderDescription = gender.genderDescription;
            this.genderId = gender.genderId;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}
