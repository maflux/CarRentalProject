/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.ClientDAO;
import by.course.abramian.dal.dao.OrderDAO;
import by.course.abramian.dal.dao.UserDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.entitydto.Order;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceOrderOfUser implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	try {

	    HttpSession session = request.getSession();

	    int tempIDUser = (int) session.getAttribute("idUser");
	    ClientDAO clientDAO = new ClientDAO();
	    int tempIDClient = clientDAO.getIDClientByUser(tempIDUser);
	    OrderDAO orderDAO = new OrderDAO();
	    List<Order> listOrders = orderDAO.getOrdersByClient(tempIDClient);

	    request.setAttribute("listOrders", listOrders);

	} catch (SQLDBAPIException | IndexWrongException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "web/pagesForAdmin/orders.jsp";
    }

}
