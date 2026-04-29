package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.PersonalDetail;
import za.ac.cput.repository.user.PersonalDetailRepository;
import za.ac.cput.service.user.PersonalDetailService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailService {


    @Autowired
    private PersonalDetailRepository repository;



    @Override
    public Set<PersonalDetail> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<PersonalDetail> getAllStartingWith076(String letter) {
        Set<PersonalDetail> personalDetails = getAll();
        Set<PersonalDetail> personalDetailsWith076 = new HashSet<>();
        for (PersonalDetail personalDetail : personalDetails) {
            if (personalDetail.getContactCellNumber().trim().toLowerCase().startsWith(letter)) {
                personalDetailsWith076.add(personalDetail);
            }
        }
        return personalDetailsWith076;    }

    @Override
    public PersonalDetail create(PersonalDetail personalDetail) {
        return this.repository.save(personalDetail);
    }

    @Override
    public PersonalDetail read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public PersonalDetail update(PersonalDetail personalDetail) {

        if(this.repository.existsById(personalDetail.getPersonalId())){
            return this.repository.save(personalDetail);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        if(this.repository.existsById(id)) return false;
        else return true;
    }
}
