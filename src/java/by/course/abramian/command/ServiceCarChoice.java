/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.CarDAO;
import by.course.abramian.dal.dao.ClientDAO;
import by.course.abramian.dal.dao.OrderDAO;
import by.course.abramian.dal.dao.exception.logical.IndexWrongException;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.entitydto.Car;
import by.course.abramian.dal.entitydto.Client;
import by.course.abramian.dal.entitydto.Order;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceCarChoice implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	StringBuilder builder = new StringBuilder("index.jsp");

	boolean tempCheckSignIn = (boolean) session.getAttribute("checkSignIn");
	if (tempCheckSignIn) {
	    Calendar calendar = new GregorianCalendar();
//	    System.out.println(request.getParameter("dateOfBegining"));
	    String dateOfBegining = request.getParameter("dateOfBegining");
	    String[] test = dateOfBegining.split("\\D");
	    String[] strings = {"YEAR", "MONTH", "DAY", "HOURS", "MINUTES"};
	    Map<String, Integer> dateMap = new HashMap<>();
	    for (int i = 0; i < test.length; i++) {
		dateMap.put(strings[i], Integer.parseInt(test[i]));
//	    System.out.println(string);
	    }
	    System.out.println(dateMap);
	    calendar.set(dateMap.get("YEAR"), dateMap.get("MONTH"), dateMap.get("DAY"), dateMap.get("HOURS"), dateMap.get("MINUTES"));
	    System.out.println(calendar.getTime());
	    System.out.println(calendar.getTimeInMillis());
	    Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
	    System.out.println(timestamp);

	    int tempIDUser = (int) session.getAttribute("idUser");
	    ClientDAO clientDAO = new ClientDAO();
	    try {
		int tempIDClient = clientDAO.getIDClientByUser(tempIDUser);
		Client tempClient = (Client) clientDAO.getByIndex(tempIDClient);
		int selectedIdCar = Integer.parseInt(request.getParameter("selectedIdCar"));
		CarDAO carDAO = new CarDAO();
		Car tempCar = (Car) carDAO.getByIndex(selectedIdCar);
	    } catch (IndexWrongException | SQLDBAPIException ex) {
		LOGGER.error(ex);
		request.setAttribute("errorMessage", ex);
		builder = new StringBuilder("web/500.jsp");
	    }
	    OrderDAO orderDAO = new OrderDAO();
//	    orderDAO.insertDefault(new Order(dateOfBegining, dateOfEnding, tempCar, tempClient));

	} else {
	    builder = new StringBuilder("/signInOrRegister.jsp");
	}

	return builder.toString();
    }

}
