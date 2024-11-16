package com.riverstone.unknown303.bloodsmp.item;

import com.riverstone.unknown303.bloodsmp.BloodMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLOOD_BOTTLE = registerItem("blood_bottle",
            new Item(new Item.Settings()
                    .registryKey(createRegistryKey(Identifier.of(BloodMod.MOD_ID, "blood_bottle")))));

    private static Item registerItem(String name, Item item) {
        Identifier id = Identifier.of(BloodMod.MOD_ID, name);
        return Registry.register(Registries.ITEM, id, item);
    }

    private static RegistryKey<Item> createRegistryKey(Identifier id) {
        return RegistryKey.of(RegistryKeys.ITEM, id);
    }

    public static void registerModItems() {
        BloodMod.LOGGER.info("Registering Mod Items for " + BloodMod.MOD_ID);
    }
}
