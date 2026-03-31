package za.ac.cput.factory;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRental;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UserRentalFactory {

    public static UserRental build(String userId, String movieId){

        SimpleDateFormat formatDate= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String datetime = formatDate.format(date);

        if (userId.isEmpty() || movieId.isEmpty() ){
            return null;
        }

        String id= UUID.randomUUID().toString();

        return new UserRental.UserRentalBuilder()
                .setRentalId(id).setUserId(userId).setMovieId(movieId).setRentalDate(datetime).build();
    }

}
