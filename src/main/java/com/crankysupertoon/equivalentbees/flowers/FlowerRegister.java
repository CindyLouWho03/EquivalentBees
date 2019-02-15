/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.flowers;

import com.crankysupertoon.equivalentbees.EquivalentBees;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.FlowerManager;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleFlowers;
import forestry.apiculture.flowers.FlowerRegistry;
import moze_intel.projecte.api.state.PEStateProps;
import moze_intel.projecte.api.state.enums.EnumMatterType;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Loader;

public class FlowerRegister {

	public static final String FlowerType = "flowers";

	public static final String FlowerDarkMatter = "DarkMatter";
	public static final String FlowerRedMatter = "RedMatter";
	public static final String FlowerCoal = "Coal";
	public static final String FlowerDiamond = "Diamond";
	public static final String FlowerRedstone = "Redstone";
	public static final String FlowerNetherQuartz = "Nether Quartz";
	public static final String FlowerIron = "Iron";
	public static final String FlowerGold = "Gold";
	public static final String FlowerCopper = "Copper";
	public static final String FlowerSilver = "Silver";
	public static final String FlowerLead = "Lead";
	public static final String FlowerTin = "Tin";
	public static final String FlowerAluminium = "Aluminium";
	public static final String FlowerGalena = "Galena";
	public static final String FlowerRuby = "Ruby";
	public static final String FlowerSapphire = "Sapphire";
	public static final String FlowerBauxite = "Bauxite";
	public static final String FlowerCinnabar = "Cinnabar";
	public static final String FlowerSphalerite = "Sphalerite";
	public static final String FlowerTungsten = "Tungsten";
	public static final String FlowerPeridot = "Peridot";
	public static final String FlowerSodalite = "Sodalite";
	public static final String FlowerIridium = "Iridium";
	public static final String FlowerPyrite = "Pyrite";
	public static final String FlowerSheldonite = "Sheldonite";

	public static IAlleleFlowers DARKMATTER;
	public static IAlleleFlowers REDMATTER;
	public static IAlleleFlowers COAL_ORE;
	public static IAlleleFlowers DIAMOND_ORE;
	public static IAlleleFlowers REDSTONE_ORE;
	public static IAlleleFlowers NETHER_QUARTZ_ORE;
	public static IAlleleFlowers IRON_ORE;
	public static IAlleleFlowers GOLD_ORE;
	public static IAlleleFlowers COPPER_ORE;
	public static IAlleleFlowers SILVER_ORE;
	public static IAlleleFlowers LEAD_ORE;
	public static IAlleleFlowers TIN_ORE;
	public static IAlleleFlowers ALUMINIUM_ORE;
	public static IAlleleFlowers GALENA_ORE;
	public static IAlleleFlowers RUBY_ORE;
	public static IAlleleFlowers SAPPHIRE_ORE;
	public static IAlleleFlowers BAUXITE_ORE;
	public static IAlleleFlowers CINNABAR_ORE;
	public static IAlleleFlowers SPHALERITE_ORE;
	public static IAlleleFlowers TUNGSTEN_ORE;
	public static IAlleleFlowers PERIDOT_ORE;
	public static IAlleleFlowers SODALITE_ORE;
	public static IAlleleFlowers IRIDIUM_ORE;
	public static IAlleleFlowers PYRITE_ORE;
	public static IAlleleFlowers SHELDONITE_ORE;

	public static void initFlowers() {
		FlowerRegistry flowerRegistry = (FlowerRegistry) FlowerManager.flowerRegistry;

		registerProjectEFlowers(flowerRegistry);
		registerFlowerAlleles();
	}

	private static void registerFlowerAlleles() {
		DARKMATTER = AlleleManager.alleleFactory.createFlowers(EquivalentBees.MOD_ID, FlowerType, FlowerDarkMatter, EnumFlowers.DARKMATTER.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		REDMATTER = AlleleManager.alleleFactory.createFlowers(EquivalentBees.MOD_ID, FlowerType, FlowerRedMatter, EnumFlowers.REDMATTER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
	}

	private static void registerProjectEFlowers(FlowerRegistry flowerRegistry) {
		if (Loader.isModLoaded("ProjectE")) {
			flowerRegistry.registerAcceptableFlower(ObjHandler.matterBlock.getDefaultState().withProperty(PEStateProps.TIER_PROP, EnumMatterType.DARK_MATTER), FlowerDarkMatter);
			flowerRegistry.registerAcceptableFlower(ObjHandler.matterBlock.getDefaultState().withProperty(PEStateProps.TIER_PROP, EnumMatterType.RED_MATTER), FlowerRedMatter);
		}
	}
}

