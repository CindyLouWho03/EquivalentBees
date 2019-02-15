/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.recipes;

import com.google.common.collect.ImmutableMap;
import com.crankysupertoon.equivalentbees.init.ModItems;
import com.crankysupertoon.equivalentbees.items.EnumCombType;
import com.crankysupertoon.equivalentbees.items.EnumDropType;
import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.ModuleApiculture;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class CentrifugeRecipes {

	public static void registerCentrifugeRecipes() {
		//Item alchemicalCoal = new ItemStack(Item.getItemFromBlock(ObjHandler.fuelBlock.getDefaultState().withProperty(PEStateProps.FUEL_PROP, EnumFuelType.ALCHEMICAL_COAL).getBlock()), 1).getItem();//, 0.15f

        //CENTRIFUGE
		if(Loader.isModLoaded("projecte")) {
			//Darkened comb
			RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.DARKENED, 1), ImmutableMap.of(
					ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
					ModItems.HoneyDrop.getDrop(EnumDropType.CHARGED, 1), 0.15f
			));

			//Reddened comb
			RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.REDDENED, 1), ImmutableMap.of(
					ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
					ModItems.HoneyDrop.getDrop(EnumDropType.CHARGED, 2), 0.15f
			));

			//Omega comb
			RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.OMEGA, 1), ImmutableMap.of(
					ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
					ModItems.HoneyDrop.getDrop(EnumDropType.OMEGA, 1), 0.15f
			));
		}
	}
}