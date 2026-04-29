/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * Inventory.java
 */
package za.ac.cput.domain;

import javax.persistence.*;

@Entity
@Table
public class Inventory {
    @Column

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoryID;
    @Column
    private String tableStockAmount, medicineStockAmount;

    public Inventory(){}

    private Inventory(Builder builder) {
        if(builder.inventoryId > 0)
            this.inventoryID = builder.inventoryId;
        this.tableStockAmount = String.valueOf(builder.tableStockAmount);
        this.medicineStockAmount = String.valueOf(builder.medicineStockAmount);
    }

    public long getInventoryID() {
        return inventoryID;
    }

    public String getTableStockAmount() {
        return tableStockAmount;
    }

    public String getMedicineStockAmount() {
        return medicineStockAmount;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", tableStockAmount=" + tableStockAmount +
                ", medicineStockAmount=" + medicineStockAmount +
                '}';
    }

    public static class Builder {
        private long inventoryId;
        private int tableStockAmount, medicineStockAmount;

        public Builder setTableStockAmount(int tableStockAmount) {
            this.tableStockAmount = tableStockAmount;
            return this;
        }

        public Builder setMedicineStockAmount(int medicineStockAmount) {
            this.medicineStockAmount = medicineStockAmount;
            return this;
        }

        public Inventory build(){
            return new Inventory(this);
        }

        public Builder copy(Inventory I){
            this.inventoryId = I.inventoryID;
            this.tableStockAmount = Integer.parseInt(I.tableStockAmount);
            this.medicineStockAmount = Integer.parseInt(I.medicineStockAmount);
            return this;
        }
    }

}
