package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/* Studio.java
        Entity for studio
        Author: Marchello Carolus 218234457
        Date: 11 June 2021
        */



@Entity
public class Studio {

    @Id
    private String studioId;
    private String studioName;


    private Studio() {

    }

    private Studio(Builder builder) {
        this.studioId = builder.studioId;
        this.studioName = builder.studioName;

    }

    public String getStudioId() {
        return studioId;
    }

    public String getStudioName() {
        return studioName;
    }



    public static class Builder{

        private String studioId;
        private String studioName;

        public Studio.Builder setStudioId(String studioId) {
            this.studioId = studioId;

            return this;
        }
        public Studio.Builder setStudioName(String studioName) {
            this.studioName = studioName;

            return this;
        }


        public Studio build(){

            return new Studio(this);
        }

        public Studio.Builder copy(Studio studio){

            this.studioId = studio.studioId;
            this.studioName = studio.studioName;

            return this;

        }

    }
    @Override
    public String toString() {
        return "Builder{" +
                "Studio ID ='" + studioId + '\'' +
                ", Studio Name ='" + studioName + '\'' +

                '}';
    }



}
