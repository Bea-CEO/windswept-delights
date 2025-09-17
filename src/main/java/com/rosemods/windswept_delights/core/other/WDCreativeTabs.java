package com.rosemods.windswept_delights.core.other;

import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import static com.rosemods.windswept.core.registry.WindsweptItems.*;
import static com.rosemods.windswept_delights.core.registry.WDBlocks.*;
import static com.rosemods.windswept_delights.core.registry.WDItems.*;

public final class WDCreativeTabs {
    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(WindsweptDelights.MOD_ID)
                .tab(CreativeModeTabs.FOOD_AND_DRINKS)
                .addItemsAfter(Ingredient.of(WILD_BERRIES.get()), WILD_BERRY_POPSICLE)
                .addItemsAfter(Ingredient.of(CHESTNUT_SOUP.get()), MIMOSA_SOUP, CHESTNUT_RISOTTO)
                .addItemsAfter(Ingredient.of(Items.RABBIT_STEW), LAVENDER_SALAD)
                .addItemsAfter(Ingredient.of(LAVENDER_TEA.get()), WILD_BERRY_JUICE)
                .addItemsAfter(Ingredient.of(COOKED_GOAT.get()), GOAT_SHANKS, COOKED_GOAT_SHANKS)
                .addItemsAfter(Ingredient.of(MINTY_SNOW_CONE.get()), SNOW_CONE, MELON_SNOW_CONE, PUMPKIN_SNOW_CONE, CHOCOLATE_SNOW_CONE, CHORUS_SNOW_CONE)
                .addItemsAfter(Ingredient.of(WindsweptBlocks.CHRISTMAS_PUDDING.get()), CHRISTMAS_PUDDING_SLICE)

                .tab(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .addItemsAfter(Ingredient.of(Items.BARREL), HOLLY_CABINET, CHESTNUT_CABINET, PINE_CABINET);
    }

}