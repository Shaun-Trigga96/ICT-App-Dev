//package za.ac.cput.repository.previousQualification.impl;
//
//
//import za.ac.cput.entity.previousQualification.Qualification;
//import za.ac.cput.entity.previousQualification.Subject;
//import za.ac.cput.repository.previousQualification.QualificationRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class QualificationRepositoryImpl implements QualificationRepository {
//
//    private static QualificationRepository repository = null;
//    private Set<Qualification> qualificationSet;
//
//    private  QualificationRepositoryImpl()
//    {
//        this.qualificationSet = new HashSet<>();
//    }
//
//    public static QualificationRepository getRepository()
//    {
//        if( repository == null)
//        {
//            repository = new QualificationRepositoryImpl();
//        }
//        return repository;
//
//    }
//    @Override
//    public Set<Qualification> getAll () {return this.qualificationSet;}
//
//    @Override
//    public Qualification create (Qualification qualification)
//    {
//        this.qualificationSet.add(qualification);
//        return qualification;
//    }
//
//    @Override
//    public Qualification read(String qualificationId) {
//
//        for (Qualification qualification : this.qualificationSet)
//
//        {
//            if (qualification.getQualificationId().equalsIgnoreCase(qualificationId)) {return qualification;}
//        }
//
//        return null;
//    }
//
//    @Override
//    public Qualification update(Qualification qualification) {
//
//        boolean deleteQualification =  delete (qualification.getQualificationId());
//
//        if (deleteQualification)
//        {
//            this.qualificationSet.add(qualification);
//            return qualification;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String qualificationId) {
//
//        Qualification qualification = read(qualificationId);
//        if (qualification != null)
//        {
//            this.qualificationSet.remove(qualification);
//            return true;
//        }
//
//        return false;
//    }
//
//
//}
