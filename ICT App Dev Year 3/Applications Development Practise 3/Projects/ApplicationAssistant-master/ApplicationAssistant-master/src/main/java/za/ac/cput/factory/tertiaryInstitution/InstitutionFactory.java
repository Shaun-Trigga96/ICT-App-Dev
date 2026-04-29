package za.ac.cput.factory.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;


public class InstitutionFactory {

    public static Institution createInstitution(String institutionName, String institutionCode) {

        if (StringHelper.isNullorEmpty(institutionName)) return new Institution.Builder().build();
        if (StringHelper.isNullorEmpty(institutionCode)) return new Institution.Builder().build();
        String institutionId = GenericHelper.generateRandom();
        Institution verification = new Institution.Builder()
                .setInstitutionId(institutionId)
                .setInstitutionName(institutionName)
                .setInstitutionCode(institutionCode)
                .build();
        return verification;

    }

}
