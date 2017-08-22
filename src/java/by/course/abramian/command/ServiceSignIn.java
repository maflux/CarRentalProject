/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.UserDAO;
import by.course.abramian.dal.dao.exception.technical.LoginPasswordWrongException;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.entitydto.Entity;
import by.course.abramian.dal.entitydto.User;
import by.course.abramian.listener.ContextListener;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceSignIn implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	StringBuilder tempString = new StringBuilder("index.jsp");
	HttpSession session = request.getSession();

	try {

	    UserDAO userDAO = new UserDAO();
	    List<Entity> tempUsers = userDAO.getAll();
	    List<User> listUsers = new ArrayList<>();
	    for (Entity tempUser : tempUsers) {
		listUsers.add((User) tempUser);
	    }

	    session.setAttribute("header", "header.jsp");

	    String login = request.getParameter("login");
	    String password = request.getParameter("password");
	    int idUser = userDAO.getIDUserByLoginPassword(login, password);

	    session.setAttribute("idUser", idUser);

	    for (User listUser : listUsers) {
		if (listUser.getLogin().equalsIgnoreCase(login)
			&& listUser.getPassword().equalsIgnoreCase(password)) {
		    switch (listUser.getRole().getRole()) {
			case "Administrator": {
			    session.setAttribute("header", "web/header/headerAdmin.jsp");
			    ContextListener.context.setAttribute("roleAdmin", true);
			    break;
			}
			case "User": {
			    session.setAttribute("header", "web/header/headerUser.jsp");
			    break;
			}
			case "Manager": {
			    session.setAttribute("header", "web/header/headerManager.jsp");
			    break;
			}
		    }
		    session.setAttribute("checkSignIn", true);
		    break;
		}
	    }

	} catch (SQLDBAPIException | LoginPasswordWrongException ex) {
	    LOGGER.error(ex);
	    tempString = new StringBuilder("web/500.jsp");
	    request.setAttribute("errorMessage", ex);

	}
	return tempString.toString();
    }

}
