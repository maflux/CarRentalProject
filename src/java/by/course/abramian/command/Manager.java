/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.command;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class Manager {

    private static Map<String, Command> map;

    static {
	map = new HashMap<>();

	map.put("cars", new ServiceCar());
	map.put("users", new ServiceUser());
	map.put("roles", new ServiceRole());
	map.put("sign_in", new ServiceSignIn());
	map.put("sign_out", new ServiceSignOut());
	map.put("models", new ServiceModel());
	map.put("manufacturers", new ServiceManufacturer());
	map.put("clients", new ServiceClient());
	map.put("orders", new ServiceOrder());
	map.put("createAccount", new ServiceCreateAccount());
	map.put("ordersByUser", new ServiceOrderOfUser());
	map.put("choiceCar", new ServiceCarChoice());
	map.put("languageRU", new ServiceLanguageRU());
	map.put("languageENG", new ServiceLanguageENG());
	map.put("editRole", new ServiceRoleEdit());
	map.put("addRole", new ServiceRoleAdd());
	map.put("addUser", new ServiceUserAdd());
	map.put("editUser", new ServiceUserEdit());
	map.put("addManufacturer", new ServiceManufacturerAdd());
	map.put("editManufacturer", new ServiceManufacturerEdit());
	map.put("addModel", new ServiceModelAdd());
	map.put("editModel", new ServiceModelEdit());
	map.put("editCar", new ServiceCarEdit());
	map.put("addCar", new ServiceCarAdd());
    }

    public static Command getCommand(String typeCommand) {
	return map.get(typeCommand);
    }
}
