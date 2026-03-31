//package za.ac.cput.repository.user.impl;
//
//import za.ac.cput.entity.user.PersonalDetail;
//import za.ac.cput.repository.user.PersonalDetailRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class PersonalDetailRepositoryImpl implements PersonalDetailRepository{
//
//    private static PersonalDetailRepository repository = null;
//    private Set<PersonalDetail> personalDetailSet;
//
//    private PersonalDetailRepositoryImpl()
//    {
//        this.personalDetailSet = new HashSet<>();
//    }
//
//    public static PersonalDetailRepository getRepository()
//    {
//        if(repository == null)
//        {
//            repository = new PersonalDetailRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public Set<PersonalDetail> getAll() {
//        return this.personalDetailSet;
//    }
//
//    @Override
//    public PersonalDetail create(PersonalDetail personalDetail)
//    {
//        this.personalDetailSet.add(personalDetail);
//        return personalDetail;
//    }
//
//    @Override
//    public PersonalDetail read(String personalId)
//    {
//        for(PersonalDetail personalDetail : this.personalDetailSet)
//        {
//            if(personalDetail.getPersonalId().equalsIgnoreCase(personalId))
//            {
//                return personalDetail;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public PersonalDetail update(PersonalDetail personalDetail)
//    {
//        boolean deletePersonalDetail = delete(personalDetail.getPersonalId());
//        if(deletePersonalDetail)
//        {
//            this.personalDetailSet.add(personalDetail);
//            return personalDetail;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String personalId)
//    {
//        PersonalDetail personalDetail = read(personalId);
//        if(personalDetail != null)
//        {
//            this.personalDetailSet.remove(personalDetail);
//            return true;
//        }
//        return false;
//    }
//
//
//}
