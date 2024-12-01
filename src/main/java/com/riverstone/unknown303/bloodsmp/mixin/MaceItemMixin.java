package com.riverstone.unknown303.bloodsmp.mixin;

import com.riverstone.unknown303.bloodsmp.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(Item.class)
public class MaceItemMixin {
    @Inject(method = "use", at = @At("HEAD"))
    public void onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack stack = user.getStackInHand(hand);
        PlayerInventory inventory = user.getInventory();

        if (stack.getItem() instanceof MaceItem) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) user;
            boolean isOp = Objects.requireNonNull(serverPlayer.getServer()).getPlayerManager().isOperator(serverPlayer.getGameProfile());
            if (isOp) {
                ItemStack newStack = stack.copyComponentsToNewStack(ModItems.ADMIN_MACE, stack.getCount());
                inventory.setStack(inventory.getSlotWithStack(stack), newStack);
                user.sendMessage(Text.translatable("msg.bloodsmp.change_mace.success"), true);
            } else {
                user.sendMessage(Text.translatable("msg.bloodsmp.change_mace.fail"), true);
            }
        }
    }
}
