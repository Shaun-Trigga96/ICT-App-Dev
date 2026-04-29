/* Prescription.java
 Domain for the Prescription
 Author: Zaeem Petersen (219010145)
 Date: 08 October 2022
*/
package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Prescription implements Serializable {

    @Id
    private String prescriptionId;
    private String prescriptionType;
    private String prescriptionDose;

    protected Prescription(){}

    //builder constructor
    private Prescription(Builder builder){
        this.prescriptionId = builder.prescriptionId;
        this.prescType = builder.prescriptionType;
        this.prescriptionDose = builder.prescriptionDose;
    }

    //getters
    public String getprescriptionId() {
        return prescriptionId;
    }
    public String getPrescType() {
        return prescriptionType;
    }
    public String getprescriptionDose() {
        return prescriptionDose;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId=" + prescriptionId +
                ", prescType='" + prescType + '\'' +
                ", prescriptionDose=" + prescriptionDose +
                '}';
    }

    public static class Builder{
        private String prescriptionId;
        private String prescriptionType
        private String prescriptionDose;

        public Builder prescriptionId(String prescriptionId) {
            this.prescriptionId = prescriptionId;
            return this;
        }
        public Builder prescType(String prescType) {
            this.prescType = prescriptionType;
            return this;
        }
        public Builder prescriptionDose(String prescriptionDose) {
            this.prescriptionDose = prescriptionDose;
            return this;
        }

        public Builder copy(Prescription prescription){
            this.prescriptionId = prescription.prescriptionId;
            this.prescType = prescription.prescriptionType;
            this.prescriptionDose = prescription.prescriptionDose;
            return this;
        }

        public Prescription build(){
            return new Prescription(this);
        }
    }
}
