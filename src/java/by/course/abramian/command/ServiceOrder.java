/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.OrderDAO;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.entitydto.Entity;
import by.course.abramian.dal.entitydto.Order;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceOrder implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	try {
	    BasicActionDAO order = new OrderDAO();
	    List<Entity> tempOrders = order.getAll();
	    List<Order> listOrders = new ArrayList<>();
	    for (Entity tempOrder : tempOrders) {
		listOrders.add((Order) tempOrder);
	    }

	    request.setAttribute("listOrders", listOrders);

	} catch (SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "web/pagesForAdmin/orders.jsp";
    }

}
