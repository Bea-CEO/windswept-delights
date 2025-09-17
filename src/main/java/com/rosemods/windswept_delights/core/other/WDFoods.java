package com.rosemods.windswept_delights.core.other;

import com.mojang.datafixers.util.Pair;
import com.rosemods.windswept.core.other.WindsweptFoods;
import com.rosemods.windswept.core.registry.WindsweptEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public final class WDFoods {
    public static final FoodProperties GOAT_SHANKS = new FoodProperties.Builder().nutrition(1).saturationMod(.1f).meat().build();
    public static final FoodProperties COOKED_GOAT_SHANKS = new FoodProperties.Builder().nutrition(3).saturationMod(.3f).meat().build();
    public static final FoodProperties WILD_BERRY_POPSICLE = new FoodProperties.Builder().nutrition(4).saturationMod(.7f).alwaysEat().effect(() -> new MobEffectInstance(WindsweptEffects.FROST_RESISTANCE.get(), 300, 0), 1f).build();
    public static final FoodProperties LAVENDER_SALAD = new FoodProperties.Builder().nutrition(6).saturationMod(.6f).build();
    public static final FoodProperties MIMOSA_SOUP = new FoodProperties.Builder().nutrition(7).saturationMod(.5f).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0), 1f).build();
    public static final FoodProperties CHESTNUT_RISOTTO = new FoodProperties.Builder().nutrition(13).saturationMod(.75f).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1f).build();
    public static final FoodProperties SNOW_CONE = new FoodProperties.Builder().nutrition(15).saturationMod(.6f).build();
    public static final FoodProperties MELON_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEat().saturationMod(.6f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1f).build();
    public static final FoodProperties CHORUS_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEat().saturationMod(.6f).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 300, 0), 1f).build();
    public static final FoodProperties PUMPKIN_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEat().saturationMod(.6f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0), 1f).build();
    public static final FoodProperties CHOCOLATE_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEat().saturationMod(.6f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0), 1f).build();
    public static final FoodProperties WILD_BERRY_JUICE = new FoodProperties.Builder().alwaysEat().effect(() -> new MobEffectInstance(WindsweptEffects.FROST_RESISTANCE.get(), 1200, 0), 1f).build();

    public static void modifyFoodValues() {
        WindsweptFoods.CHESTNUT_SOUP.effects.add(Pair.of(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0), 1f));
        WindsweptFoods.GOAT_STEW.effects.add(Pair.of(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0), 1f));
    }

}
