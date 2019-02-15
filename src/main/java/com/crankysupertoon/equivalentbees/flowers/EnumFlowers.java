/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.flowers;

import forestry.apiculture.flowers.FlowerProvider;
import forestry.core.genetics.alleles.IAlleleValue;

import java.util.Locale;

public enum EnumFlowers implements IAlleleValue<FlowerProvider> {

	DARKMATTER(FlowerRegister.FlowerDarkMatter, true),
	REDMATTER(FlowerRegister.FlowerRedMatter, false);

	public static final EnumFlowers[] VALUES = values();

	private final FlowerProvider value;
	private final boolean dominant;

	EnumFlowers(String flowerType) {
		this(flowerType, false);
	}

	EnumFlowers(String flowerType, boolean dominant) {
		String lowercase = toString().toLowerCase(Locale.ENGLISH);
		this.value = new FlowerProvider(flowerType, "for.flowers." + lowercase);
		this.dominant = dominant;
	}

	@Override
	public FlowerProvider getValue() {
		return value;
	}

	@Override
	public boolean isDominant() {
		return dominant;
	}
}
