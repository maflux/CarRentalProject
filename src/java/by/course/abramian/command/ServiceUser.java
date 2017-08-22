/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.RoleDAO;
import by.course.abramian.dal.dao.UserDAO;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.entitydto.Entity;
import by.course.abramian.dal.entitydto.Role;
import by.course.abramian.dal.entitydto.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceUser implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	try {

	    BasicActionDAO actionDAO = new UserDAO();
	    List<Entity> tempUsers = actionDAO.getAll();
	    List<User> listUsers = new ArrayList<>();
	    for (Entity tempUser : tempUsers) {
		listUsers.add((User) tempUser);
	    }

	    actionDAO = new RoleDAO();
	    List<Entity> tempRoles = actionDAO.getAll();
	    List<Role> listRoles = new ArrayList<>();
	    for (Entity tempRole : tempRoles) {
		listRoles.add((Role) tempRole);
	    }

	    request.setAttribute("listRoles", listRoles);
	    request.setAttribute("listUsers", listUsers);

	} catch (SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}
	return "web/pagesForAdmin/users.jsp";
    }

}
