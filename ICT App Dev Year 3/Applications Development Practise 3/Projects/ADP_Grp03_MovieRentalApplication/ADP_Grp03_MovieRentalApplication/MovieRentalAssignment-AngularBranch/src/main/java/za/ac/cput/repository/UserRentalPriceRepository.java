package za.ac.cput.repository;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRentalPrice;

import java.util.HashSet;
import java.util.Set;
@Deprecated
public class UserRentalPriceRepository implements IUserRentalPriceRepository {
    private static UserRentalPriceRepository repository = null;
    private Set<UserRentalPrice> userRentalPriceDB = null;

    private UserRentalPriceRepository() { userRentalPriceDB = new HashSet<UserRentalPrice>(); }

    public static UserRentalPriceRepository getRepository(){
        if (repository == null){
            repository = new UserRentalPriceRepository();
        }

        return repository;

    }

    @Override
    public UserRentalPrice create(UserRentalPrice userRentalPrice) {
        boolean success = userRentalPriceDB.add(userRentalPrice);
        if (!success)
            return null;
        return userRentalPrice;
    }

    @Override
    public UserRentalPrice read(String id) {
        for (UserRentalPrice r : userRentalPriceDB) {
            if (r.getRentalId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public UserRentalPrice update(UserRentalPrice userRentalPrice) {
        UserRentalPrice oldUserRentalPrice = read(userRentalPrice.getRentalId());
        if (oldUserRentalPrice != null) {
            userRentalPriceDB.remove(oldUserRentalPrice);
            userRentalPriceDB.add(userRentalPrice);
            return userRentalPrice;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        UserRentalPrice userRentalPriceToDelete = read(id);
        if (userRentalPriceToDelete == null)
            return false;
        userRentalPriceDB.remove(userRentalPriceToDelete);
        return true;
    }

    @Override
    public Set<UserRentalPrice> getAll() {
        return userRentalPriceDB;
    }
}
