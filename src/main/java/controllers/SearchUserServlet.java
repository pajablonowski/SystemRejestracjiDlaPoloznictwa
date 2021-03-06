package controllers;


import dao.impl.MySQLPatientDao;
import dao.impl.MySQLUserDao;
import models.AppUser;
import models.Patient;
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
import java.util.List;

import static services.impl.PatientListAppServiceImpl.getCurrentSearchedAppUsersList;


@WebServlet(name = "SearchUserServlet", value = "/searchUser")
public class SearchUserServlet extends HttpServlet {


    private UsersAppService usersService;


    @Override
    public void init() throws ServletException {
        usersService = new UsersAppServiceImpl(new MySQLUserDao());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/searchUser.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String value = req.getParameter(ServletUtils.SEARCH_USER);
        req.getSession().setAttribute(ServletUtils.SEARCH_USER,value);
        getCurrentSearchedAppUsersList(req,usersService);


        req.getRequestDispatcher("/searchUser.jsp").forward(req, resp);

    }

}