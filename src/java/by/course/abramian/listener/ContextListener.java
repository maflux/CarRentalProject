/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.listener;

import static by.course.abramian.l10n.LocalConst.*;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author User
 */
public class ContextListener implements ServletContextListener {

    public static int countGuest;
    public static Locale locale;
    public static ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	locale = new Locale("eng", "UK");
	context = sce.getServletContext();
	initializeLocale();
	context.setAttribute("countGuest", ContextListener.countGuest);
    }

    private void initializeLocale() {
	context.setAttribute("roleAdmin", false);
	context.setAttribute("languageRU", LANGUAGERU);
	context.setAttribute("languageENG", LANGUAGEENG);
	context.setAttribute("carRental", CARRENTAL);
	context.setAttribute("startPage", STARTPAGE);
	context.setAttribute("parkCars", PARKCARS);
	context.setAttribute("allModels", ALLMODELS);
	context.setAttribute("allManufacturers", ALLMANUFACTURERS);
	context.setAttribute("allOrders", ALLORDERS);
	context.setAttribute("allClients", ALLCLIENTS);
	context.setAttribute("allUsers", ALLUSERS);
	context.setAttribute("allRoles", ALLROLES);
	context.setAttribute("CARS", CARS);
	context.setAttribute("MODELS", MODELS);
	context.setAttribute("MANUFACTURERS", MANUFACTURERS);
	context.setAttribute("ORDERS", ORDERS);
	context.setAttribute("CLIENTS", CLIENTS);
	context.setAttribute("USERS", USERS);
	context.setAttribute("ROLES", ROLES);
	context.setAttribute("signOut", SIGNOUT);
	context.setAttribute("signIn", SIGNIN);
	context.setAttribute("login", LOGIN);
	context.setAttribute("password", PASSWORD);
	context.setAttribute("administrator", ADMINISTRATOR);
	context.setAttribute("user", USER);
	context.setAttribute("manager", MANAGER);
	context.setAttribute("edit", EDIT);
	context.setAttribute("delete", DELETE);
	context.setAttribute("addition", ADDITION);
	context.setAttribute("reset", RESET);
	context.setAttribute("createAccount", CREATEACCOUNT);
	context.setAttribute("totalUsers", TOTALUSERS);

	context.setAttribute("role", ROLE);

	context.setAttribute("email", EMAIL);
	context.setAttribute("numberPhone", NUMBERPHONE);
	context.setAttribute("fatherName", FATHERNAME);
	context.setAttribute("lastName", LASTNAME);
	context.setAttribute("firstName", FIRSTNAME);
	context.setAttribute("passport", PASSPORT);
	context.setAttribute("free", FREE);
	context.setAttribute("power", POWER);
	context.setAttribute("bodyType", BODYTYPE);
	context.setAttribute("transmission", TRANSMISSION);
	context.setAttribute("color", COLOR);
	context.setAttribute("manufacturer", MANUFACTURER);
	context.setAttribute("dateOfBegining", DATEOFBEGINING);
	context.setAttribute("dateOfEnding", DATEOFENDING);

	context.setAttribute("choice", CHOICE);
	context.setAttribute("choose", CHOOSE);
	context.setAttribute("canNotBeEmpty", CANNOTBEEMPTY);
	context.setAttribute("yourRegistration", YOURREGISTRATION);
	context.setAttribute("menuDate", MENUDATE);
	context.setAttribute("model", MENUMODEL);

	context.setAttribute("footerPrivacyPolicy", FOOTERPRIVACYPOLICY);
	context.setAttribute("footerTermsOfUse", FOOTERTERMSOFUSE);
	context.setAttribute("footerAboutUs", FOOTERABOUTUS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//	locale = null;
    }
}
