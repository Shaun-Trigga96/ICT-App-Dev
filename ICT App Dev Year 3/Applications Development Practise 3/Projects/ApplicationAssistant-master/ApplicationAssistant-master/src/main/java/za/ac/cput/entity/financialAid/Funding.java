package za.ac.cput.entity.financialAid;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Funding {

    @Id
    private String fundingId;
    private String fundingName;
    private String fundingRequirements;

    protected Funding (){}

    private Funding(Builder builder){
        this.fundingId = builder.fundingId;
        this.fundingName = builder.fundingName;
        this.fundingRequirements = builder.fundingRequirements;
    }

    public String getFundingId() { return fundingId; }

    public String getFundingName() { return fundingName; }

    public String getFundingRequirements() { return fundingRequirements; }

    @Override
    public String toString() {
        return "Funding{" +
                "fundingId='" + fundingId + '\'' +
                ", fundingName='" + fundingName + '\'' +
                ", fundingRequirements='" + fundingRequirements + '\'' +
                '}';
    }

    public static class Builder{
        private String fundingId;
        private String fundingName;
        private String fundingRequirements;

        public Builder setFundingId(String fundingId) {
            this.fundingId = fundingId;
            return this;
        }

        public Builder setFundingName(String fundingName) {
            this.fundingName = fundingName;
            return this;
        }

        public Builder setFundingRequirements(String fundingRequirements) {
            this.fundingRequirements = fundingRequirements;
            return this;
        }

        public Builder copy(Funding funding) {
            this.fundingId = funding.fundingId;
            this.fundingName = funding.fundingName;
            this.fundingRequirements = funding.fundingRequirements;
            return this;
        }

        public Funding build(){
            return new Funding(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funding funding = (Funding) o;
        return fundingId.equals(funding.fundingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundingId);
    }
}
