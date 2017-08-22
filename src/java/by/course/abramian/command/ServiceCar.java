/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.CarDAO;
import by.course.abramian.dal.dao.ManufacturerDAO;
import by.course.abramian.dal.dao.ModelDAO;
import by.course.abramian.dal.dao.OrderDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.dao.interfaces.ICarDAO;
import by.course.abramian.dal.entitydto.Entity;
import by.course.abramian.dal.entitydto.Car;
import by.course.abramian.dal.entitydto.Manufacturer;
import by.course.abramian.dal.entitydto.Model;
import by.course.abramian.dal.entitydto.Order;
import static by.course.abramian.log4j.Log4j.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceCar implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	LOGGER.trace("In method execute - choiceCar.");
	try {
	    handlerTimeOfEnding();
	    BasicActionDAO actionDAO = new CarDAO();
	    List<Entity> cars = actionDAO.getAll();
	    List<Car> listCars = new ArrayList<>();
	    for (Entity car : cars) {
		listCars.add((Car) car);
	    }

	    actionDAO = new ManufacturerDAO();
	    List<Entity> tempManus = actionDAO.getAll();
	    List<Manufacturer> listManufacturers = new ArrayList<>();
	    for (Entity tempManu : tempManus) {
		listManufacturers.add((Manufacturer) tempManu);
	    }

	    actionDAO = new ModelDAO();
	    List<Entity> tempModels = actionDAO.getAll();
	    List<Model> listModels = new ArrayList<>();
	    for (Entity tempModel : tempModels) {
		listModels.add((Model) tempModel);
	    }

	    request.setAttribute("listCars", listCars);
	    request.setAttribute("listModels", listModels);
	    request.setAttribute("listManufacturers", listManufacturers);

	    return "web/pagesForAdmin/cars.jsp";
	} catch (SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}
    }

    //Проверяет время окончания аренды машины и делает свободную машину если время аренды вышло.
    private void handlerTimeOfEnding() {
	List<Order> listOrders = null;

	try {
	    BasicActionDAO order = new OrderDAO();
	    List<Entity> tempOrders = order.getAll();
	    listOrders = new ArrayList<>();
	    for (Entity tempOrder : tempOrders) {
		listOrders.add((Order) tempOrder);
	    }

	    for (int i = 0; i < listOrders.size(); i++) {
		if (!listOrders.get(i).getCar().isFree()) {
		    if (listOrders.get(i).getDateOfEnding().before(new Timestamp(System.currentTimeMillis()))) {
			ICarDAO iCarDAO = new CarDAO();
			try {
//			    Car tempCar = (Car) iCarDAO.getByIndex(listOrders.get(i).getCar().getId());
//			    System.out.println(tempCar);

			    iCarDAO.updateFieldFreeByIndex(listOrders.get(i).getCar().getId(), true);

//			    tempCar = (Car) iCarDAO.getByIndex(listOrders.get(i).getCar().getId());
//			    System.out.println(tempCar);
			} catch (SQLDBAPIException ex) {
			    LOGGER.error(ex);
			}
		    }
		}
	    }

	} catch (SQLDBAPIException ex) {
	    LOGGER.error(ex);
	}
    }

}
