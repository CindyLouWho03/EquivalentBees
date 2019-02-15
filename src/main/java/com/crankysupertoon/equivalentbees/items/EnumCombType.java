/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.items;

import net.minecraft.util.IStringSerializable;

import java.awt.*;
import java.util.Locale;

public enum EnumCombType implements IStringSerializable {
	/**
	 * @param HoneyComb Name, @param Primary Color, @param Secondary Color, @param (Optinal) IsSecret(true or false)
	 */
	/*
	NEXT RELEASE: 1.2.0
	ALLOYS:
	REFINED_IRON(new Color(TBA), new Color(0xE8D56A)),
	BRONZE(new Color(TBA), new Color(0xE8D56A)),
	MIXED_METAL(new Color(TBA), new Color(0xE8D56A)),
	ADVANCED_ALLOY(new Color(TBA), new Color(0xE8D56A)),
	IRIDIUM_ALLOY(new Color(TBA), new Color(0xE8D56A)),
	*/

	//Energy Matter Convertis
	DARKENED(new Color(0x33EBCB), new Color(0xE8D56A)),
	REDDENED(new Color(0x6200E7), new Color(0xE8D56A)),
	OMEGA(new Color(0x6DCFF6), new Color(0xE8D56A));

	public static final EnumCombType[] VALUES = values();

	public final String name;
	public final int primaryColor;
	public final int secondaryColor;
	private final boolean secret;

	EnumCombType(Color primary, Color secondary) {
		this(primary, secondary, false);
	}

	EnumCombType(Color primary, Color secondary, boolean secret) {
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.primaryColor = primary.getRGB();
		this.secondaryColor = secondary.getRGB();
		this.secret = secret;
	}

	public int getPrimaryColor() {
		return primaryColor;
	}

	public int getSecondaryColor() {
		return secondaryColor;
	}

	public boolean isSecret() {
		return secret;
	}

	@Override
	public String getName() {
		return name;
	}

	public static EnumCombType get(int meta) {
		if(meta >= VALUES.length) {
			meta = 0;
		}
		return VALUES[meta];
	}
}
