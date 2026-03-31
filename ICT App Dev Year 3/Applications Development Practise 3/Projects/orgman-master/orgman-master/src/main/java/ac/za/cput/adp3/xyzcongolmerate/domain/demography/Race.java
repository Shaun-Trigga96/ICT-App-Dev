package ac.za.cput.adp3.xyzcongolmerate.domain.demography;

/**
 * DO NOT MODIFY.
 */
public class Race {

    private String raceId, raceDescription;

    private Race() {}

    public Race(Builder builder) {
        this.raceDescription = builder.raceDescription;
        this.raceId = builder.raceId;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceDescription='" + raceDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String raceId, raceDescription;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder raceDescription(String raceDescription) {
            this.raceDescription = raceDescription;
            return this;
        }

        public Race build() {
            return new Race(this);
        }

        public Builder copy(Race race) {
            this.raceDescription = race.raceDescription;
            this.raceId = race.raceId;
            return this;
        }
    }
}
