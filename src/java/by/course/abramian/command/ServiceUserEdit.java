/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.UserDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.logical.PointerNullException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.IUserDAO;
import by.course.abramian.dal.entitydto.Role;
import by.course.abramian.dal.entitydto.User;
import static by.course.abramian.log4j.Log4j.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceUserEdit implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	try {
	    IUserDAO iUser = new UserDAO();
	    switch (request.getParameter("action")) {
		case "Edit": {
		    User user = new User(
			    Integer.parseInt(request.getParameter("idUser")),
			    request.getParameter("userLogin"),
			    request.getParameter("userPassword"),
			    new Role(
				    Integer.parseInt(request.getParameter("userIdRole")),
				    null));

		    iUser.updateById(
			    user,
			    Integer.parseInt(request.getParameter("selectedUserId")));
		    break;
		}
		case "Delete": {
		    iUser.delete(Integer.parseInt(request.getParameter("selectedUserId")));
		    break;
		}
	    }

	} catch (IndexWrongException | SQLDBAPIException | PointerNullException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}
	return "web/pagesForAdmin/users.jsp";
    }

}
