/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.bees;

import com.crankysupertoon.equivalentbees.EquivalentBees;
import com.crankysupertoon.equivalentbees.flowers.FlowerRegister;
import com.crankysupertoon.equivalentbees.init.ModItems;
import com.crankysupertoon.equivalentbees.items.EnumCombType;
import com.crankysupertoon.equivalentbees.misc.Config;
import forestry.api.apiculture.*;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.AlleleSpeciesRegisterEvent;
import forestry.api.genetics.IAllele;
import forestry.apiculture.ModuleApiculture;
import forestry.apiculture.genetics.Bee;
import forestry.apiculture.genetics.BeeDefinition;
import forestry.apiculture.genetics.BeeVariation;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.genetics.alleles.AlleleEffects;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;
import forestry.core.genetics.alleles.EnumAllele.Lifespan;
import forestry.core.genetics.alleles.EnumAllele.Speed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public enum BeeSpecies implements IBeeDefinition {

	// EMC Branch
	DARKENED(BeeBranches.EMC, "Darkened", false, new Color(0xD6BDE4), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.DARKENED, 1), 0.30F);
			}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.DARKMATTER);
		}
		
		@Override
		protected void registerMutations() {
			registerEMCMutation(BeeDefinition.MODEST, BeeDefinition.WINTRY, 100);
		}
	},

	REDDENED(BeeBranches.EMC, "Reddened", true, new Color(0xF7C0C0), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.REDDENED, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.REDMATTER);
		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(DARKENED, BeeDefinition.MODEST, 100);
		}
	},

	OMEGA(BeeBranches.EMC, "Omega", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.OMEGA, 1), 0.30F)
					.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.REDMATTER);
		}
		
		@Override
		protected void registerMutations() {
			registerEMCMutation(DARKENED, REDDENED, 100).restrictBiomeType(BiomeDictionary.Type.NETHER).restrictBiomeType(BiomeDictionary.Type.HOT);
		}
	};

//TBA: New Transmutable Bees
/*
	DIRT(BeeBranches.EMC, "Dirtimis", true, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	GRASS(BeeBranches.EMC, "Grassitis", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	SAND(BeeBranches.EMC, "Sandimis", true, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	SANDSTONE(BeeBranches.EMC, "Sandstonis", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	ICE(BeeBranches.EMC, "Icitis", true, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	COBBLESTONE(BeeBranches.EMC, "Cobblestonis", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	STONE(BeeBranches.EMC, "Stonis", true, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	GRAVEL(BeeBranches.EMC, "Gravelmis", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	OBSIDIAN(BeeBranches.EMC, "Obsidianitis", true, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	LAVA(BeeBranches.EMC, "Lavamis", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	WATER(BeeBranches.EMC, "Wateris", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	},

	PHILOSOPHER(BeeBranches.EMC, "Philosophicalis", true, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {

		}
	};*/

	public boolean active = true;
	
	public BeeSpecies setInactive() {
		this.active = false;
		AlleleManager.alleleRegistry.blacklistAllele(species.getUID());
		return this;
	}

	public boolean isActive() {
		return active;
	}


	
	private final IBranchDefinition branch;
	private final IAlleleBeeSpecies species;
	
	@Nullable
	private IAllele[] template;
	
	@Nullable
	private IBeeGenome genome;

	BeeSpecies(IBranchDefinition branch, String binomial, boolean dominant, Color primary, Color secondary) {
		String lowercaseName = this.toString().toLowerCase(Locale.ENGLISH);
		String species = "species" + WordUtils.capitalize(lowercaseName);
		
		String modID = EquivalentBees.MOD_ID;
		String UID = modID + ".species." + species;
		String description = "for.description." + species;
		String name = "for.bees.species." + lowercaseName;
		
		this.branch = branch;
	
		IAlleleBeeSpeciesBuilder speciesBuilder = BeeManager.beeFactory.createSpecies(modID, UID, dominant, "TheSledgeHammer", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
		
		if (isSecret()) {
			speciesBuilder.setIsSecret();
		}
		setSpeciesProperties(speciesBuilder);
		this.species = speciesBuilder.build();
	}

	protected abstract void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies);

	protected abstract void setAlleles(IAllele[] template);

	protected abstract void registerMutations();

	protected boolean isSecret() {
		return false;
	}
	
	public static void initBees() {
		for(BeeSpecies bee : values()) {
			bee.init();
		}
		for(BeeSpecies bee : values()) {
			bee.registerMutations();
		}
	}

	public static void preInit() {
		MinecraftForge.EVENT_BUS.post(new AlleleSpeciesRegisterEvent<>(BeeManager.beeRoot, IAlleleBeeSpecies.class));
	}

	private void init() {
		template = branch.getTemplate();
		AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPECIES, species);
		setAlleles(template);

		genome = BeeManager.beeRoot.templateAsGenome(template);
		
		BeeManager.beeRoot.registerTemplate(template);
	}
	
	@Override
	public final IAllele[] getTemplate() {
		return Arrays.copyOf(template, template.length);
	}

	@Override
	public final IBeeGenome getGenome() {
		return genome;
	}

	@Override
	public final IBee getIndividual() {
		return new Bee(genome);
	}

	@Override
	public final ItemStack getMemberStack(EnumBeeType beeType) {
		IBee bee = getIndividual();
		return BeeManager.beeRoot.getMemberStack(bee, beeType);
	}

	public final IBeeDefinition getRainResist() {
		return new BeeVariation.RainResist(this);
	}
	
	public final IBeeMutationBuilder registerMutation(IBeeDefinition parent1, IBeeDefinition parent2, int chance) {
		return registerMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), getTemplate(), chance);
	}

	public static IBeeMutationBuilder registerMutation(IBeeDefinition parent1, IBeeDefinition parent2, IBeeDefinition mutation, int chance) {
		return registerMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), mutation.getTemplate(), chance);
	}
	
	public static IBeeMutationBuilder registerMutation(IAlleleBeeSpecies parent1, IAlleleBeeSpecies parent2, IAllele[] template, int chance) {
		return BeeManager.beeMutationFactory.createMutation(parent1, parent2, template, chance);
	}
	
	//Register EMC Mutation Variant:
	public final IBeeMutationBuilder registerEMCMutation(IBeeDefinition parent1, IBeeDefinition parent2, int chance) {
		return registerEMCMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), getTemplate(), chance);
	}

	public static IBeeMutationBuilder registerEMCMutation(IBeeDefinition parent1, IBeeDefinition parent2, IBeeDefinition mutation, int chance) {
		return registerEMCMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), mutation.getTemplate(), chance);
	}
	
	public static IBeeMutationBuilder registerEMCMutation(IAlleleBeeSpecies parent1, IAlleleBeeSpecies parent2, IAllele[] template, int chance) {
		return BeeManagerEquivalentBees.beeMutationFactoryEMC.createMutation(parent1, parent2, template, chance);
	}

	public static boolean isTransmutable() {
		if(Loader.isModLoaded("projecte")) {
			return Config.isTransmutable;
		}
		return false;
	}
}