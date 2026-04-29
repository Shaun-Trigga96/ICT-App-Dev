package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.Student;
import za.ac.cput.ADP3LabBookingSystem.Repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private static StudentService service = null;

    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(Student student)
    {
        return this.repository.save(student);
    }

    @Override
    public Student read(String studentNumber)
    {
        return this.repository.findById(studentNumber).orElse(null);
    }

    @Override
    public Student update(Student student)
    {
        if(this.repository.existsById(student.getStudentNumber()))
            return  this.repository.save(student);

        return null;
    }

    @Override
    public boolean delete(String studentNumber)
    {
        this.repository.deleteById(studentNumber);
        if(this.repository.existsById(studentNumber))
            return false;
        else return true;
    }

    @Override
    public List<Student> getAll()
    {
        return this.repository.findAll();
    }
}
