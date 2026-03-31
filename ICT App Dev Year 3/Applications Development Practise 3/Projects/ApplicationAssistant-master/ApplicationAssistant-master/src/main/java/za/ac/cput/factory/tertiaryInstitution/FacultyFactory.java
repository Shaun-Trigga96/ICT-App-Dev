package za.ac.cput.factory.tertiaryInstitution;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class FacultyFactory {

    public static Faculty createFaculty (String facultyCode, String facultyName){

        if (StringHelper.isNullorEmpty(facultyCode)) return new Faculty.Builder().build();
        if (StringHelper.isNullorEmpty(facultyName)) return new Faculty.Builder().build();
        String facultyId = GenericHelper.generateRandom();
        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyCode(facultyCode)
                .setFacultyName(facultyName)
                .build();
    }
}
