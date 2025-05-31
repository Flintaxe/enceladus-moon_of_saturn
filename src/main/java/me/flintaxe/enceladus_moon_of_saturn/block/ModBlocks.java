package me.flintaxe.enceladus_moon_of_saturn.block;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EnceladusMoonOfSaturn.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
