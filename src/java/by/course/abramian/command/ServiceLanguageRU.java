/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import static by.course.abramian.l10n.LocalConst.*;
import by.course.abramian.listener.ContextListener;
import static by.course.abramian.listener.ContextListener.context;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceLanguageRU implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	ContextListener.locale = new Locale("ru", "RU");
	setBundle();
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

	return "index.jsp";
    }

}
