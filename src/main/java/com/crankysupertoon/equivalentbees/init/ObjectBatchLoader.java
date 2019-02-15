/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.init;

import com.crankysupertoon.equivalentbees.bees.BeeManagerEquivalentBees;
import com.crankysupertoon.equivalentbees.bees.BeeSpecies;
import com.crankysupertoon.equivalentbees.bees.mutation.BeeMutationFactoryEMC;
import com.crankysupertoon.equivalentbees.flowers.FlowerRegister;
import com.crankysupertoon.equivalentbees.recipes.CentrifugeRecipes;
import forestry.api.apiculture.BeeManager;
import forestry.apiculture.genetics.BeeMutationFactory;

/**
 * Initiates the loading in proxy client of all registered RetroBee Items, Blocks, Tiles, Fluids, Recipes, etc.
 */

public class ObjectBatchLoader {

	public static ModItems items = new ModItems();

	public static void preInit() {
		ModItems.init();
		ModBlocks.init();
	}
	
	public static void init() {
		//EquivalentBees Custom Bee Mutation Factory
		BeeManagerEquivalentBees.beeMutationFactoryEMC = new BeeMutationFactoryEMC();
		BeeManager.beeMutationFactory = new BeeMutationFactory();
		FlowerRegister.initFlowers();
		BeeSpecies.initBees();
		CentrifugeRecipes.registerCentrifugeRecipes();
		CompatModule.initCompatability();
	}
	
	public static void postInit() {
		
	}
	
	public static void initModels() {
		ModItems.initModels();
	}
}
