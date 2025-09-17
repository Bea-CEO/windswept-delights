package com.rosemods.windswept_delights.core.data.client;

import com.google.common.collect.Lists;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.codehaus.plexus.util.StringUtils;

import java.util.List;
import java.util.function.Function;

public class WDLanguageProvider extends LanguageProvider {
    private final List<String> keys = Lists.newArrayList();

    public WDLanguageProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), WindsweptDelights.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(WDItems.CHRISTMAS_PUDDING_SLICE.get(), "Slice of Christmas Pudding");
        this.add(WDItems.GOAT_SHANKS.get(), "Raw Chevon Shanks");
        this.add(WDItems.COOKED_GOAT_SHANKS.get(), "Cooked Chevon Shanks");

        this.translateRegistry(ForgeRegistries.BLOCKS, Block::getDescriptionId);
        this.translateRegistry(ForgeRegistries.ITEMS, Item::getDescriptionId);
    }

    private <T> void translateRegistry(IForgeRegistry<T> registry, Function<T, String> toString) {
        for (RegistryObject<T> object : WindsweptDelights.REGISTRY_HELPER.getSubHelper(registry).getDeferredRegister().getEntries())
            this.add(toString.apply(object.get()), toUpper(registry, object));
    }

    @Override
    public void add(String key, String value) {
        if (!this.keys.contains(key)) {
            super.add(key, value);
            this.keys.add(key);
        }
    }

    private static <T> String toUpper(IForgeRegistry<T> registry, RegistryObject<? extends T> object) {
        return toUpper(registry.getKey(object.get()).getPath());
    }

    private static String toUpper(String string) {
        return StringUtils.capitaliseAllWords(string.replace('_', ' '));
    }

}
