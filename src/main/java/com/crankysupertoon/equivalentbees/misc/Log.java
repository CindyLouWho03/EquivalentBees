/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.misc;

import com.crankysupertoon.equivalentbees.EquivalentBees;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;

public class Log {
	public static void log(Level logLevel, String message) {
		EquivalentBees.logger.log(logLevel, message);
	}

	public static void log(Level logLevel, String message, Object e) {
		EquivalentBees.logger.log(logLevel, message, e);
	}
	
	public static void logInfo(String message){
		EquivalentBees.logger.info(message);
	}
	
	public static void logWarn(String message) {
		EquivalentBees.logger.warn(message);
	}
	
	public static void logFatal(String message) {
		EquivalentBees.logger.fatal(message);
	}
	
	public static void logDebug(String message) {
		EquivalentBees.logger.debug(message);
	}

	public static void error(String string) {
		EquivalentBees.logger.error(string);
	}

	public static void error(String string, ItemStack stack) {
		EquivalentBees.logger.error(string, stack);
	}
}
