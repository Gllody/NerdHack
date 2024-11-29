/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules;

import meteordevelopment.meteorclient.addons.AddonManager;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import net.minecraft.item.Items;

public class Categories {
    public static final Category Combat = new Category("Combat", Items.BOW.getDefaultStack());
    public static final Category Player = new Category("Player", Items.ELYTRA.getDefaultStack());
    public static final Category Movement = new Category("Movement", Items.FIREWORK_ROCKET.getDefaultStack());
    public static final Category Render = new Category("Render", Items.ENDER_EYE.getDefaultStack());
    public static final Category World = new Category("World", Items.WRITABLE_BOOK.getDefaultStack());
    public static final Category Misc = new Category("Misc", Items.REDSTONE.getDefaultStack());
    public static final Category Exploits = new Category("Exploits", Items.BARRIER.getDefaultStack());

    public static boolean REGISTERING;

    public static void init() {
        REGISTERING = true;

        // Meteor
        Modules.registerCategory(Combat);
        Modules.registerCategory(Player);
        Modules.registerCategory(Movement);
        Modules.registerCategory(Render);
        Modules.registerCategory(World);
        Modules.registerCategory(Misc);
        Modules.registerCategory(Exploits);

        // Addons
        AddonManager.ADDONS.forEach(MeteorAddon::onRegisterCategories);

        REGISTERING = false;
    }
}
