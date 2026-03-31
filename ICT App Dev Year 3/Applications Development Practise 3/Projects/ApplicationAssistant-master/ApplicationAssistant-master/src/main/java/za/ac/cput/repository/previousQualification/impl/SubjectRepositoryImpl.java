//package za.ac.cput.repository.previousQualification.impl;
//
//import za.ac.cput.entity.previousQualification.Subject;
//import za.ac.cput.repository.previousQualification.SubjectRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class SubjectRepositoryImpl implements SubjectRepository {
//
//    private static SubjectRepository repository = null;
//    private Set<Subject>subjectSet;
//
//    private SubjectRepositoryImpl() { this.subjectSet = new HashSet<>(); }
//
//    public static SubjectRepository getRepository()
//    {
//        if (repository == null)
//        {
//            repository = new SubjectRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public Set<Subject> getAll() {
//        return this.subjectSet;
//    }
//
//    @Override
//    public void clearAll() {
//        this.subjectSet.clear();
//    }
//
//    @Override
//    public Subject create(Subject subject) {
//       this.subjectSet.add(subject);
//       return subject;
//    }
//
//    @Override
//    public Subject read(String subjectId)
//    {
//        for (Subject subject: this.subjectSet)
//        {
//            if (subject.getSubjectId().equalsIgnoreCase(subjectId))
//            {
//                return subject;
//            }
//        }
//        return  null;
//    }
//
//    @Override
//    public Subject update(Subject subject) {
//
//        boolean deleteSubject = delete(subject.getSubjectId());
//
//        if(deleteSubject)
//        {
//            this.subjectSet.add(subject);
//            return subject;
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean delete(String subjectId) {
//        Subject  subject = read(subjectId);
//        if(subject!=null)
//        {
//            this.subjectSet.remove(subject);
//            return true;
//        }
//
//        return false;
//    }
//}
