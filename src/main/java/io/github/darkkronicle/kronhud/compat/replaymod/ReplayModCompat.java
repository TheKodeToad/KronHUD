package io.github.darkkronicle.kronhud.compat.replaymod;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameMode;

public class ReplayModCompat {

    private static final boolean ACTIVE = FabricLoader.getInstance().isModLoaded("replaymod");

    /**
     * @return <code>true</code> if the player is probably in a replay. There is
     *         currently no better way to do this.
     */
    public static boolean isInReplay() {
        // If ReplayMod is not present, skip the checks entirely.
        if(!ACTIVE) {
            return false;
        }

        MinecraftClient client = MinecraftClient.getInstance();
        return client.world != null && !client.isIntegratedServerRunning() && client.getCurrentServerEntry() == null
                && client.interactionManager != null && client.interactionManager.getCurrentGameMode() == GameMode.SPECTATOR;
    }

}
