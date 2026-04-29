package za.ac.cput.factory;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRentalPrice;
import java.util.UUID;

public class UserRentalPriceFactory {

    public static UserRentalPrice build(int duration, double amount){
        if (duration<0 || amount<0){
            return null;
        }

        String id= UUID.randomUUID().toString();

        return new UserRentalPrice.UserRentalPriceBuilder()
                .setRentalId(id).setDuration(duration).setAmount(amount).build();
    }
}
