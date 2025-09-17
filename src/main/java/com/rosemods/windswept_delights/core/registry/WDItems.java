package com.rosemods.windswept_delights.core.registry;

import com.rosemods.windswept.common.item.DrinkableBottleItem;
import com.rosemods.windswept.common.item.FoodRemainderItem;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.other.WDFoods;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;

@Mod.EventBusSubscriber(modid = WindsweptDelights.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WDItems {
    public static final ItemSubRegistryHelper HELPER = WindsweptDelights.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> GOAT_SHANKS = HELPER.createItem("goat_shanks", () -> new Item(PropertyUtil.food(WDFoods.GOAT_SHANKS)));
    public static final RegistryObject<Item> COOKED_GOAT_SHANKS = HELPER.createItem("cooked_goat_shanks", () -> new Item(PropertyUtil.food(WDFoods.COOKED_GOAT_SHANKS)));
    public static final RegistryObject<Item> CHRISTMAS_PUDDING_SLICE = HELPER.createItem("christmas_pudding_slice", () -> new Item(new Item.Properties().food(FoodValues.CAKE_SLICE)));
    public static final RegistryObject<Item> CHESTNUT_RISOTTO = HELPER.createItem("chestnut_risotto", () -> new BowlFoodItem(PropertyUtil.food(WDFoods.CHESTNUT_RISOTTO).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> MIMOSA_SOUP = HELPER.createItem("mimosa_soup", () -> new BowlFoodItem(PropertyUtil.food(WDFoods.MIMOSA_SOUP).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> WILD_BERRY_POPSICLE = HELPER.createItem("wild_berry_popsicle", () -> new Item(PropertyUtil.food(WDFoods.WILD_BERRY_POPSICLE)));
    public static final RegistryObject<Item> WILD_BERRY_JUICE = HELPER.createItem("wild_berry_juice", () -> new DrinkableBottleItem(WDFoods.WILD_BERRY_JUICE));
    public static final RegistryObject<Item> LAVENDER_SALAD = HELPER.createItem("lavender_salad", () -> new Item(PropertyUtil.food(WDFoods.LAVENDER_SALAD)));
    public static final RegistryObject<Item> SNOW_CONE = HELPER.createItem("snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.SNOW_CONE)));
    public static final RegistryObject<Item> MELON_SNOW_CONE = HELPER.createItem("melon_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.MELON_SNOW_CONE)));
    public static final RegistryObject<Item> PUMPKIN_SNOW_CONE = HELPER.createItem("pumpkin_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.PUMPKIN_SNOW_CONE)));
    public static final RegistryObject<Item> CHOCOLATE_SNOW_CONE = HELPER.createItem("chocolate_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.CHOCOLATE_SNOW_CONE)));
    public static final RegistryObject<Item> CHORUS_SNOW_CONE = HELPER.createItem("chorus_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.CHORUS_SNOW_CONE)));
    public static final RegistryObject<Item> RAINBOW_SNOW_CONE = HELPER.createItem("rainbow_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.SNOW_CONE).rarity(Rarity.UNCOMMON)));

}
