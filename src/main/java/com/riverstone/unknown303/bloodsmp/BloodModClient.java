package com.riverstone.unknown303.bloodsmp;

import com.riverstone.unknown303.bloodsmp.event.ModKeyBinds;
import com.riverstone.unknown303.bloodsmp.item.ModItems;
import com.riverstone.unknown303.bloodsmp.item.custom.AdminMaceItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class BloodModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ModKeyBinds.adminMaceModeBinding.wasPressed()) {
                if (client.player != null) {
                    activateAdminMaceModeKeyBind(client.player);
                }
            }
        });
    }

    private void activateAdminMaceModeKeyBind(PlayerEntity player) {
        if (!(player.getMainHandStack().getItem() == ModItems.ADMIN_MACE)) {
            player.sendMessage(Text.translatable("msg.bloodsmp.change_mode.incorrect_item"), true);
            return;
        }
        ItemStack itemStack = player.getMainHandStack();
        AdminMaceItem item = (AdminMaceItem) itemStack.getItem();
        item.updateAdminMaceMode(player);
    }
}
