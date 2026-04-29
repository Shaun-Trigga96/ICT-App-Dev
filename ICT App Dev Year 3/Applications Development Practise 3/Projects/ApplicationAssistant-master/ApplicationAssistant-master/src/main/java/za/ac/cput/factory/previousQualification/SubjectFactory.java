package za.ac.cput.factory.previousQualification;

import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class SubjectFactory {

    public static Subject createSubject(String subjectName, int subjectMark){
        if (StringHelper.isNullorEmpty(subjectName)) return new Subject.Builder().build();
        if (StringHelper.isNullorEmpty(subjectMark + "")) return new Subject.Builder().build();
        String subjectId = GenericHelper.generateRandom();
        Subject subject = new Subject.Builder()
                .setSubjectId(subjectId)
                .setSubjectName(subjectName)
                .setSubjectMark(subjectMark)
                .build();

        return subject;
    }
}
