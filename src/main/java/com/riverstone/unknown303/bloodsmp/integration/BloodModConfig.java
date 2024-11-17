package com.riverstone.unknown303.bloodsmp.integration;

import com.riverstone.unknown303.bloodsmp.BloodMod;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = BloodMod.MOD_ID)
public class BloodModConfig implements ConfigData {
    double heartCap = 20D;

    public double getHeartCap() {
        return heartCap;
    }
}
