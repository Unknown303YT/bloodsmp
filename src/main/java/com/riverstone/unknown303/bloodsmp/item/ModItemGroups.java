package com.riverstone.unknown303.bloodsmp.item;

import com.riverstone.unknown303.bloodsmp.BloodMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BLOODSMP_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BloodMod.MOD_ID, "items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLOOD_BOTTLE))
                    .displayName(Text.translatable("itemgroup.bloodsmp.bloodsmp_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLOOD_BOTTLE);
                    })
                    .build());

    public static void registerItemGroups() {
        BloodMod.LOGGER.info("Registering Item Groups for " + BloodMod.MOD_ID);
    }
}
