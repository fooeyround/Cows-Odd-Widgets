package xyz.mrcow.cowsOddWidgets;

import fi.dy.masa.malilib.interfaces.IClientTickHandler;
import net.minecraft.client.MinecraftClient;
import xyz.mrcow.cowsOddWidgets.config.Configs;
import xyz.mrcow.cowsOddWidgets.features.AgreeMode;
import xyz.mrcow.cowsOddWidgets.features.AutoTotem;
import xyz.mrcow.cowsOddWidgets.features.DerpMode;

public class ClientTickHandler implements IClientTickHandler {

    @Override
    public void onClientTick(MinecraftClient mc){
        if (mc.world != null && mc.player != null){
            if(Configs.Settings.DERP_MODE.getBooleanValue() == true){
                DerpMode.doDerp(mc);
            } else if(Configs.Settings.AGREE_MODE.getBooleanValue() == true){
                AgreeMode.Agree(mc);
            }

            if(Configs.Settings.AUTO_TOTEM.getBooleanValue() == true){
                AutoTotem.update(mc);
            }
            if(Configs.Settings.STEP_MODE.getBooleanValue() == true){
                mc.player.stepHeight = 1F;
            } else {
                mc.player.stepHeight = 0.5F;
            }
        }
    }
}
