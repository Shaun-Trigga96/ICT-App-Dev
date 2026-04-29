//package ac.za.cput.repostory.demography.impl;
//
//import ac.za.cput.domain.demography.Gender;
//import ac.za.cput.repostory.demography.GenderRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public abstract class GenderRepositoryImpl implements GenderRepository {
//
//    @Override
//    public Gender retrieveByDesc(String genderDesc) {
//        List<Gender> genders = findAll();
//        return genders.stream().filter(gender -> gender.getDesc().equalsIgnoreCase(genderDesc)).findAny().orElse(null);
//    }
//}
