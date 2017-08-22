/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.ModelDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.logical.PointerNullException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.IModelDAO;
import by.course.abramian.dal.entitydto.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceModelAdd implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	Model tempModel = new Model(
		request.getParameter("color"),
		request.getParameter("transmission"),
		request.getParameter("bodyType"),
		Integer.parseInt(request.getParameter("power")),
		Integer.parseInt(request.getParameter("idModel")));

	try {

	    IModelDAO iModelDAO = new ModelDAO();
	    iModelDAO.insertById(tempModel);

	} catch (IndexWrongException | PointerNullException | SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "index.jsp";
    }

}
