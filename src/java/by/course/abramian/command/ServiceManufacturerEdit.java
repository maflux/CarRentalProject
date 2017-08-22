/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.ManufacturerDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.logical.PointerNullException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.IManufacturer;
import by.course.abramian.dal.entitydto.Manufacturer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceManufacturerEdit implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	try {
	    IManufacturer iManu = new ManufacturerDAO();

	    switch (request.getParameter("action")) {
		case "Edit": {
		    Manufacturer tempManu = new Manufacturer(
			    request.getParameter("manufacturer"),
			    Integer.parseInt(request.getParameter("idManufacturer")));

		    iManu.updateById(
			    tempManu,
			    Integer.parseInt(request.getParameter("selectedManufacturerId")));

		    break;
		}
		case "Delete": {
		    iManu.delete(Integer.parseInt(request.getParameter("selectedManufacturerId")));
		    break;
		}
	    }
	} catch (IndexWrongException | SQLDBAPIException | PointerNullException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "web/pagesForAdmin/manufacturers.jsp";
    }

}
