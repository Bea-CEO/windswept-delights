package com.rosemods.windswept_delights.core.data.server.tags;

import com.rosemods.windswept.core.other.tags.WindsweptItemTags;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import com.rosemods.windswept_delights.core.registry.WDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import vectorwing.farmersdelight.common.tag.ModTags;

public class WDItemTagProvider extends ItemTagsProvider {

    public WDItemTagProvider(GatherDataEvent event, WDBlockTagProvider blockTags) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), blockTags.contentsGetter(), WindsweptDelights.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.WOODEN_CABINETS).add(WDBlocks.HOLLY_CABINET.get().asItem(), WDBlocks.CHESTNUT_CABINET.get().asItem(), WDBlocks.PINE_CABINET.get().asItem());
        this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS).addTag(WindsweptItemTags.RAW_GOAT);
        this.tag(WindsweptItemTags.RAW_GOAT).add(WDItems.GOAT_SHANKS.get());
        this.tag(WindsweptItemTags.COOKED_GOAT).add(WDItems.COOKED_GOAT_SHANKS.get());
    }

}
