package com.rosemods.windswept_delights.core.data.server;

import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

import static com.rosemods.windswept.core.registry.WindsweptBlocks.*;
import static com.rosemods.windswept.core.registry.WindsweptItems.WILD_BERRIES;
import static com.rosemods.windswept_delights.core.registry.WDBlocks.*;
import static com.rosemods.windswept_delights.core.registry.WDItems.*;
import static vectorwing.farmersdelight.common.registry.ModItems.MELON_POPSICLE;
import static vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE;

public class WDRecipeProvider extends BlueprintRecipeProvider {

    public WDRecipeProvider(GatherDataEvent event) {
        super(WindsweptDelights.MOD_ID, event.getGenerator().getPackOutput());
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        cabinet(HOLLY_CABINET.get(), HOLLY_SLAB.get(), HOLLY_TRAPDOOR.get(), consumer);
        cabinet(CHESTNUT_CABINET.get(), CHESTNUT_SLAB.get(), CHESTNUT_TRAPDOOR.get(), consumer);
        cabinet(PINE_CABINET.get(), PINE_SLAB.get(), PINE_TRAPDOOR.get(), consumer);

        cooking(GOAT_SHANKS.get(), COOKED_GOAT_SHANKS.get(), consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.SUGAR).requires(WILD_BERRY_JUICE.get()).unlockedBy(getHasName(WILD_BERRY_JUICE.get()), has(WILD_BERRY_JUICE.get())).save(consumer, getSaveLocation("sugar_from_wild_berry_juice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, WILD_BERRY_JUICE.get()).requires(WILD_BERRIES.get(), 4).requires(Items.GLASS_BOTTLE).unlockedBy(getHasName(WILD_BERRIES.get()), has(WILD_BERRIES.get())).save(consumer, getSaveLocation(WILD_BERRY_JUICE.get()));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, WILD_BERRY_POPSICLE.get()).define('#', WILD_BERRIES.get()).define('S', Items.STICK).define('I', ICICLES.get()).pattern(" ##").pattern("I##").pattern("SI ").unlockedBy(getHasName(WILD_BERRIES.get()), has(WILD_BERRIES.get())).save(consumer, getSaveLocation(WILD_BERRY_POPSICLE.get()));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MELON_POPSICLE.get()).define('#', Items.MELON_SLICE).define('S', Items.STICK).define('I', ICICLES.get()).pattern(" ##").pattern("I##").pattern("SI ").unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(consumer, getSaveLocation("melon_popsicle_from_icicles"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CHRISTMAS_PUDDING.get()).requires(CHRISTMAS_PUDDING_SLICE.get(), 4).unlockedBy(getHasName(CHRISTMAS_PUDDING_SLICE.get()), has(CHRISTMAS_PUDDING_SLICE.get())).save(consumer, getSaveLocation("christmas_pudding_from_slices"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LAVENDER_SALAD.get()).requires(Items.BOWL).requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE).requires(LAVENDER.get()).requires(ForgeTags.CROPS_TOMATO).requires(Items.CARROT).unlockedBy(getHasName(LAVENDER.get()), has(LAVENDER.get())).save(consumer, getSaveLocation(LAVENDER_SALAD.get()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SNOW_CONE.get()).requires(PINECONE.get()).requires(Items.HONEY_BOTTLE).requires(Items.SNOWBALL).requires(Items.SUGAR).unlockedBy(getHasName(Items.HONEY_BOTTLE), has(Items.HONEY_BOTTLE)).save(consumer, getSaveLocation(SNOW_CONE.get()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MELON_SNOW_CONE.get()).requires(PINECONE.get()).requires(Items.MELON_SLICE).requires(Items.SNOWBALL).requires(Items.SUGAR).unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(consumer, getSaveLocation(MELON_SNOW_CONE.get()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PUMPKIN_SNOW_CONE.get()).requires(PINECONE.get()).requires(PUMPKIN_SLICE.get()).requires(Items.SNOWBALL).requires(Items.SUGAR).unlockedBy(getHasName(PUMPKIN_SLICE.get()), has(PUMPKIN_SLICE.get())).save(consumer, getSaveLocation(PUMPKIN_SNOW_CONE.get()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CHOCOLATE_SNOW_CONE.get()).requires(PINECONE.get()).requires(Items.COCOA_BEANS).requires(Items.SNOWBALL).requires(Items.SUGAR).unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS)).save(consumer, getSaveLocation(CHOCOLATE_SNOW_CONE.get()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CHORUS_SNOW_CONE.get()).requires(PINECONE.get()).requires(Items.CHORUS_FRUIT).requires(Items.SNOWBALL).requires(Items.SUGAR).unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT)).save(consumer, getSaveLocation(CHORUS_SNOW_CONE.get()));
    }

    private static void cabinet(Block cabinet, Block slab, Block trapdoor, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, cabinet).define('#', slab).define('T', trapdoor).pattern("###").pattern("T T").pattern("###").unlockedBy(getHasName(trapdoor), has(trapdoor)).save(consumer, getSaveLocation(cabinet));
    }

    private static void cooking(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, .35f, 200).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(result));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, .35f, 600).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(result) + "_from_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, .35f, 100).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(result) + "_from_smoking"));
    }

    private static ResourceLocation getSaveLocation(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem());
    }

    private static ResourceLocation getSaveLocation(String name) {
        return WindsweptDelights.location(name);
    }

    private static String getName(ItemLike object) {
        return getSaveLocation(object).getPath();
    }

}
