package controllers;


import dao.AppPatientDao;
import dao.impl.MySQLPatientDao;
import dao.impl.MySQLUserDao;
import models.Patient;
import models.comparators.PatientComparator;
import services.PatientListAppService;
import services.UsersAppService;
import services.impl.PatientListAppServiceImpl;
import services.impl.UsersAppServiceImpl;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@WebServlet(name = "PatientListServlet", value = "/patientList")
public class PatientListServlet extends HttpServlet {


    private PatientListAppService servicePatients;

    private UsersAppService serviceUser;

    @Override
    public void init() throws ServletException {
        servicePatients = new PatientListAppServiceImpl(new MySQLPatientDao());
        serviceUser = new UsersAppServiceImpl(new MySQLUserDao());


//        AppPatientDao dao = new MySQLPatientDao();
//
//        Patient patient = Patient.PatientBuilder.getBuilder()
//                .hospitalizationDate()
//                .comment("komentarz")
//                .prescribingDoctor("Agnieszka Mrozińska")
//                .refferingDoctor("Mędraś")
//                .diagnosis("Pacjentka jest w ciąży")
//                .phoneNumber("7321031020")
//                .foreigner(true)
//                .pesel("9892929292")
//                .firstName("Zbigniew")
//                .lastName("Stonoga")
//                .lastPeriodDate(null)
//                .scheludedRegistration(true)
//                .isActive()
//                .pragnancyAge(36)
//                .build();
//        Patient patient1 = Patient.PatientBuilder.getBuilder()
//                .hospitalizationDate()
//                .comment("no comment")
//                .prescribingDoctor("Agnieszka Mrozińska")
//                .refferingDoctor("Mędraś")
//                .diagnosis("Pacjentka jest w ciąży")
//                .phoneNumber("7321031020")
//                .pesel("9892929292")
//                .foreigner(true)
//                .firstName("Lila")
//                .lastName("Kotowska")
//                .lastPeriodDate(null)
//                .scheludedRegistration(true)
//                .isActive()
//                .pragnancyAge(36)
//                .build();
//        dao.savePatient(patient);
//        dao.savePatient(patient1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Patient> patientList = servicePatients.getPatientList();
        Collections.sort(patientList, new PatientComparator());




        req.setAttribute(ServletUtils.PATIENT_LIST, patientList);
        req.getRequestDispatcher("/patientList.jsp").forward(req, resp);

    }
}
