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

public enum EnumDropType implements IStringSerializable {
	/**
	 * @param HoneyDrop Name, @param Primary Color, @param Secondary Color, @param (Optinal) IsSecret(true or false)
	 */
	//EMC Combs
	CHARGED(new Color(0x800505), new Color(0x9C0707)),
	OMEGA(new Color(0x191919), new Color(0x4A8CA7)),
	UUMATTER(new Color(0xFF1493), new Color(0xFF69B4),true);

	public static final EnumDropType[] VALUES = values();

	public final String name;
	public final int primaryColor;
	public final int secondaryColor;
	private final boolean secret;

	EnumDropType(Color primary, Color secondary) {
		this(primary, secondary, false);
	}

	EnumDropType(Color primary, Color secondary, boolean secret) {
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
}
