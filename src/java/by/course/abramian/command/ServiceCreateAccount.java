/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.ClientDAO;
import by.course.abramian.dal.dao.exception.logical.PointerNullException;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.entitydto.Client;
import by.course.abramian.dal.entitydto.Role;
import by.course.abramian.dal.entitydto.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceCreateAccount implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	BasicActionDAO tempClient = new ClientDAO();
	Client client = new Client();
	client.setPassport(request.getParameter("passport"));
	client.setFirstName(request.getParameter("first_name"));
	client.setLastName(request.getParameter("last_name"));
	client.setFatherName(request.getParameter("father_name"));
	client.setEmail(request.getParameter("email"));
	client.setNumberPhone(request.getParameter("number_phone"));
	client.setUser(
		new User(
			request.getParameter("login"),
			request.getParameter("password"),
			new Role()));

	try {
	    tempClient.insertDefault(client);

	} catch (SQLDBAPIException | PointerNullException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}
	return "index.jsp";
    }

}
