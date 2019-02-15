/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.bees.mutation;

import com.crankysupertoon.equivalentbees.init.ModItems;
import com.crankysupertoon.equivalentbees.items.EnumDropType;
import com.crankysupertoon.equivalentbees.misc.Config;
import moze_intel.projecte.api.ProjectEAPI;

public class EMCProxy  {

	public static void addEMC() {
		/*Add Custom EMC Values to Items/Objects here "emcProxy...(ItemStack, EMCValue)" 
		All EMC Values should be referenced in ConfigHandler*/
		ProjectEAPI.getEMCProxy().registerCustomEMC(ModItems.HoneyDrop.getDrop(EnumDropType.CHARGED, 1), Config.dropChargedValue);
		ProjectEAPI.getEMCProxy().registerCustomEMC(ModItems.HoneyDrop.getDrop(EnumDropType.OMEGA, 1), Config.dropOmegaValue);
	}
}