package com.rosemods.windswept_delights.core.data.client;

import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rosemods.windswept_delights.core.registry.WDBlocks.*;
import static com.rosemods.windswept_delights.core.registry.WDItems.*;

public class WDModelProvider extends BlueprintBlockStateProvider {
    public WDModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), WindsweptDelights.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerStatesAndModels() {
        this.generatedItem(GOAT_SHANKS);
        this.generatedItem(COOKED_GOAT_SHANKS);
        this.generatedItem(CHRISTMAS_PUDDING_SLICE);
        this.generatedItem(CHESTNUT_RISOTTO);
        this.generatedItem(WILD_BERRY_POPSICLE);
        this.generatedItem(LAVENDER_SALAD);
        this.generatedItem(SNOW_CONE);
        this.generatedItem(MELON_SNOW_CONE);
        this.generatedItem(PUMPKIN_SNOW_CONE);
        this.generatedItem(CHOCOLATE_SNOW_CONE);
        this.generatedItem(CHORUS_SNOW_CONE);
        this.generatedItem(RAINBOW_SNOW_CONE);
        this.generatedItem(MIMOSA_SOUP);
        this.generatedItem(WILD_BERRY_JUICE);

        this.cabinet(HOLLY_CABINET);
        this.cabinet(CHESTNUT_CABINET);
        this.cabinet(PINE_CABINET);
    }

    private void itemModel(RegistryObject<Block> block) {
        this.itemModels().withExistingParent(getName(block.get()), this.blockTexture(block.get()));
    }

    private void generatedItem(RegistryObject<? extends ItemLike> item) {
        String name = getName(item.get());
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", WindsweptDelights.location("item/" + name));
    }

    private void cabinet(RegistryObject<Block> cabinet) {
        String name = getName(cabinet.get());
        ModelFile model = this.models().orientable(name, this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front"), this.modLoc("block/" + name + "_end"));
        ModelFile model_open = this.models().orientable(name + "_open", this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front_open"), this.modLoc("block/" + name + "_end"));

        this.horizontalBlock(cabinet.get(), s -> s.getValue(BlockStateProperties.OPEN) ? model_open : model);
        this.itemModel(cabinet);
    }

    private static String getName(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
    }

}
