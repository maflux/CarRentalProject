/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author User
 */
public class SessionListener implements HttpSessionListener {
    

    @Override
    public void sessionCreated(HttpSessionEvent se) {
	ContextListener.context.setAttribute("countGuest", ContextListener.countGuest++);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
	ContextListener.context.setAttribute("countGuest", ContextListener.countGuest--);
    }
}
