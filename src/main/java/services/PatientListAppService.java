package services;

import jxl.write.WriteException;
import models.Patient;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface PatientListAppService {

    List<Patient> getPatientList();

    List<Patient> getSearchingResults(String search);

    Patient getPatientById(Long id);

    void save(Patient patient);

    void deletePatient(Long id);

    void updatePatient(Patient oldData, Patient newData);

    boolean isHospitalizationDateAvailable(Date data, Long idPatient);

    Date hospitalizationDateCounterForScheduledRegistration(Date dataStart, int age, Long idPatient);

    Date hospitalizationDateSetterForNotScheduledRegistration(HttpServletRequest req);

    Workbook exportListToXLS(List<Patient> patientList) throws IOException, WriteException;

    List <String> getAvailableDateList(Long idPatient);

    List <Patient> getpatientListByID(List<Long> idList);

}
