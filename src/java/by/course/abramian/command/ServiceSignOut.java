/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import by.course.abramian.listener.ContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceSignOut implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	session.setAttribute("header", null);
	session.setAttribute("checkSignIn", false);
	ContextListener.context.setAttribute("roleAdmin", false);
	return "index.jsp";
    }

}
