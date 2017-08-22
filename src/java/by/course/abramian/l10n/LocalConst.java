/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.l10n;

import by.course.abramian.listener.ContextListener;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.catalina.Session;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class LocalConst {

    public static ResourceBundle bundle;

    static {
//	Locale locale_ru_RU = new Locale("ru", "RU");
//	Locale locale_eng_UK = new Locale("eng", "UK");

	bundle = ResourceBundle.getBundle("by.course.abramian.l10n.local", ContextListener.locale);
    }

    public static String LANGUAGERU = bundle.getString("menuLanguage.languageRU");
    public static String LANGUAGEENG = bundle.getString("menuLanguage.languageENG");
    public static String CARRENTAL = bundle.getString("menu.carRental");
    public static String STARTPAGE = bundle.getString("menu.startPage");
    public static String PARKCARS = bundle.getString("menu.parkCars");
    public static String ALLMODELS = bundle.getString("menu.allModels");
    public static String ALLMANUFACTURERS = bundle.getString("menu.allManufacturers");
    public static String ALLORDERS = bundle.getString("menu.allOrders");
    public static String ALLCLIENTS = bundle.getString("menu.allClients");
    public static String ALLUSERS = bundle.getString("menu.allUsers");
    public static String ALLROLES = bundle.getString("menu.allRoles");
    public static String CARS = bundle.getString("menu.CARS");
    public static String MODELS = bundle.getString("menu.MODELS");
    public static String MANUFACTURERS = bundle.getString("menu.MANUFACTURERS");
    public static String ORDERS = bundle.getString("menu.ORDERS");
    public static String CLIENTS = bundle.getString("menu.CLIENTS");
    public static String USERS = bundle.getString("menu.USERS");
    public static String ROLES = bundle.getString("menu.ROLES");
    public static String SIGNOUT = bundle.getString("menu.signOut");
    public static String SIGNIN = bundle.getString("menu.signIn");
    public static String LOGIN = bundle.getString("menu.login");
    public static String PASSWORD = bundle.getString("menu.password");
    public static String ADMINISTRATOR = bundle.getString("menu.administrator");
    public static String USER = bundle.getString("menu.user");
    public static String MANAGER = bundle.getString("menu.manager");
    public static String EDIT = bundle.getString("menu.edit");
    public static String DELETE = bundle.getString("menu.delete");
    public static String ADDITION = bundle.getString("menu.addition");
    public static String RESET = bundle.getString("menu.reset");
    public static String CREATEACCOUNT = bundle.getString("menu.createAccount");
    public static String TOTALUSERS = bundle.getString("menu.totalUsers");
    public static String ROLE = bundle.getString("menu.role");
    public static String EMAIL = bundle.getString("menu.email");
    public static String NUMBERPHONE = bundle.getString("menu.numberPhone");
    public static String FATHERNAME = bundle.getString("menu.fatherName");
    public static String LASTNAME = bundle.getString("menu.lastName");
    public static String FIRSTNAME = bundle.getString("menu.firstName");
    public static String PASSPORT = bundle.getString("menu.passport");
    public static String FREE = bundle.getString("menu.free");
    public static String POWER = bundle.getString("menu.power");
    public static String BODYTYPE = bundle.getString("menu.bodyType");
    public static String TRANSMISSION = bundle.getString("menu.transmission");
    public static String COLOR = bundle.getString("menu.color");
    public static String MANUFACTURER = bundle.getString("menu.manufacturer");
    public static String DATEOFBEGINING = bundle.getString("menu.dateOfBegining");
    public static String DATEOFENDING = bundle.getString("menu.dateOfEnding");
    public static String CHOICE = bundle.getString("menu.choice");
    public static String CHOOSE = bundle.getString("menu.choose");
    public static String CANNOTBEEMPTY = bundle.getString("menu.canNotBeEmpty");
    public static String YOURREGISTRATION = bundle.getString("menu.yourRegistration");
    public static String MENUDATE = bundle.getString("menuDate");
    public static String MENUMODEL = bundle.getString("menu.model");

    public static String FOOTERPRIVACYPOLICY = bundle.getString("footerPrivacyPolicy");
    public static String FOOTERTERMSOFUSE = bundle.getString("footerTermsOfUse");
    public static String FOOTERABOUTUS = bundle.getString("footerAboutUs");

    public static void setBundle() {

	bundle = ResourceBundle.getBundle("by.course.abramian.l10n.local", ContextListener.locale);

	LANGUAGEENG = bundle.getString("menuLanguage.languageENG");
	LANGUAGERU = bundle.getString("menuLanguage.languageRU");
	CARRENTAL = bundle.getString("menu.carRental");
	STARTPAGE = bundle.getString("menu.startPage");
	PARKCARS = bundle.getString("menu.parkCars");
	ALLMODELS = bundle.getString("menu.allModels");
	ALLMANUFACTURERS = bundle.getString("menu.allManufacturers");
	ALLORDERS = bundle.getString("menu.allOrders");
	ALLCLIENTS = bundle.getString("menu.allClients");
	ALLUSERS = bundle.getString("menu.allUsers");
	ALLROLES = bundle.getString("menu.allRoles");
	CARS = bundle.getString("menu.CARS");
	MODELS = bundle.getString("menu.MODELS");
	MANUFACTURERS = bundle.getString("menu.MANUFACTURERS");
	ORDERS = bundle.getString("menu.ORDERS");
	CLIENTS = bundle.getString("menu.CLIENTS");
	USERS = bundle.getString("menu.USERS");
	ROLES = bundle.getString("menu.ROLES");
	SIGNOUT = bundle.getString("menu.signOut");
	SIGNIN = bundle.getString("menu.signIn");
	LOGIN = bundle.getString("menu.login");
	PASSWORD = bundle.getString("menu.password");
	ADMINISTRATOR = bundle.getString("menu.administrator");
	USER = bundle.getString("menu.user");
	MANAGER = bundle.getString("menu.manager");
	EDIT = bundle.getString("menu.edit");
	DELETE = bundle.getString("menu.delete");
	ADDITION = bundle.getString("menu.addition");
	RESET = bundle.getString("menu.reset");
	CREATEACCOUNT = bundle.getString("menu.createAccount");
	TOTALUSERS = bundle.getString("menu.totalUsers");
	ROLE = bundle.getString("menu.role");
	EMAIL = bundle.getString("menu.email");
	NUMBERPHONE = bundle.getString("menu.numberPhone");
	FATHERNAME = bundle.getString("menu.fatherName");
	LASTNAME = bundle.getString("menu.lastName");
	FIRSTNAME = bundle.getString("menu.firstName");
	PASSPORT = bundle.getString("menu.passport");
	FREE = bundle.getString("menu.free");
	POWER = bundle.getString("menu.power");
	BODYTYPE = bundle.getString("menu.bodyType");
	TRANSMISSION = bundle.getString("menu.transmission");
	COLOR = bundle.getString("menu.color");
	MANUFACTURER = bundle.getString("menu.manufacturer");
	DATEOFBEGINING = bundle.getString("menu.dateOfBegining");
	DATEOFENDING = bundle.getString("menu.dateOfEnding");
	CHOICE = bundle.getString("menu.choice");
	CHOOSE = bundle.getString("menu.choose");
	CANNOTBEEMPTY = bundle.getString("menu.canNotBeEmpty");
	YOURREGISTRATION = bundle.getString("menu.yourRegistration");
	MENUDATE = bundle.getString("menuDate");
	MENUMODEL = bundle.getString("menu.model");
	FOOTERPRIVACYPOLICY = bundle.getString("footerPrivacyPolicy");
	FOOTERTERMSOFUSE = bundle.getString("footerTermsOfUse");
	FOOTERABOUTUS = bundle.getString("footerAboutUs");
    }

}
