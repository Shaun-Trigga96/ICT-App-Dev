package za.ac.cput.ADP3LabBookingSystem.Service;

import za.ac.cput.ADP3LabBookingSystem.Entity.Student;

import java.util.List;

public interface IStudentService extends IService<Student,String>
{
    public List<Student> getAll();
}
