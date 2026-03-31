//package za.ac.cput.repository.tertiaryInstitution.impl;
//
//
//import za.ac.cput.entity.tertiaryInstitution.Faculty;
//import za.ac.cput.repository.tertiaryInstitution.FacultyRepository;
//import java.util.*;
//@Deprecated
//public class FacultyRepositoryImpl implements FacultyRepository {
//
//    private static FacultyRepository repository = null;
//    private Set<Faculty> facultySet;
//
//    private FacultyRepositoryImpl()
//    {
//        this.facultySet = new HashSet<>();
//    }
//
//    public static FacultyRepository getRepository()
//    {
//        if(repository == null)
//        {
//            repository = new FacultyRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public Set<Faculty> getAll()
//    {
//        return this.facultySet;
//    }
//
//    @Override
//    public Faculty create(Faculty faculty)
//    {
//        this.facultySet.add(faculty);
//        return faculty;
//    }
//
//    @Override
//    public Faculty read(String facultyId)
//    {
//        for(Faculty faculty : this.facultySet)
//        {
//            if(faculty.getFacultyId().equalsIgnoreCase(facultyId))
//            {
//                return faculty;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Faculty update(Faculty faculty)
//    {
//        boolean deleteFaculty = delete(faculty.getFacultyId());
//        if(deleteFaculty)
//        {
//            this.facultySet.add(faculty);
//            return faculty;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String facultyId)
//    {
//        Faculty faculty = read(facultyId);
//        if(faculty != null)
//        {
//            this.facultySet.remove(faculty);
//            return true;
//        }
//        return false;
//    }
//}
//
