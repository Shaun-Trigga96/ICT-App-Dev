package ac.za.cput.service.demography;

import ac.za.cput.domain.demography.Gender;
import ac.za.cput.service.IService;

import java.util.List;

public interface GenderService extends IService<Gender, String> {
    Gender retrieveByDesc(String genderDesc);
    List<Gender> getAll();
}
