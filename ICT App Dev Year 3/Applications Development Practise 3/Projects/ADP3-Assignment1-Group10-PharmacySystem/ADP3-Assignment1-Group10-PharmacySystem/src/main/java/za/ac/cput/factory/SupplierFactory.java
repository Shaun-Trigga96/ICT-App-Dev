package za.ac.cput.factory;

import za.ac.cput.domain.Medication;
import za.ac.cput.domain.Supplier;
import za.ac.cput.util.StringHelper;

public class SupplierFactory {

    public static Supplier createSupplier(String suppId, String suppName){

        if(StringHelper.isNullorEmpty(suppId)) {
            throw new IllegalArgumentException("Supplier ID is null or empty");
        }else if (StringHelper.isNullorEmpty(suppName)){
            throw new IllegalArgumentException("Medication Name is null or empty");
        }
        return new Supplier.Builder()
                .setSuppId(suppId)
                .setSuppName(suppName)
                .build();
    }

}
