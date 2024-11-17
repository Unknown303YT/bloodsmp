package com.riverstone.unknown303.bloodsmp;

import com.riverstone.unknown303.bloodsmp.integration.BloodModConfig;
import com.riverstone.unknown303.bloodsmp.item.ModItemGroups;
import com.riverstone.unknown303.bloodsmp.item.ModItems;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BloodMod implements ModInitializer {
	public static final String MOD_ID = "bloodsmp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static BloodModConfig CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(BloodModConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(BloodModConfig.class).getConfig();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}

	public static BloodModConfig getConfig() {
		return CONFIG;
	}
}