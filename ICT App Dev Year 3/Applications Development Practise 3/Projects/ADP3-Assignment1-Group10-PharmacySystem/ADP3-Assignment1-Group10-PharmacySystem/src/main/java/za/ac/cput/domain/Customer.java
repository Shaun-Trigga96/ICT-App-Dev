package za.ac.cput.domain;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/*Customer.java
* Entity for the Customer
* Thabiso Matsaba 220296006
* 10 August 2022
*/
@Entity
public class Customer implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private String customerId;
    private Name name;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
    }

    protected Customer() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getCustomerId().equals(customer.getCustomerId()) && getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getName());
    }

    public static class Builder {

        private String customerId;
        private Name name;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder copy(Customer Customer) {
            this.customerId = Customer.customerId;
            this.name = Customer.name;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}



