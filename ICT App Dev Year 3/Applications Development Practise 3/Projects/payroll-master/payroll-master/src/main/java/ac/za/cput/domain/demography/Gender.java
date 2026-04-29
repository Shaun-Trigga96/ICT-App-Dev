package ac.za.cput.domain.demography;

import javax.persistence.*;

@Entity
public class Gender {

    @Id
    private String id;
    @Column(name = "gender_name" )
    @OneToMany()
    private String desc;

    private Gender() {}

    public Gender(Builder builder) {
        this.id = builder.id;
        this.desc = builder.desc;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static class Builder{

        private String id, desc;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder copy(Gender gender) {
            this.desc = gender.desc;
            this.id = gender.id;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}
