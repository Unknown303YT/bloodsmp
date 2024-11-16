package com.riverstone.unknown303.bloodsmp;

import com.riverstone.unknown303.bloodsmp.item.ModItemGroups;
import com.riverstone.unknown303.bloodsmp.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BloodMod implements ModInitializer {
	public static final String MOD_ID = "bloodsmp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}