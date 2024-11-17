package com.riverstone.unknown303.bloodsmp.item.custom;

import com.riverstone.unknown303.bloodsmp.BloodMod;
import com.riverstone.unknown303.bloodsmp.item.ModItems;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.UUID;

public class HeartItem extends Item {
    public HeartItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (stack.getItem() != ModItems.HEART) {
            return ActionResult.PASS;
        }
        EntityAttributeInstance instance = user.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        assert instance != null;
        if (instance.getValue() == BloodMod.getConfig().getHeartCap()) {
            user.sendMessage(Text.translatable("msg.bloodsmp.max_hearts"), false);
            return ActionResult.PASS;
        }
        EntityAttributeModifier modifier = new EntityAttributeModifier(
                Identifier.of(BloodMod.MOD_ID, "max_health_mod"),
                1D,
                EntityAttributeModifier.Operation.ADD_VALUE
        );
        instance.addPersistentModifier(modifier);
        AttributeContainer attributeContainer = new AttributeContainer(PlayerEntity.createPlayerAttributes()..build());
        user.getAttributes().
        stack.decrementUnlessCreative(1, user);
        return ActionResult.CONSUME;
    }
}
