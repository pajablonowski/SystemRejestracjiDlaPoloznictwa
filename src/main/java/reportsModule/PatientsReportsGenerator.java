package reportsModule;

import jxl.write.WriteException;
import models.PatientExtended;
import org.apache.poi.ss.usermodel.Workbook;
import reportsModule.reportsList.GenerateSelectedPatientList;

import java.io.IOException;
import java.util.List;

public class PatientsReportsGenerator {


    public Workbook generate(ReportsList report, List<PatientExtended> patientList) throws IOException, WriteException {

        switch (report){
            case GENERATE_SELECTED_PATIENT_LIST:
                return new GenerateSelectedPatientList().generate(patientList);
        }
        return null;
    }

}
