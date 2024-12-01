package com.riverstone.unknown303.bloodsmp.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class AdminMaceItem extends MaceItem {
    AdminMaceMode maceMode;

    public AdminMaceItem(Settings settings, AdminMaceMode defaultMode) {
        super(settings);
        this.maceMode = defaultMode;
    }

    public void updateAdminMaceMode(PlayerEntity player) {
        this.maceMode = AdminMaceMode.updateAdminMaceMode(this.maceMode, player);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (shouldDealAdditionalDamage(attacker)) {
            switch (this.maceMode) {
                case INSTANT_KILL:
                    target.kill((ServerWorld) target.getWorld());
                case REMOVE_EFFECTS:
                    target.removeStatusEffect()
            }
        }
    }

    public static enum AdminMaceMode {
        SWITCH_TO_NORMAL,
        INSTANT_KILL,
        REMOVE_EFFECTS,
        KICK,
        BAN;

        public static AdminMaceMode updateAdminMaceMode(AdminMaceMode oldMode, PlayerEntity player) {
            AdminMaceMode toReturn = SWITCH_TO_NORMAL;
            Text messageText = Text.empty();
            switch (oldMode) {
                case SWITCH_TO_NORMAL:
                    toReturn = INSTANT_KILL;
                    messageText = Text.translatable("msg.bloodsmp.change_mode.instant_kill");
                case INSTANT_KILL:
                    toReturn = REMOVE_EFFECTS;
                    messageText = Text.translatable("msg.bloodsmp.change_mode.remove_effects");
                case REMOVE_EFFECTS:
                    toReturn = KICK;
                    messageText = Text.translatable("msg.bloodsmp.change_mode.kick");
                case KICK:
                    toReturn = BAN;
                    messageText = Text.translatable("msg.bloodsmp.change_mode.ban");
                case BAN:
                    toReturn = SWITCH_TO_NORMAL;
                    messageText = Text.translatable("msg.bloodsmp.change_mode.switch_normal");
            };
            player.sendMessage(messageText, true);
            return toReturn;
        }
    }
}
