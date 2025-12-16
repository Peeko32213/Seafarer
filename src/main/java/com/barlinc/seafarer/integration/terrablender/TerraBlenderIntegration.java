package com.barlinc.seafarer.integration.terrablender;

import com.barlinc.seafarer.registry.SeafarerSurfaceRules;
import terrablender.api.SurfaceRuleManager;

public class TerraBlenderIntegration {

    public static void register() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "seafarer", SeafarerSurfaceRules.makeRules());
    }
}
