package com.rosemods.windswept_delights.core;

import com.rosemods.windswept_delights.core.data.client.WDLanguageProvider;
import com.rosemods.windswept_delights.core.data.client.WDModelProvider;
import com.rosemods.windswept_delights.core.data.server.WDLootTableProvider;
import com.rosemods.windswept_delights.core.data.server.WDRecipeProvider;
import com.rosemods.windswept_delights.core.data.server.tags.WDBlockTagProvider;
import com.rosemods.windswept_delights.core.data.server.tags.WDItemTagProvider;
import com.rosemods.windswept_delights.core.other.WDCreativeTabs;
import com.rosemods.windswept_delights.core.other.WDFoods;
import com.rosemods.windswept_delights.core.registry.WDItems;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WindsweptDelights.MOD_ID)
public class WindsweptDelights {
    public static final String MOD_ID = "windswept_delights";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public WindsweptDelights() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        REGISTRY_HELPER.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::dataSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WDCreativeTabs.setupTabEditors();
            WDFoods.modifyFoodValues();
            DataUtil.registerCompostable(WDItems.CHRISTMAS_PUDDING_SLICE.get(), .85f);
        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        boolean client = event.includeClient();
        boolean server = event.includeServer();

        gen.addProvider(client, new WDLanguageProvider(event));
        gen.addProvider(client, new WDModelProvider(event));

        WDBlockTagProvider blockTags;
        gen.addProvider(server, blockTags = new WDBlockTagProvider(event));
        gen.addProvider(server, new WDItemTagProvider(event, blockTags));
        gen.addProvider(server, new WDRecipeProvider(event));
        gen.addProvider(server, new WDLootTableProvider(event));
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
