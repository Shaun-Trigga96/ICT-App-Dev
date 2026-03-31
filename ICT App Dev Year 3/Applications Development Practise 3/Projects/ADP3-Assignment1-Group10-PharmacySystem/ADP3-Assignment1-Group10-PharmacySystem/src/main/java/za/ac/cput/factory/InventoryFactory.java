/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * InventoryFactory.java
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.util.SiphosethuHelper;

public class InventoryFactory {
    public static Inventory createInventory(int tableStockAmount, int medicineStockAmount) {
        if(!SiphosethuHelper.isValid(tableStockAmount) || !SiphosethuHelper.isValid(medicineStockAmount))
            return null;
        return new Inventory.Builder().setTableStockAmount(tableStockAmount).setMedicineStockAmount(medicineStockAmount)
                .build();
    }
}
