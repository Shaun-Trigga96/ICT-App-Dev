package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Emilio Castano
 * Student Number: 219035709
 * Program: Genre Structure of builder pattern
 *
 */
@Entity
public class Genre {
    @Id
    private String genreId;
    private String genreName, description;

    private Genre(){}

    private Genre(genreBuilder genreBuilder){

        this.genreId = genreBuilder.genreId;
        this.genreName = genreBuilder.genreName;
        this.description = genreBuilder.description;
    }

    public String getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getDescription() {
        return description;
    }

    public static class genreBuilder{

        private String genreId, genreName, description;

        public genreBuilder setGenreId(String genreId) {
            this.genreId = genreId;
            return this;
        }

        public genreBuilder setGenreName(String genreName) {
            this.genreName = genreName;
            return this;
        }

        public genreBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public genreBuilder copy(Genre genre){
            this.genreId = genre.genreId;
            this.genreName = genre.genreName;
            this.description = genre.description;
            return this;
        }

        public Genre build(){
            return new Genre(this);
        }
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId='" + genreId +
                ", genreName='" + genreName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
