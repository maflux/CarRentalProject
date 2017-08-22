/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.course.abramian.log4j;

import static by.course.abramian.dal.log4j.Log4j.LOGGER;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class Log4j {

    public static Logger LOGGER = Logger.getRootLogger();

    static {
	LOGGER.setLevel(Level.ALL);
    }

}
