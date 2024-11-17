package com.riverstone.unknown303.bloodsmp.item;

import com.riverstone.unknown303.bloodsmp.BloodMod;
import com.riverstone.unknown303.bloodsmp.item.custom.BloodBottleItem;
import com.riverstone.unknown303.bloodsmp.item.custom.HeartItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLOOD_BOTTLE = registerItem("blood_bottle",
            new BloodBottleItem(new Item.Settings().useRemainder(Items.GLASS_BOTTLE)
                    .registryKey(createRegistryKey("blood_bottle"))));
    public static final Item HEART = registerItem("heart",
            new HeartItem(new Item.Settings()
                    .registryKey(createRegistryKey("heart"))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BloodMod.MOD_ID, name), item);
    }

    private static RegistryKey<Item> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BloodMod.MOD_ID, name));
    }

    public static void registerModItems() {
        BloodMod.LOGGER.info("Registering Mod Items for " + BloodMod.MOD_ID);
    }
}
