package ac.za.cput.service.demography.impl;

import ac.za.cput.domain.demography.Gender;
import ac.za.cput.repostory.demography.GenderRepository;
//import ac.za.cput.repostory.demography.impl.GenderRepositoryImpl;
import ac.za.cput.service.demography.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GenderServiceImpl implements GenderService {

    private static GenderService genderService = null;

    @Autowired
    private GenderRepository genderRepository;

    private GenderServiceImpl() {

    }

    public static GenderService getGenderService() {
        if (genderService == null) genderService = new GenderServiceImpl();
        return genderService;
    }

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.save(gender);
    }

    @Override
    public Gender read(String s) {
        Optional<Gender> optGender = this.genderRepository.findById(s);
        return optGender.orElse(null);
    }

    @Override
    public Gender update(Gender gender) {
        return this.genderRepository.save(gender);
    }

    @Override
    public void delete(String s) {
        this.genderRepository.deleteById(s);
    }

    @Override
    public Gender retrieveByDesc(String genderDesc) {
        List<Gender> genders = getAll();
        for (Gender gender : genders) {
            if (gender.getDesc().equalsIgnoreCase(genderDesc)) return gender;
        }
        return null;
    }

    @Override
    public List<Gender> getAll() {
        return this.genderRepository.findAll();
    }
}
