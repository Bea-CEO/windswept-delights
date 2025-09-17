package com.rosemods.windswept_delights.core.data.server.tags;

import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import vectorwing.farmersdelight.common.tag.ModTags;

public class WDBlockTagProvider extends BlockTagsProvider {

    public WDBlockTagProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), WindsweptDelights.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(WDBlocks.HOLLY_CABINET.get(), WDBlocks.CHESTNUT_CABINET.get(), WDBlocks.PINE_CABINET.get());
        this.tag(ModTags.MINEABLE_WITH_KNIFE).add(WindsweptBlocks.CHRISTMAS_PUDDING.get());
    }

}
