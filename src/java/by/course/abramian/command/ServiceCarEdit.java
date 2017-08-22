/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.CarDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.logical.PointerNullException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.ICarDAO;
import by.course.abramian.dal.entitydto.Car;
import by.course.abramian.dal.entitydto.Manufacturer;
import by.course.abramian.dal.entitydto.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceCarEdit implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	try {
	    ICarDAO iCarDAO = new CarDAO();
	    switch (request.getParameter("action")) {
		case "Edit": {
		    Car tempCar = new Car(
			    new Manufacturer(
				    null,
				    Integer.parseInt(request.getParameter("carIdManufacturer"))),
			    new Model(
				    null,
				    null,
				    null,
				    0,
				    Integer.parseInt(request.getParameter("carIdModel"))),
			    true,
			    Integer.parseInt(request.getParameter("idCar")));

		    iCarDAO.updateById(
			    tempCar,
			    Integer.parseInt(request.getParameter("selectedIdCar")));

		    break;
		}
		case "Delete": {
		    iCarDAO.delete(Integer.parseInt(request.getParameter("selectedIdCar")));
		    break;
		}
	    }
	} catch (IndexWrongException | PointerNullException | SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "index.jsp";
    }

}
