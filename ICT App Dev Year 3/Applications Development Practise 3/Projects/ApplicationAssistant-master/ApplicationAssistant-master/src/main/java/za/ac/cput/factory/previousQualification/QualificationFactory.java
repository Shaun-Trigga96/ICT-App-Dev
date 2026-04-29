package za.ac.cput.factory.previousQualification;

import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class QualificationFactory {

    public static Qualification createQualification(String levelOfQualifications){
        if (StringHelper.isNullorEmpty(levelOfQualifications)) return new Qualification.Builder().build();
        String qualificationId = GenericHelper.generateRandom();
        Qualification qualification = new Qualification.Builder()
                .setQualificationId(qualificationId)
                .setLevelOfQualifications(levelOfQualifications)
                //.setSubjectList(subjectList)
                .build();

        return  qualification;
    }
}
