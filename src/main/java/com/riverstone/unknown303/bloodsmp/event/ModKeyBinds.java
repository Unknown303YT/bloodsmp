package com.riverstone.unknown303.bloodsmp.event;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinds {
    public static final KeyBinding adminMaceModeBinding =
            KeyBindingHelper.registerKeyBinding(new KeyBinding(
                    "key.bloodsmp.admin_mace_mode",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_R,
                    "key_category.bloodsmp.bloodsmp_keys"));
}
