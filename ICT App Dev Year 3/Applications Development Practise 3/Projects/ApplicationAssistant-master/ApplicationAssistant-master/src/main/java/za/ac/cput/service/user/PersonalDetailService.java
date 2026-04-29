package za.ac.cput.service.user;

import za.ac.cput.entity.user.PersonalDetail;
import za.ac.cput.service.IService;

import java.util.Set;

public interface PersonalDetailService extends IService<PersonalDetail, String> {
    Set<PersonalDetail> getAll();

    //unique implementation according to business rules
    Set<PersonalDetail> getAllStartingWith076(String letter);
}
