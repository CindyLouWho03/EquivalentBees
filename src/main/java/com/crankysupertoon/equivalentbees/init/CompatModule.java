/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.init;

import com.crankysupertoon.equivalentbees.bees.BeeSpecies;
import com.crankysupertoon.equivalentbees.bees.mutation.EMCProxy;
import com.crankysupertoon.equivalentbees.misc.Log;
import com.crankysupertoon.equivalentbees.recipes.EmcRecipes;
import net.minecraftforge.fml.common.Loader;

public class CompatModule {

    public static void initCompatability() {
        CompatProjectE();
    }

    private static void CompatProjectE() {
        if(Loader.isModLoaded("projecte")) {
            Log.logInfo("ProjectE is loaded");
            EmcRecipes.registerEMCRecipes();
            EMCProxy.addEMC();
        }
        if(!Loader.isModLoaded("projecte")) {
            Log.error("ProjectE is not loaded");
            BeeSpecies.DARKENED.setInactive();
            BeeSpecies.REDDENED.setInactive();
            BeeSpecies.OMEGA.setInactive();
        }
    }
}
