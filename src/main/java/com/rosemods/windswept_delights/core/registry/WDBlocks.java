package com.rosemods.windswept_delights.core.registry;

import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;

@Mod.EventBusSubscriber(modid = WindsweptDelights.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WDBlocks {
    public static final BlockSubRegistryHelper HELPER = WindsweptDelights.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> HOLLY_CABINET = HELPER.createFuelBlock("holly_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.5f).sound(SoundType.CHERRY_WOOD).ignitedByLava()), 300);
    public static final RegistryObject<Block> CHESTNUT_CABINET = HELPER.createFuelBlock("chestnut_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.5f).sound(SoundType.WOOD).ignitedByLava()), 300);
    public static final RegistryObject<Block> PINE_CABINET = HELPER.createFuelBlock("pine_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.5f).sound(SoundType.WOOD).ignitedByLava()), 300);

}
