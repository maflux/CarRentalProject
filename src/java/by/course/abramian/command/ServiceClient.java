/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.dal.dao.ClientDAO;
import by.course.abramian.dal.dao.exception.technical.SQLConnectionException;
import by.course.abramian.dal.dao.exception.technical.SQLDBAPIException;
import by.course.abramian.dal.dao.interfaces.BasicActionDAO;
import by.course.abramian.dal.entitydto.Entity;
import by.course.abramian.dal.entitydto.Client;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.course.abramian.log4j.Log4j.*;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceClient implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	try {
	    BasicActionDAO client = new ClientDAO();
	    List<Entity> tempClients = client.getAll();
	    List<Client> listClients = new ArrayList<>();
	    for (Entity tempClient : tempClients) {
		listClients.add((Client) tempClient);
	    }

	    request.setAttribute("listClients", listClients);

	} catch (SQLDBAPIException ex) {
	    LOGGER.error(ex);
	    request.setAttribute("errorMessage", ex);
	    return "web/500.jsp";
	}

	return "web/pagesForAdmin/clients.jsp";
    }

}
