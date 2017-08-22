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
public class ServiceModelEdit implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	try {
	    IModelDAO iModel = new ModelDAO();

	    switch (request.getParameter("action")) {
		case "Edit": {
		    Model tempModel = new Model(
			    request.getParameter("color"),
			    request.getParameter("transmission"),
			    request.getParameter("bodyType"),
			    Integer.parseInt(request.getParameter("power")),
			    Integer.parseInt(request.getParameter("idModel")));
		    iModel.updateById(
			    tempModel,
			    Integer.parseInt(request.getParameter("selectedModelId")));
		    break;
		}
		case "Delete": {
		    iModel.delete(Integer.parseInt(request.getParameter("selectedModelId")));
		    break;
		}
	    }

	} catch (IndexWrongException | SQLDBAPIException | PointerNullException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "web/pagesForAdmin/models.jsp";
    }

}
