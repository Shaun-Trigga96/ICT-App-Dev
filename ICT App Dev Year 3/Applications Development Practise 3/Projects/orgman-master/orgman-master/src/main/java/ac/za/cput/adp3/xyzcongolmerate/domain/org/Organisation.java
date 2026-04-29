package ac.za.cput.adp3.xyzcongolmerate.domain.org;

/**
 * DO NOT MODIFY!
 */
public class Organisation {

    private String orgCode, orgName;

    private Organisation() {}

    public Organisation(Builder builder) {
        this.orgCode = builder.orgCode;
        this.orgName = builder.orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }

    public static class Builder {
        private String orgCode, orgName;

        public Builder orgCode(String orgCode) {
            this.orgCode = orgCode;
            return this;
        }

        public Builder orgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public Builder copy(Organisation organisation) {
            this.orgName = organisation.orgName;
            this.orgCode = organisation.orgCode;
            return this;
        }

        public Organisation build() {
            return new Organisation(this);
        }
    }
}
