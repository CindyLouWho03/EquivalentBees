/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.recipes;

import com.crankysupertoon.equivalentbees.bees.BeeSpecies;
import com.crankysupertoon.equivalentbees.bees.mutation.EmcRecipe;
import com.crankysupertoon.equivalentbees.misc.Config;
import forestry.apiculture.genetics.BeeDefinition;

public class EmcRecipes {
	
	public static EmcRecipe emcMutation;
	
	public static void registerEMCRecipes() {
		emcMutation = new EmcRecipe();
		
		emcMutation.addRecipe(BeeDefinition.MODEST, BeeDefinition.WINTRY, Config.darkenedBeeValue);
		
		emcMutation.addRecipe(BeeSpecies.DARKENED, BeeDefinition.MODEST, Config.reddenedBeeValue);

		emcMutation.addRecipe(BeeSpecies.REDDENED, BeeSpecies.DARKENED, Config.omegaBeeValue);
	}
}
