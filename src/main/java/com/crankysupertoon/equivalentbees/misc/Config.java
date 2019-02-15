/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.misc;

import com.crankysupertoon.equivalentbees.EquivalentBees;
import com.crankysupertoon.equivalentbees.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
	
	private static final String CATEGORY_EMC = "emc";

	public static boolean canProduceDarkMatter = true;
	public static boolean canProduceRedMatter = true;
	public static boolean isTransmutable = true;

	//EMC Items
	public static int dropChargedValue = 2048;
	public static int dropOmegaValue = 8192;

	//EMC Bee Species
	public static double darkenedBeeValue = 139264;
	public static double reddenedBeeValue = 466944;
	public static double omegaBeeValue = 933888;

	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initConfig(cfg);
		} catch (Exception e) {
			EquivalentBees.logger.log(Level.ERROR, "Problem loading config file!", e);
		} finally {
			if(cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_EMC, "ProjectE EMC configuration");
		dropChargedValue = cfg.get(CATEGORY_EMC, "chargedDropEMCValue (Default: 2048)", dropChargedValue, "The EMC value for the Charged HoneyDrop").getInt();
		dropOmegaValue = cfg.get(CATEGORY_EMC, "omegaDropEMCValue (Default: 8192)", dropOmegaValue, "The EMC value for the Omega HoneyDrop").getInt();
	}
}
