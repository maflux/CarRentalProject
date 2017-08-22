/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.RoleDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.logical.PointerNullException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.IRole;
import by.course.abramian.dal.entitydto.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceRoleAdd implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	Role tempRole = new Role(
		Integer.parseInt(request.getParameter("idRole")),
		request.getParameter("role"));

	try {

	    IRole iRole = new RoleDAO();
	    iRole.insertById(tempRole);

	} catch (IndexWrongException | PointerNullException | SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "web/pagesForAdmin/roles.jsp";
    }

}
